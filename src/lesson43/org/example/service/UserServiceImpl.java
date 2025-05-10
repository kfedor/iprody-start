package lesson43.org.example.service;

import org.example.dao.UserDao;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userDao.findById(id);
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public User getBasicUserById(int id) {
        return null;
    }


}
