package me.jasonchoi.prac3.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
public class User {

    @Id //To set primary key
    @Email //To validation email form
    @NotEmpty
    @Column(unique = true)
    private String email;

    @NotEmpty
    private String name;

    @Size(min=4) //To set minimum size of password
    private String password;

    //user : tasks == 1:N relationship
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;

    //users : roles == N : N
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",joinColumns = {
            @JoinColumn(name="USER_EMAIL", referencedColumnName = "email")
    }, inverseJoinColumns = {@JoinColumn(name="ROLE_NAME", referencedColumnName = "name")})
    private List<Role> roles;

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public User(){

    }
}
