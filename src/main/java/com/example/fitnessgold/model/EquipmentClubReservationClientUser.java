package com.example.fitnessgold.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class EquipmentClubReservationClientUser {

        //@Id
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
        private Integer idclub;
        private String name;
        private Integer idreservation;
        @Column (name = "begin_date")
        private LocalDate beginDate;
        @Column (name = "end_date")
        private LocalDate endDate;
        @Column (name = "id_client")
        private Integer idClient;
        private Integer idclient;
        @Column(name = "id_user")
        private Integer idUser;
        private Integer iduser;
        @Column(name = "first_name")
        private String firstName;
        @Column(name = "last_name")
        private String lastName;


    public EquipmentClubReservationClientUser(Integer idequipment, String status, LocalDate buyDate, LocalDate lastConservation, LocalDate nextConservation, String note, String nameEquipment, float pricePerDay, Integer idClub, String name, LocalDate beginDate, LocalDate endDate, String firstName, String lastName) {

        this.idequipment = idequipment;
        this.status = status;
        this.buyDate = buyDate;
        this.lastConservation = lastConservation;
        this.nextConservation = nextConservation;
        this.note = note;
        this.nameEquipment = nameEquipment;
        this.pricePerDay = pricePerDay;
        this.idClub = idClub;
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public EquipmentClubReservationClientUser(Integer idequipment, String status, LocalDate buyDate, LocalDate lastConservation, LocalDate nextConservation, String note, String nameEquipment, float pricePerDay, Integer idClub, Integer idReservation, String name, LocalDate beginDate, LocalDate endDate, String firstName, String lastName) {

        this.idequipment = idequipment;
        this.status = status;
        this.buyDate = buyDate;
        this.lastConservation = lastConservation;
        this.nextConservation = nextConservation;
        this.note = note;
        this.nameEquipment = nameEquipment;
        this.pricePerDay = pricePerDay;
        this.idClub = idClub;
        this.idReservation = idReservation;
        this.name = name;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}




















