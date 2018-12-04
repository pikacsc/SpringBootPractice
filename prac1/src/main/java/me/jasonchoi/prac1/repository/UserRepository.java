package me.jasonchoi.prac1.repository;

import me.jasonchoi.prac1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
