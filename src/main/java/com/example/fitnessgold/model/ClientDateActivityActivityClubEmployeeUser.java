package com.example.fitnessgold.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ClientDateActivityActivityClubEmployeeUser {

    private Integer idclient;
    private Integer iddateactivity;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    private String status;
    @Column (name = "id_client")
    private Integer clientId;
    @Column (name = "id_activity")
    private Integer activityId;
    private Integer idactivity;
    private String speciality;
    @Column (name = "id_club")
    private Integer clubId;
    @Column (name = "id_employee")
    private Integer employeeId;
    private Integer idclub;
    private String name;
    private Integer idemployee;
    @Column (name = "id_user")
    private Integer idUser;
    private Integer iduser;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;


    public ClientDateActivityActivityClubEmployeeUser(Integer idclient, Integer iddateactivity, LocalDateTime startDate, LocalDateTime endDate, String status, Integer clientId, Integer activityId, Integer idactivity, String speciality, Integer clubId, Integer employeeId, Integer idclub, String name, Integer idemployee, Integer idUser, Integer iduser, String firstName, String lastName) {
        this.idclient = idclient;
        this.iddateactivity = iddateactivity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.clientId = clientId;
        this.activityId = activityId;
        this.idactivity = idactivity;
        this.speciality = speciality;
        this.clubId = clubId;
        this.employeeId = employeeId;
        this.idclub = idclub;
        this.name = name;
        this.idemployee = idemployee;
        this.idUser = idUser;
        this.iduser = iduser;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
