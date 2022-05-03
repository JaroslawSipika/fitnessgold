package com.example.fitnessgold.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UserClient {

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
    private Integer idclient;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "house_number")
    private String houseNumber;
    private String pesel;
    @Column(name = "postal_code")
    private String postalCode;
    private String street;
    private String city;
    @Column(name = "id_user")
    private Integer idUser;

    public UserClient(Integer iduser, LocalDate createDate, LocalDate updateDate, String email, String firstName, String lastName, String password, String phone, Integer idclient, LocalDate birthDate, String houseNumber, String pesel, String postalCode, String street, String city, Integer idUser) {
        this.iduser = iduser;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.idclient = idclient;
        this.birthDate = birthDate;
        this.houseNumber = houseNumber;
        this.pesel = pesel;
        this.postalCode = postalCode;
        this.street = street;
        this.city = city;
        this.idUser = idUser;
    }
}
