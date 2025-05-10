package lesson43.org.example.dao;

import org.example.mapper.AddressRowMapper;
import org.example.mapper.UserResultSetExtractor;
import org.example.mapper.UserRowMapper;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcUserDao implements UserDao {
    private final JdbcTemplate template;
    private final UserRowMapper userRowMapper;
    private final UserResultSetExtractor extractor;
    private final AddressRowMapper addressRowMapper;

    @Autowired
    public JdbcUserDao(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
        this.addressRowMapper = new AddressRowMapper();
        this.userRowMapper = new UserRowMapper(template);
        this.extractor = new UserResultSetExtractor(addressRowMapper, userRowMapper);
    }

    @Override
    public List<User> findAll() {
        String sql = """
                SELECT
                  u.id,
                  u.name,
                  u.email,
                  u.password,
                  u.enabled,
                  a.id,
                  a.city,
                  a.street,
                  a.user_id,
                  a.postal_code
                FROM users.users u
                LEFT JOIN users.addresses a ON a.user_id = u.id
                ORDER BY u.id;
                """;
        return template.query(sql, extractor);
    }

    @Override
    public User findById(int id) {
        String sql = """
                SELECT
                  u.id,
                  u.name,
                  u.email,
                  u.password,
                  u.enabled,
                  a.id,
                  a.city,
                  a.street,
                  a.user_id,
                  a.postal_code
                FROM users.users u
                LEFT JOIN users.addresses a ON a.user_id = u.id
                WHERE u.id = ?;
                """;
        List<User> users = template.query(sql, extractor, id);
        return users == null || users.isEmpty() ? null : users.getFirst();
    }

    @Override
    public void create(User user) {
        String sql = "insert into users (name, email) values (?,?)";
        template.update(sql, user.getName(), user.getEmail());
    }

    @Override
    public void update(User user) {
        String sql = "update users set name = ?, email = ? where id = ?";
        template.update(sql, user.getName(), user.getEmail(), user.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from users where id = ?";
        template.update(sql, id);
    }

    @Override
    public void create(List<User> users) {
        String sql = "insert into users (name, email) values (?,?)";

        template.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, users.get(i).getName());
                ps.setString(2, users.get(i).getEmail());
            }

            @Override
            public int getBatchSize() {
                return users.size();
            }
        });
    }

    @Override
    public User findByUsername(String username) {
        String sql = "SELECT id, name, email, password, enabled FROM users.users WHERE name = ?";
        return template.queryForObject(sql, userRowMapper, username);
    }

    @Override
    public User findBasicById(int id) {
        String sql = "SELECT name, email FROM users.users WHERE id = ?";
        return template.queryForObject(sql, userRowMapper, id);
    }
}
