package me.jasonchoi.prac1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Set;


@Entity
@Data
public class User extends AbstractPersistable<Long> {

    private String userId;
    private String userName;
    private String password;
    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

    @OneToMany(targetEntity = Address.class, mappedBy = "user", fetch=FetchType.LAZY, cascade =  CascadeType.ALL)
    @JsonBackReference
    private Set<Address> addresses;

    //@JsonManagedReference
    //To prevent infinite recursion
    //http://binarycube.tistory.com/1
    //https://dalgoo.tistory.com/37




}
