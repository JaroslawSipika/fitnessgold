package com.example.fitnessgold.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "DateActivity")
@NoArgsConstructor
@Table(name = "date_activity")
public class DateActivity {

    @Id
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
}
