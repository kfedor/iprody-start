package lesson43.org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user-list";
    }

    @GetMapping("/{id}")
    public String getUser(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("user", userService.getUserById(id));
        return "user-details";
    }

    @GetMapping("/basic/{id}")
    public String getBasicUserById(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("user", userService.getUserById(id));
        return "basic-user-by-id";
    }

    @GetMapping("/add")
    public String getAddUserPage(Model model) {
        return "user-add";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        userService.create(user);
        return "redirect:/users";
    }
}
