package com.example.fitnessgold.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "employee")
public class Employee{

    @Id
    private Integer idemployee;
    private String note;
    private String speciality;
    @Column (name = "id_user")
    private Integer idUser;
    @Column (name = "id_club")
    private Integer idClub;

    public Employee(Integer idemployee, String note, String speciality, Integer idUser, Integer idClub) {
        this.idemployee = idemployee;
        this.note = note;
        this.speciality = speciality;
        this.idUser = idUser;
        this.idClub = idClub;
    }

    public Employee(Integer idemployee, String note, String speciality) {
        this.idemployee = idemployee;
        this.note = note;
        this.speciality = speciality;
    }

    public Employee(Integer idemployee, String note, String speciality, Integer idClub) {
        this.idemployee = idemployee;
        this.note = note;
        this.speciality = speciality;
        this.idClub = idClub;
    }
}


