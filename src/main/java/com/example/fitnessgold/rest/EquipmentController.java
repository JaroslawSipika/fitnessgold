package com.example.fitnessgold.rest;

import com.example.fitnessgold.dao.ClientRepository;
import com.example.fitnessgold.dao.ClubRepository;
import com.example.fitnessgold.dao.EquipmentRepository;
import com.example.fitnessgold.dao.ReservationRepository;
import com.example.fitnessgold.model.*;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ReservationRepository reservationRepository;

       @GetMapping("/all1")
       public ResponseEntity getEquipments() {
        List<EquipmentClubReservationClientUser> equipments = equipmentRepository.findAllEquipment2();
       return ResponseEntity.ok(equipments);
    }

    @GetMapping("/all")
    public ResponseEntity getEquipmentsforClient() {
        List<EquipmentClubReservationClientUser> equipments = null;
        if (PrincipalProvider.isAdmin() || PrincipalProvider.isEmployee()) {
            equipments = equipmentRepository.findAllEquipment2();
        }
       else {
            User currentUser = PrincipalProvider.getCurrentUser();
            Integer id = currentUser.getIduser();
            equipments = equipmentRepository.findAllEquipment3(id);

        }
        return ResponseEntity.ok(equipments);
    }



    @GetMapping("/edit")
    public ResponseEntity getEquipments1() {
        List<Equipment> equipment = equipmentRepository.findAllEquipment();
        return ResponseEntity.ok(equipment);
    }


    @PostMapping("/create")
    public ResponseEntity addEquipment(EquipmentClubReservationClientUser equipmentClubReservationClientUser) {


        Random c = new Random();
        Integer id = c.nextInt();
        LocalDate localDate = LocalDate.now();
        Integer e = equipmentRepository.findIdClub(equipmentClubReservationClientUser.getName());

        equipmentClubReservationClientUser.setIdClub(e);
        equipmentClubReservationClientUser.setIdequipment(id);
        equipmentClubReservationClientUser.setBuyDate(localDate);
        equipmentClubReservationClientUser.setNextConservation(localDate.plusDays(90));
        equipmentClubReservationClientUser.setLastConservation(null);
        equipmentClubReservationClientUser.setIdReservation(null);

        equipmentRepository.createOneEquipment1(equipmentClubReservationClientUser.getIdequipment(), equipmentClubReservationClientUser.getStatus(),equipmentClubReservationClientUser.getBuyDate(),equipmentClubReservationClientUser.getLastConservation(),equipmentClubReservationClientUser.getNextConservation(), equipmentClubReservationClientUser.getNote(),equipmentClubReservationClientUser.getNameEquipment(),equipmentClubReservationClientUser.getPricePerDay(),equipmentClubReservationClientUser.getIdClub(), equipmentClubReservationClientUser.getIdReservation());

        return ResponseEntity.ok().build();
    }


    @PostMapping("/update")
    public ResponseEntity updateClub(EquipmentClubReservationClientUser equipmentClubReservationClientUser) {

        equipmentClubReservationClientUser.setNextConservation(equipmentClubReservationClientUser.getLastConservation().plusDays(90));


        equipmentRepository.updateOneEquipment(equipmentClubReservationClientUser.getIdequipment(), equipmentClubReservationClientUser.getStatus(), equipmentClubReservationClientUser.getLastConservation(), equipmentClubReservationClientUser.getNextConservation(), equipmentClubReservationClientUser.getNote(), equipmentClubReservationClientUser.getNameEquipment(), equipmentClubReservationClientUser.getPricePerDay(), equipmentClubReservationClientUser.getIdClub());

        return ResponseEntity.ok().build();
    }


    @PostMapping("/update1")
    public ResponseEntity updateEquipment(EquipmentClubReservationClientUser equipmentClubReservationClientUser) {

        Random c = new Random();
        Integer id = c.nextInt();
        User currentUser = PrincipalProvider.getCurrentUser();
        Integer ids = currentUser.getIduser();
        Integer idclient = clientRepository.getOneIdClient(ids);
        String a = "rented";

        reservationRepository.createOneReservation(id,null,equipmentClubReservationClientUser.getBeginDate(),equipmentClubReservationClientUser.getEndDate(),idclient);
        equipmentRepository.updateOneEquipment1(equipmentClubReservationClientUser.getIdequipment(),a, id);

        return ResponseEntity.ok().build();
    }



//    @PostMapping("/delete")
//    public ResponseEntity deleteEquipment(EquipmentClubReservationClientUser equipmentClubReservationClientUser) {
//
//
//
//        return ResponseEntity.ok().build();
//    }

    @GetMapping("/all2")
    public ResponseEntity getEquipmentsforClient2() {
        List<EquipmentClubReservationClientUser> equipments = null;
        equipments = equipmentRepository.findAllEquipment4();
        return ResponseEntity.ok(equipments);
    }


    @GetMapping("/{equipmentId}")
    public ResponseEntity getOneEquipment(@PathVariable Integer equipmentId) {
        Equipment equipment = equipmentRepository.getOneEquipment(equipmentId);
        return ResponseEntity.ok(equipment);
    }



}
