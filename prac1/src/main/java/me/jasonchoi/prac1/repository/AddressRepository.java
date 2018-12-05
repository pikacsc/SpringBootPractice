package me.jasonchoi.prac1.repository;

import me.jasonchoi.prac1.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
