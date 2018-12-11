package me.jasonchoi.prac3.repository;

import me.jasonchoi.prac3.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
