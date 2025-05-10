package lesson43.org.example.dao;

import org.example.model.User;

public interface UserDao extends Dao<User> {

    User findByUsername(String username);

    User findBasicById(int id);

}
