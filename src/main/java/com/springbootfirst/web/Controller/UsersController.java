package com.springbootfirst.web.Controller;

import com.springbootfirst.web.models.User;
import com.springbootfirst.web.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserServiceImpl userServiceImpl;


    public UsersController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        List<User> allUsers = userServiceImpl.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "user-list";
    }

    @GetMapping("/create")
    public String createUserForm(@ModelAttribute("user") User user) {
        return "user-create";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userServiceImpl.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userServiceImpl.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}/user-update")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServiceImpl.findUserByID(id));
        return "user-update";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userServiceImpl.saveUser(user);
        return "redirect:/users";
    }
}
