package me.jasonchoi.prac2.service;

import me.jasonchoi.prac2.model.CustomUserDetails;
import me.jasonchoi.prac2.model.Users;
import me.jasonchoi.prac2.repositroy.UserRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {


    @Autowired
    private UserRepositroy userRepositroy;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = userRepositroy.findByName(username);
        optionalUsers
                .orElseThrow(()->new UsernameNotFoundException("Username not found"));
        return optionalUsers
                .map(CustomUserDetails::new).get();
    }
}
