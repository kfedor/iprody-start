package lesson31.service;

import lesson31.entities.Book;
import lesson31.entities.BorrowedBook;
import lesson31.entities.OccupiedBook;
import lesson31.entities.Reader;
import lesson31.service.interfaces.LibraryAPI;
import lesson31.util.ConnectionManager;
import lesson31.util.enums.BookStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class LibraryJDBC implements LibraryAPI {

    @Override
    public Book addBook(String title, String author, int publishedYear, String genre) {
        Book resultBook = new Book();
        String sqlRequest = """
                INSERT INTO library.books (title, author, published_year, genre)
                VALUES (?,?,?,?)
                RETURNING book_id, title, author, published_year, genre;
                """;

        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setInt(3, publishedYear);
            preparedStatement.setString(4, genre);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                resultBook = createBookFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add book.", e);
        }
        if (resultBook.getBookId() == 0) {
            throw new RuntimeException("Book already exists.");
        }
        return resultBook;
    }

    @Override
    public BorrowedBook updateBookStatus(BorrowedBook borrowedBook, BookStatus newStatus) {
        String sqlRequest = """
                UPDATE library.borrowed_books
                SET status = ?
                WHERE book_id = ?
                RETURNING status;
                """;

        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            preparedStatement.setObject(1, newStatus.name().toLowerCase(), Types.OTHER);
            preparedStatement.setInt(2, borrowedBook.getBook().getBookId());

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            borrowedBook.setStatus(BookStatus.valueOf(resultSet.getString("status")));
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find such book", e);
        }
        return borrowedBook;
    }

    @Override
    public Reader addExistedReaderToDatabase(Reader reader) {
        if (reader.getReaderId() != 0) {
            return reader;
        }

        String sqlRequest = """
                INSERT INTO library.reader (name, email, phone)
                VALUES (?,?,?)
                """;

        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, reader.getName());
            preparedStatement.setString(2, reader.getEmail());
            preparedStatement.setString(3, reader.getPhone());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            int insertedId = generatedKeys.getInt("reader_id");
            reader.setReaderId(insertedId);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add reader.", e);
        }
        return reader;
    }

    @Override
    public List<OccupiedBook> getAllOccupiedBooks() {
        List<OccupiedBook> occupiedBooks = new ArrayList<>();

        String sqlRequest = """
                SELECT
                    books.book_id,
                    books.title,
                    books.author,
                    books.published_year,
                    books.genre,
                    readers.reader_id,
                    readers.name,
                    readers.email,
                    readers.phone
                FROM library.books
                JOIN library.borrowed_books ON books.book_id = borrowed_books.book_id
                JOIN library.readers ON readers.reader_id = borrowed_books.reader_id
                WHERE borrowed_books.status = 'borrowed';
                """;
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = createBookFromResultSet(resultSet);
                Reader reader = createReaderFromResultSet(resultSet);
                OccupiedBook occupiedBook = new OccupiedBook(book, reader);
                occupiedBooks.add(occupiedBook);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return occupiedBooks;
    }

    @Override
    public Reader updateReadersData(Reader reader, String email, String phone) {
        String sqlRequest = """
                update library.readers
                set email = ?
                set phone = ?
                where reader_id = ?;
                """;
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, phone);
            preparedStatement.setInt(3, reader.getReaderId());

            preparedStatement.executeUpdate();

            reader.setEmail(email);
            reader.setPhone(phone);

        } catch (SQLException e) {
            throw new RuntimeException("Failed to update readers' data.", e);
        }
        return reader;
    }

    @Override
    public List<Book> booksWithDefinedStatus(BookStatus status) {
        String sqlRequest = """
                SELECT
                    books.book_id,
                    books.title,
                    books.author,
                    books.published_year,
                    books.genre
                FROM library.books
                JOIN library.borrowed_books ON books.book_id = borrowed_books.book_id
                WHERE borrowed_books.status = ?;
                """;
        List<Book> resultListOfBooks = new ArrayList<>();

        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            preparedStatement.setObject(1, status.name().toLowerCase(), Types.OTHER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = createBookFromResultSet(resultSet);
                resultListOfBooks.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the book.", e);
        }
        return resultListOfBooks;
    }

    @Override
    public List<Book> findBorrowedBooksAfterDate(String date) {
        String sqlRequest = """
                SELECT
                    books.book_id,
                    books.title,
                    books.author,
                    books.published_year,
                    books.genre
                FROM library.books
                JOIN library.borrowed_books ON books.book_id = borrowed_books.book_id
                WHERE borrowed_books.borrow_date > ?
                AND borrowed_books.status = 'borrowed';
                """;
        List<Book> resultListOfBooks = new ArrayList<>();

        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            preparedStatement.setString(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = createBookFromResultSet(resultSet);
                resultListOfBooks.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find books.", e);
        }
        return resultListOfBooks;
    }

    private Book createBookFromResultSet(ResultSet resultSet) throws SQLException {
        Book resultBook = new Book();
        resultBook.setBookId(resultSet.getInt("book_id"));
        resultBook.setTitle(resultSet.getString("title"));
        resultBook.setAuthor(resultSet.getString("author"));
        resultBook.setPublishedYear(resultSet.getInt("published_year"));
        resultBook.setGenre(resultSet.getString("genre"));
        return resultBook;
    }

    private Reader createReaderFromResultSet(ResultSet resultSet) throws SQLException {
        Reader reader = new Reader();
        reader.setReaderId(resultSet.getInt("reader_id"));
        reader.setName(resultSet.getString("name"));
        reader.setEmail(resultSet.getString("email"));
        reader.setPhone(resultSet.getString("phone"));
        return reader;
    }
}
