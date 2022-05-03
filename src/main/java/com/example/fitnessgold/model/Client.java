package com.example.fitnessgold.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "client")
public class Client {

    @Id
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
}
