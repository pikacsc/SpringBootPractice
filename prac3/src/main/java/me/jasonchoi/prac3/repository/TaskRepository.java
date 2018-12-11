package me.jasonchoi.prac3.repository;

import me.jasonchoi.prac3.model.Task;
import me.jasonchoi.prac3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
