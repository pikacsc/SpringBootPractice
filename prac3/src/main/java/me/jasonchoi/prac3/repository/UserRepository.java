package me.jasonchoi.prac3.repository;

import me.jasonchoi.prac3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
