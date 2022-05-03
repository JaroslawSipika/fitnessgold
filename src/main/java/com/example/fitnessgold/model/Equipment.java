package com.example.fitnessgold.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
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
@Table(name = "equipment")
public class Equipment {

    @Id
    private Integer idequipment;
    private String status;
    @Column(name = "buy_date")
    private LocalDate buyDate;
    @Column(name = "last_conservation")
    private LocalDate lastConservation;
    @Column(name = "next_conservation")
    private LocalDate nextConservation;
    private String note;
    @Column (name = "name_e")
    private String nameEquipment;
    @Column(name = "price_per_day")
    private float pricePerDay;
    @Column(name = "id_club")
    private Integer idClub;
    @Column(name = "id_reservation")
    private Integer idReservation;



}
