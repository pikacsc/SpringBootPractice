package me.jasonchoi.prac1.service;

import me.jasonchoi.prac1.model.User;
import me.jasonchoi.prac1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }
}
