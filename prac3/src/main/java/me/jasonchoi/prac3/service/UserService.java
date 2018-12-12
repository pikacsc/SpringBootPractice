package me.jasonchoi.prac3.service;

import me.jasonchoi.prac3.model.Role;
import me.jasonchoi.prac3.model.User;
import me.jasonchoi.prac3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public void createAdmin(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }


    public User findOne(String email) {

        return userRepository.findOne(email);
    }

    public boolean isUserPresent(String email) {
        User user = userRepository.findOne(email);
        if(user!=null)
            return true;
        return false;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByName(String name){
        return userRepository.findByNameLike("%"+name+"%");
    }
}
