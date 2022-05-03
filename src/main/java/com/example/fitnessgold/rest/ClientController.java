package com.example.fitnessgold.rest;

import com.example.fitnessgold.dao.ClientRepository;
import com.example.fitnessgold.dao.EquipmentRepository;
import com.example.fitnessgold.dao.UserRepository;
import com.example.fitnessgold.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/all")
    public ResponseEntity getDataforClient() {
        List<UserClient> dataClient;
        if (PrincipalProvider.isAdmin()) {
            dataClient = clientRepository.findAllClient();
        }
        else {
            User currentUser = PrincipalProvider.getCurrentUser();
            Integer id = currentUser.getIduser();
            dataClient = clientRepository.findClientbyId(id);
        }
        return ResponseEntity.ok(dataClient);
    }


    @PostMapping("/update")
    public ResponseEntity updateClient(UserClient userClient) {

        LocalDate localDate = LocalDate.now();
        userClient.setUpdateDate(localDate);

        userRepository.updateUserById1(userClient.getIduser(), userClient.getUpdateDate(), userClient.getEmail(), userClient.getPassword(), userClient.getPhone());
        clientRepository.updateUserClientById(userClient.getIdclient(), userClient.getBirthDate(), userClient.getHouseNumber(), userClient.getPesel(), userClient.getPostalCode(), userClient.getStreet(), userClient.getCity());

        return ResponseEntity.ok().build();
    }


    @GetMapping("/activity")
    public ResponseEntity getDataforClient1() {
        List<ClientDateActivityActivityClubEmployeeUser> dataClient;
        if (PrincipalProvider.isAdmin()) {
            dataClient = clientRepository.findAllActivity();
        }
        else {
            User currentUser = PrincipalProvider.getCurrentUser();
            Integer id = currentUser.getIduser();
            dataClient = clientRepository.findActivitybyId(id);
        }
        return ResponseEntity.ok(dataClient);
    }

    @GetMapping("/activity1")
    public ResponseEntity getDataforClient2() {
        List<ClientDateActivityActivityClubEmployeeUser> dataClient;

        dataClient = clientRepository.findAllActivity1();

        return ResponseEntity.ok(dataClient);
    }



    @PostMapping("/delete")
    public ResponseEntity deleteEmployee(UserClient userClient) {
        Integer userId = clientRepository.getOneIdClient1(userClient.getIdclient());
        clientRepository.deleteOneClient(userClient.getIdclient());
        userRepository.deleteOneUser(userId);

        return ResponseEntity.ok().build();
    }



    @GetMapping("/allList")
    public ResponseEntity getDataforClients() {

        List<UserClient> dataClient;
        dataClient = clientRepository.findAllClient1();

        return ResponseEntity.ok(dataClient);
    }










}
