package me.jasonchoi.prac1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;


@Entity
@Data
public class User extends AbstractPersistable<Long> {

    private String userId;
    private String userName;
    private String password;

    @OneToMany(targetEntity = Address.class, mappedBy = "user", fetch=FetchType.LAZY, cascade =  CascadeType.ALL)
    @JsonManagedReference
    private Set<Address> addresses;

    //@JsonManagedReference
    //To prevent infinite recursion
    //http://binarycube.tistory.com/1
    //https://dalgoo.tistory.com/37

}
