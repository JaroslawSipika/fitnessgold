package com.example.fitnessgold.rest;

import com.example.fitnessgold.dao.*;
import com.example.fitnessgold.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private StatisticsRepository statisticsRepository;
    @Autowired
    private ClientRepository clientRepository;


    @GetMapping("/all")
    public ResponseEntity getStatisticsforClient() {
        List<ClientStatisticsDateActivityActivityEmployeeUser> statistics = null;
        if (PrincipalProvider.isEmployee()) {
            statistics = statisticsRepository.findAllStatistics();
        } else {
            User currentUser = PrincipalProvider.getCurrentUser();
            Integer id = currentUser.getIduser();
            Integer idclient = clientRepository.getOneIdClient(id);
            statistics = statisticsRepository.findAllStatistics1(idclient);
        }
        return ResponseEntity.ok(statistics);
    }



    @GetMapping("/all1")
    public ResponseEntity getStatisticsforClient1() {
        List<ClientStatisticsDateActivityActivityEmployeeUser> statistics = null;
            statistics = statisticsRepository.findAllStatistics();
            User currentUser = PrincipalProvider.getCurrentUser();
            Integer id = currentUser.getIduser();
            Integer ide = statisticsRepository.findIdEmployee(id);
            statistics = statisticsRepository.findAllStatistics2(ide);

        return ResponseEntity.ok(statistics);
    }


    @PostMapping("/create")
    public ResponseEntity addStatistics(ClientStatisticsDateActivityActivityEmployeeUser clientStatisticsDateActivityActivityEmployeeUser) {

        Random c = new Random();
        Integer idstatistics = c.nextInt();


        statisticsRepository.createStatistics(idstatistics, clientStatisticsDateActivityActivityEmployeeUser.getNote(),clientStatisticsDateActivityActivityEmployeeUser.getWeight(), clientStatisticsDateActivityActivityEmployeeUser.getHeartbeatStats(), clientStatisticsDateActivityActivityEmployeeUser.getBodyFatLevel(),clientStatisticsDateActivityActivityEmployeeUser.getClientId(),clientStatisticsDateActivityActivityEmployeeUser.getDateactivityId());


        return ResponseEntity.ok().build();
    }







}