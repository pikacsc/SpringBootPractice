package me.jasonchoi.prac1.model;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;


@Entity
@Data
public class User extends AbstractPersistable<Long> {

    private String userId;
    private String userName;
    private String password;

}
