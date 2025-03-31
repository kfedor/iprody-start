package dao;

import dto.ReaderDto;
import entity.Reader;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReaderDao implements Dao<Reader, ReaderDto> {

    private static final ReaderDao INSTANCE = new ReaderDao();

    private ReaderDao() {
    }

    @Override
    public Reader save(ReaderDto readerDto) {

        String sqlRequest = """
                INSERT INTO library.readers (name, email, phone)
                VALUES (?,?,?)
                RETURNING reader_id, name, email, phone;
                """;

        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            preparedStatement.setString(1, readerDto.getName());
            preparedStatement.setString(2, readerDto.getEmail());
            preparedStatement.setString(3, readerDto.getPhone());

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return buildReader(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save reader.", e);
        }
    }

    private Reader buildReader(ResultSet resultSet) throws SQLException {
        return new Reader(
                resultSet.getLong("reader_id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getString("phone")
        );
    }

    public static ReaderDao getInstance() {
        return INSTANCE;
    }

}
