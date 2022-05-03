package com.example.fitnessgold.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "User")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    private Integer iduser;
    @Column(name = "create_date")
    private LocalDate createDate;
    @Column(name = "update_date")
    private LocalDate updateDate;
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String password;
    private String phone;

    public User(Integer iduser, LocalDate createDate, LocalDate updateDate, String email, String firstName, String lastName, String password, String phone) {
        this.iduser = iduser;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
    }
    public User(LocalDate createDate, LocalDate updateDate, String email, String firstName, String lastName, String password, String phone) {
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
    }
}