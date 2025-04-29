package lesson41.example.dao;

import org.example.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcBookDao implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcBookDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Book findById(Long id) {
        String sql = "SELECT * FROM library2.books WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM library2.books";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public void save(Book book) {
        String sql = "INSERT into library2.books (title, published_year, author_id " +
                     "VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, book.getTitle(), book.getPublishedYear(), book.getAuthorId());
    }

    @Override
    public void update(Book book) {
        String sql = "UPDATE library2.books set title = ?, published_year = ?, author_id = ? where id = ?";
        jdbcTemplate.update(sql, book.getTitle(), book.getPublishedYear(), book.getAuthorId(), book.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM library2.books WHERE id = ? ";
        jdbcTemplate.update(sql, id);
    }
}
