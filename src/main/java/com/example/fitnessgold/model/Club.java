package com.example.fitnessgold.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name = "Club")
@NoArgsConstructor
@Table(name = "club")
public class Club {

    @Id
    private Integer idclub;
    private String country;
    private String city;
    @Column(name = "postal_code")
    private String postalCode;
    private String street;
    @Column(name = "house_number")
    private String houseNumber;
    private String name;

    public Club(Integer idclub, String country, String city, String postalCode, String street, String houseNumber, String name) {
        this.idclub = idclub;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.houseNumber = houseNumber;
        this.name = name;
    }
}


