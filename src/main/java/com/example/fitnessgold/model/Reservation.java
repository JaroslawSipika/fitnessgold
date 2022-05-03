package com.example.fitnessgold.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation {

    @Id
    private Integer idreservation;
    private float price;
    @Column (name = "begin_date")
    private LocalDate beginDate;
    @Column (name = "end_date")
    private LocalDate endDate;
    @Column (name = "id_client")
    private Integer idClient;

}
