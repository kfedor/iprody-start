package lesson47.kfedor.service;

import com.github.kfedor.dto.user.UserDto;
import com.github.kfedor.entity.User;
import com.github.kfedor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getById(UUID userId) {
        return repository.findById(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no user with such id."));
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User createUser(UserDto userToCreate) {
        User user = new User();
        user.setName(userToCreate.getName());
        user.setEmail(userToCreate.getEmail());
        return repository.save(user);
    }

    public User updateUser(UUID id, UserDto userToUpdate) {
        User user = getById(id);
        user.setName(userToUpdate.getName());
        user.setEmail(userToUpdate.getEmail());
        return repository.save(user);
    }

    public void deleteUser(UUID id) {
        repository.deleteById(id);
    }

}
