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
public class Email {

    @Id
    private Integer id;
    private String text;
    @Column(name = "send_date")
    private LocalDate sendDate;
    @Column(name = "receive_date")
    private LocalDate receiveDate;
    @Column(name = "reseiver_email")
    private String emailReseiver;
    @Column(name = "sender_e-mail")
    private String emailSender;

}
