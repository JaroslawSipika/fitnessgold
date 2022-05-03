package com.example.fitnessgold.rest;

import com.example.fitnessgold.dao.ActivityRepository;
import com.example.fitnessgold.dao.EmailRepository;
import com.example.fitnessgold.model.Email;
import com.example.fitnessgold.model.Equipment;
import com.example.fitnessgold.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailRepository emailRepository;


    @PostMapping("/create")
    public ResponseEntity addEmail(@RequestBody Email email) {

        List<Integer> allEmailId = emailRepository.findAllEmailId();
        Integer id = allEmailId.size()+1;
        LocalDate localDate = LocalDate.now();

        email.setId(id);
        email.setSendDate(localDate);


        emailRepository.createOneEmail(email);

        return ResponseEntity.ok().build();
    }










}
