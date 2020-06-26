package com.spring.jmep.controller;

import com.spring.jmep.model.User;
import com.spring.jmep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/", "/users"})
    public String getUsers(ModelMap map) {
        List<User> users = userService.getAllUsers();
        map.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Long id,
                              ModelMap map) {
        User user = userService.getUserById(id);
        map.addAttribute("user", user);
        return "user";
    }

    @PostMapping("/user")
    public String addUser(@RequestParam String username,
                          @RequestParam String firstName,
                          @RequestParam String lastName){
        userService.addUser(new User(username, firstName, lastName));
        return "redirect:/users";
    }

    @PostMapping("/updateUser")
    public String editUser(@RequestParam Long id,
                           @RequestParam String username,
                           @RequestParam String firstName,
                           @RequestParam String lastName) {
        userService.updateUser(new User(id, username, firstName, lastName));
        return "redirect:/users";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
