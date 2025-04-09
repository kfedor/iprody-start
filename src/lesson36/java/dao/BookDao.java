package lesson36.java.dao;

import dto.BookDto;
import entity.Book;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao implements Dao<Book, BookDto> {

    private static final BookDao INSTANCE = new BookDao();

    private BookDao() {
    }

    @Override
    public Book save(BookDto bookDto) {

        String sqlRequest = """
                INSERT INTO library.books (title, author)
                VALUES (?,?)
                RETURNING book_id, title, author;
                """;

        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            preparedStatement.setString(1, bookDto.getTitle());
            preparedStatement.setString(2, bookDto.getAuthor());

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return buildBook(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save book.", e);
        }
    }

    public List<Book> getAllBooksByReaderId(Long readerId) {
        String sqlRequest = """
                SELECT
                    books.book_id,
                    books.title,
                    books.author,
                    books.published_year,
                    books.genre
                FROM library.books
                JOIN library.borrowed_books ON books.book_id = borrowed_books.book_id
                WHERE reader_id = ?;
                """;
        List<Book> resultListOfBooks = new ArrayList<>();

        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            preparedStatement.setObject(1, readerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = buildBook(resultSet);
                resultListOfBooks.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the book.", e);
        }
        return resultListOfBooks;

    }

    public static BookDao getInstance() {
        return INSTANCE;
    }

    private Book buildBook(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setBookId(resultSet.getLong("book_id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        if (resultSet.getInt("published_year") != 0) {
            book.setPublishedYear(resultSet.getInt("published_year"));
        }
        if (resultSet.getString("genre") != null) {
            book.setGenre(resultSet.getString("genre"));
        }

        return book;
    }
}
