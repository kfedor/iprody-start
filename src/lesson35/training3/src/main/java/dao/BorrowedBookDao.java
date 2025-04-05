package dao;

import dto.BorrowedBookDto;
import entity.Book;
import entity.BookStatus;
import entity.BorrowedBook;
import entity.Reader;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.Optional;

public class BorrowedBookDao implements Dao<BorrowedBook, BorrowedBookDto> {

    private static final BorrowedBookDao INSTANCE = new BorrowedBookDao();

    @Override
    public BorrowedBook save(BorrowedBookDto borrowedBookDto) {
        String sqlRequest = """
                INSERT INTO library.borrowed_books (book_id, reader_id, borrow_date, return_date, status)
                VALUES (?,?,?,?,?)
                RETURNING borrow_id, book_id, reader_id, borrow_date, return_date, status;
                """;

        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            preparedStatement.setObject(1, borrowedBookDto.getBookId());
            preparedStatement.setObject(2, borrowedBookDto.getReaderId());
            preparedStatement.setObject(3, borrowedBookDto.getBorrowDate());
            preparedStatement.setObject(4, borrowedBookDto.getReturnDate().orElse(null), Types.DATE);
            preparedStatement.setObject(5, borrowedBookDto.getStatus().name().toLowerCase(), Types.OTHER);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return buildBorrowBook(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save borrowedBook.", e);
        }
    }

    private BorrowedBook buildBorrowBook(ResultSet resultSet) throws SQLException {
        LocalDate returnDate = Optional.ofNullable(resultSet.getDate("return_date"))
                .map(java.sql.Date::toLocalDate)
                .orElse(null);

            return new BorrowedBook(
                    resultSet.getLong("borrow_id"),
                    getBookById(resultSet.getLong("book_id")),
                    getReaderById(resultSet.getLong("reader_id")),
                    resultSet.getDate("borrow_date").toLocalDate(),
                    returnDate,
                    BookStatus.valueOf(resultSet.getString("status").toUpperCase()));
    }

    private Book getBookById(Long bookId) {

        String sqlRequest = """
                SELECT book_id, title, author, published_year, genre
                FROM library.books 
                WHERE book_id = ?;
                """;

        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            preparedStatement.setLong(1, bookId);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return buildBook(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find book.", e);
        }
    }

    private Reader getReaderById(Long readerId) {

        String sqlRequest = """
                SELECT reader_id, name, email,phone
                FROM library.readers 
                WHERE reader_id = ?;
                """;

        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            preparedStatement.setLong(1, readerId);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return buildReader(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find reader.", e);
        }
    }

    private Book buildBook(ResultSet resultSet) throws SQLException {
        return new Book(
                resultSet.getLong("book_id"),
                resultSet.getString("title"),
                resultSet.getString("author"),
                resultSet.getInt("published_year"),
                resultSet.getString("genre")
        );
    }

    private Reader buildReader(ResultSet resultSet) throws SQLException {
        return new Reader(
                resultSet.getLong("reader_id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getString("phone")
        );
    }

    public static BorrowedBookDao getInstance() {
        return INSTANCE;
    }
}
