package com.example.fitnessgold.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Statistics {

    @Id
    private Integer idstatistics;
    private String note;
    @Column(name = "weight")
    private String weight;
    @Column(name = "heartbeat_stats")
    private String heartbeatStats;
    @Column(name = "body_fat_level")
    private String bodyFatLevel;
    @Column(name = "id_client")
    private Integer clientId;
    @Column(name = "id_date_activity")
    private Integer dateactivityId;
}
