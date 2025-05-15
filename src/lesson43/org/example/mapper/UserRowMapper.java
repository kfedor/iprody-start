package lesson43.org.example.mapper;

import org.example.model.Authority;
import org.example.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRowMapper implements RowMapper<User> {

    private final JdbcTemplate template;

    public UserRowMapper(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setEnabled(rs.getBoolean("enabled"));

        List<Authority> authorities = template.query(
                "SELECT a.id, a.authority from users.authorities a where a.user_id = ?",
                (rsAuth, rowNumAuth) -> {
                    Authority authority = new Authority();
                    authority.setId(rsAuth.getInt("id"));
                    authority.setAuthority(rsAuth.getString("authority"));
                    return authority;
                },
                user.getId()
        );
        user.setAuthorities(authorities);
        user.setAddresses(new ArrayList<>());

        return user;
    }
}
