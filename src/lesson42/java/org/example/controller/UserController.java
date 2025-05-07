package lesson42.java.org.example.controller;

import org.example.dao.JdbcUserDao;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private JdbcUserDao jdbcUserDao;

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("users", jdbcUserDao.findAll());
        return "user-list";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("user", jdbcUserDao.findById(id));
        return "user-by-id";
    }

    @GetMapping("/add")
    public String getAddUserPage(Model model) {
        return "user-add";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user){
        jdbcUserDao.create(user);
        return "redirect:/users";
    }
}
