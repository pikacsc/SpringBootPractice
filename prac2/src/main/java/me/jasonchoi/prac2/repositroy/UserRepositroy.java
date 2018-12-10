package me.jasonchoi.prac2.repositroy;

import me.jasonchoi.prac2.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositroy extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}
