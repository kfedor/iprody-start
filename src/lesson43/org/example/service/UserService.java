package lesson43.org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    void create(User user);
    User getBasicUserById(int id);
}
