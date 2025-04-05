package dao;

import dto.BookDto;
import entity.Book;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao implements Dao<Book, BookDto> {

    private static final BookDao INSTANCE = new BookDao();

    private BookDao() {
    }

    @Override
    public Book save(BookDto bookDto) {

        String sqlRequest = """
                INSERT INTO library.books (title, author, published_year, genre)
                VALUES (?,?,?,?)
                RETURNING book_id, title, author, published_year, genre;
                """;

        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            preparedStatement.setString(1, bookDto.getTitle());
            preparedStatement.setString(2, bookDto.getAuthor());
            preparedStatement.setInt(3, bookDto.getPublishedYear());
            preparedStatement.setString(4, bookDto.getGenre());

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return buildBook(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save book.", e);
        }
    }

    public static BookDao getInstance() {
        return INSTANCE;
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
}
