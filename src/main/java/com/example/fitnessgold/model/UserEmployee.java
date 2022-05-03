package com.example.fitnessgold.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserEmployee {
    //    @Id
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
        private String nameClub;
        @Column (name = "id_club")
        private Integer idClub;
        @Column (name = "id_user")
        private Integer idUser;

    public UserEmployee(String firstName, String lastName, String speciality, Integer idClub) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.idClub = idClub;
    }
}
