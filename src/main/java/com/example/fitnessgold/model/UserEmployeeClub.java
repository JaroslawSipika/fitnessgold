package com.example.fitnessgold.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class UserEmployeeClub {
    //@Id
    private Integer idemployee;
    @Column(name = "create_date")
    private LocalDate createDate;
    @Column (name = "update_date")
    private LocalDate updateDate;
    private String email;
    @Column (name = "first_name")
    private String firstName;
    @Column (name = "last_name")
    private String lastName;
    private String password;
    private String phone;
    private String note;
    private String speciality;
    @Column (name = "name")
    private String nameClub;
    @Column (name = "id_user")
    private Integer idUser;

    public UserEmployeeClub(String firstName, String lastName, String speciality, String nameClub, String note, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.nameClub=nameClub;
        this.note=note;
        this.phone=phone;
    }

    public UserEmployeeClub(Integer idemployee, LocalDate createDate, LocalDate updateDate, String email, String firstName, String lastName, String password, String phone, String note, String speciality, String nameClub, Integer idUser) {
        this.idemployee = idemployee;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.note = note;
        this.speciality = speciality;
        this.nameClub = nameClub;
        this.idUser = idUser;
    }

    public UserEmployeeClub(Integer idemployee, String firstName, String lastName, String email, String password, String speciality, String nameClub, String note, String phone, Integer idUser) {
        this.idemployee = idemployee;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.speciality = speciality;
        this.nameClub=nameClub;
        this.note=note;
        this.phone=phone;
        this.idUser=idUser;


    }
}