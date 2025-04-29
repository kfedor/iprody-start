package lesson41.example.dao;

import org.example.mapper.AuthorRowMapper;
import org.example.mapper.BookRowMapper;
import org.example.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcAuthorDao implements AuthorDao {

    private final JdbcTemplate jdbcTemplate;
    private final AuthorRowMapper authorRowMapper;

    @Autowired
    public JdbcAuthorDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.authorRowMapper = new AuthorRowMapper(new BookRowMapper());
    }

    @Override
    public Author findById(Long id) {
        String sql = """
                SELECT
                a.id as author_id,
                a.name,
                a.country,
                b.id as book_id,
                b.title,
                b.published_year,
                b.author_id
                FROM library2.authors a
                JOIN library2.books b on a.id = b.author_id
                WHERE a.id = ?
                """;
        return jdbcTemplate.queryForObject(sql, authorRowMapper, id);
    }

    @Override
    public List<Author> findAll() {
        String sql = """
                SELECT
                a.id as author_id,
                a.name,
                a.country,
                b.id as book_id,
                b.title,
                b.published_year,
                b.author_id
                FROM library2.authors a
                JOIN library2.books b on a.id = b.author_id;
                """;
        return jdbcTemplate.query(sql, authorRowMapper);
    }

    @Override
    public void save(Author author) {
        String sql = "INSERT into library2.authors (name, country " +
                     "VALUES (?, ?)";
        jdbcTemplate.update(sql, author.getName(), author.getCountry());
    }

    @Override
    public void update(Author author) {
        String sql = "UPDATE library2.authors set name = ?, country = ? where id = ? ";
        jdbcTemplate.update(sql, author.getName(), author.getCountry(), author.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM library2.authors where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
