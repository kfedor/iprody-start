package lesson41.example.mapper;

import org.example.model.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowMapper implements RowMapper<Author> {

    private final BookRowMapper bookRowMapper;

    public AuthorRowMapper(BookRowMapper bookRowMapper) {
        this.bookRowMapper = bookRowMapper;
    }

    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setId(rs.getInt("author_id"));
        author.setName(rs.getString("name"));
        author.setCountry(rs.getString("country"));
        author.setBook(bookRowMapper.mapRow(rs, rowNum));
        return author;
    }
}
