package lesson47.kfedor.controller;

import com.github.kfedor.dto.user.UserDto;
import com.github.kfedor.entity.User;
import com.github.kfedor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getAllUsers().stream()
                .map(user -> new UserDto(user.getName(), user.getEmail()))
                .toList();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable(name = "id") UUID userId) {
        return userService.getById(userId);
    }

    @PostMapping
    public User createUser(@RequestBody UserDto userToCreate) {
        return userService.createUser(userToCreate);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable(name = "id") UUID id, @RequestBody UserDto userToUpdate) {
        return userService.updateUser(id, userToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }
}
