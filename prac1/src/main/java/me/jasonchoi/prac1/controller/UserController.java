package me.jasonchoi.prac1.controller;


import me.jasonchoi.prac1.model.User;
import me.jasonchoi.prac1.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/list")
    public List<User> userList() {
        return userService.userList();
    }
}
