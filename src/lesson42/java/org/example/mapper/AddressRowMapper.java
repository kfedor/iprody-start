package lesson42.java.org.example.mapper;

import org.example.model.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressRowMapper implements RowMapper<Address> {

    @Override
    public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
        Address address = new Address();
        address.setId(rs.getInt("id"));
        address.setUser_id(rs.getInt("user_id"));
        address.setStreet(rs.getString("street"));
        address.setCity(rs.getString("city"));
        address.setPostal_code(rs.getString("postal_code"));
        return address;
    }
}
