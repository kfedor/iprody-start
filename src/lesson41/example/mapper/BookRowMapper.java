package lesson41.example.mapper;

import org.example.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("book_id"));
        book.setTitle(rs.getString("title"));
        book.setPublishedYear(rs.getInt("published_year"));
        book.setAuthorId(rs.getInt("author_id"));
        return book;
    }
}
