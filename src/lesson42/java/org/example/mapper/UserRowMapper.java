package lesson42.java.org.example.mapper;

import org.example.model.Address;
import org.example.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRowMapper implements RowMapper<User> {

    private final AddressRowMapper addressRowMapper;

    public UserRowMapper(AddressRowMapper addressRowMapper) {
        this.addressRowMapper = addressRowMapper;
    }

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        List<Address> addresses = new ArrayList<>();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));

        return user;
    }
}
