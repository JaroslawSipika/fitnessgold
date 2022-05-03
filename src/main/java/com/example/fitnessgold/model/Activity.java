package com.example.fitnessgold.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.concurrent.atomic.LongAccumulator;

@Getter
@Setter
@Entity
@NoArgsConstructor

public class Activity {

    @Id
    private Integer idactivity;
    private String speciality;
    @Column (name = "id_club")
    private Integer clubId;
    @Column (name = "id_employee")
    private Integer employeeId;



}
