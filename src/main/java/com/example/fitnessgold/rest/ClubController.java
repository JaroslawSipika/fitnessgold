package com.example.fitnessgold.rest;

import com.example.fitnessgold.dao.ClubRepository;
import com.example.fitnessgold.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/club")
public class ClubController {

    @Autowired
    private ClubRepository clubRepository;

    @GetMapping("/all")
    public ResponseEntity getClubs() {
        List<Club> clubs = clubRepository.findAllClubs();
        return ResponseEntity.ok(clubs);
    }


    @PostMapping("/create")
    public ResponseEntity addClub(Club club) {

        Random c = new Random();
        Integer id = c.nextInt();
        club.setIdclub(id);

        clubRepository.createOneClub(club);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/update")
    public ResponseEntity updateClub(Club club) {

        clubRepository.updateOneClub(club.getIdclub(), club.getCountry(), club.getCity(), club.getPostalCode(), club.getStreet(), club.getHouseNumber(), club.getName());

        return ResponseEntity.ok().build();
    }


    @PostMapping("/delete")
    public ResponseEntity deleteEmployee(Club club) {

        clubRepository.deleteOneClub(club.getIdclub());


        return ResponseEntity.ok().build();
    }











    @GetMapping("/{clubId}")
    public ResponseEntity getOneClub(@PathVariable Integer clubId) {
        Club club = clubRepository.getOneClub(clubId);
        return ResponseEntity.ok(club);
    }



}
