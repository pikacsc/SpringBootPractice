package me.jasonchoi.prac1.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Address extends AbstractPersistable<Long> {
    private String city;
    private String state;
    private String country;
    private transient Long userId;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;

    //@JsonBackReference
    //To prevent infinite recursion
    //http://binarycube.tistory.com/1
    //https://dalgoo.tistory.com/37
}
