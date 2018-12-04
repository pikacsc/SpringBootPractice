package me.jasonchoi.prac1.service;

import me.jasonchoi.prac1.model.User;

import java.util.List;

public interface UserService {
    List<User> userList();

    User findById(Long id);

    User addUser(User user);

    String deleteUser(Long id);
}
