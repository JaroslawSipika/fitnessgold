package com.example.fitnessgold.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ClientStatisticsDateActivityActivityEmployeeUser {

    private Integer idclient;
    @Column(name = "id_user")
    private Integer idUser;
    private Integer idstatistics;
    private String note;
    @Column(name = "weight")
    private String weight;
    @Column(name = "hearbeat_stats")
    private String heartbeatStats;
    @Column(name = "body_fat_level")
    private String bodyFatLevel;
    @Column(name = "id_client")
    private Integer clientId;
    @Column(name = "id_date_activity")
    private Integer dateactivityId;
    private Integer iddateactivity;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column (name = "id_activity")
    private Integer activityId;
    private Integer idactivity;
    private String speciality;
    private String status;
    @Column (name = "id_employee")
    private Integer employeeId;
    private Integer idemployee;
    private Integer iduser;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;


    public ClientStatisticsDateActivityActivityEmployeeUser(Integer idclient, Integer idUser, Integer idstatistics, String note, String weight, String heartbeatStats, String bodyFatLevel, Integer clientId, Integer dateactivityId, Integer iddateactivity, LocalDateTime startDate, LocalDateTime endDate, Integer activityId, Integer idactivity, String speciality,Integer employeeId, Integer idemployee, Integer iduser, String firstName, String lastName) {
        this.idclient = idclient;
        this.idUser = idUser;
        this.idstatistics = idstatistics;
        this.note = note;
        this.weight = weight;
        this.heartbeatStats = heartbeatStats;
        this.bodyFatLevel = bodyFatLevel;
        this.clientId = clientId;
        this.dateactivityId = dateactivityId;
        this.iddateactivity = iddateactivity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.activityId = activityId;
        this.idactivity = idactivity;
        this.speciality = speciality;
        this.employeeId = employeeId;
        this.idemployee = idemployee;
        this.iduser = iduser;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ClientStatisticsDateActivityActivityEmployeeUser(Integer idclient, Integer idUser, Integer iddateactivity, LocalDateTime startDate, LocalDateTime endDate, Integer activityId, Integer idactivity, String speciality,Integer employeeId, Integer idemployee, Integer iduser, String firstName, String lastName, Integer idstatistics, String note, String weight, String heartbeatStats, String bodyFatLevel, Integer clientId, Integer dateactivityId ) {
        this.idclient = idclient;
        this.idUser = idUser;
        this.iddateactivity = iddateactivity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.activityId = activityId;
        this.idactivity = idactivity;
        this.speciality = speciality;
        this.employeeId = employeeId;
        this.idemployee = idemployee;
        this.iduser = iduser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idstatistics = idstatistics;
        this.note = note;
        this.weight = weight;
        this.heartbeatStats = heartbeatStats;
        this.bodyFatLevel = bodyFatLevel;
        this.clientId = clientId;
        this.dateactivityId = dateactivityId;
    }
}
