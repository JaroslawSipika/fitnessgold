package com.example.fitnessgold.rest;

import com.example.fitnessgold.dao.*;
import com.example.fitnessgold.model.ClientDateActivityActivityClubEmployeeUser;
import com.example.fitnessgold.model.PrincipalProvider;
import com.example.fitnessgold.model.User;
import com.example.fitnessgold.model.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/dateactivity")
public class DateActivityController {


   @Autowired
   private DateActivityRepository dateActivityRepository;
   @Autowired
   private ClientRepository clientRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UserRepository userRepository;



    @GetMapping("/all")
    public ResponseEntity getAllDateActivity() {

        List<ClientDateActivityActivityClubEmployeeUser> dateActivity =  clientRepository.findAllActivity();
        return ResponseEntity.ok(dateActivity);
    }

    @PostMapping("/update")
    public ResponseEntity updateClient(ClientDateActivityActivityClubEmployeeUser clientDateActivityActivityClubEmployeeUser) {

        User currentUser = PrincipalProvider.getCurrentUser();
        Integer id = currentUser.getIduser();
        clientDateActivityActivityClubEmployeeUser.setStatus("reserved");
        Integer idclient = clientRepository.getOneIdClient(id);



        dateActivityRepository.updateDateActivity(clientDateActivityActivityClubEmployeeUser.getIddateactivity(),idclient, clientDateActivityActivityClubEmployeeUser.getStatus());

        return ResponseEntity.ok().build();
    }


    @PostMapping("/create")
    public ResponseEntity createDateActivity(ClientDateActivityActivityClubEmployeeUser clientDateActivityActivityClubEmployeeUser) {

        Random c = new Random();
        Integer idactivity = c.nextInt();
        Integer idclub = clubRepository.getOneIdClub(clientDateActivityActivityClubEmployeeUser.getName());
        Integer iduser = employeeRepository.getOneiduser(clientDateActivityActivityClubEmployeeUser.getLastName());
        Integer idemployee = employeeRepository.getOneEmployeeIDEmployee(iduser);
        Random d = new Random();
        Integer iddateactivity = d.nextInt();
        String status = "not reserved";


        dateActivityRepository.createActivity(idactivity, clientDateActivityActivityClubEmployeeUser.getSpeciality(), idclub, idemployee);
        dateActivityRepository.createDateActivity(iddateactivity, clientDateActivityActivityClubEmployeeUser.getStartDate(), clientDateActivityActivityClubEmployeeUser.getEndDate(),status, null, idactivity);

        return ResponseEntity.ok().build();
    }



}
