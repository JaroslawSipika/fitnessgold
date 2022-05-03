package com.example.fitnessgold.rest;

import com.example.fitnessgold.dao.*;
import com.example.fitnessgold.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private DateActivityRepository dateActivityRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public ResponseEntity getActivities() {
        List<Activity> activities = activityRepository.findAllActivities();

        return ResponseEntity.ok(activities);
    }

    @PostMapping("/create")
    public ResponseEntity addActivity(@RequestBody Activity activity) {


        List<Integer> allActivityId = activityRepository.findAllActivityId();
        Integer id = allActivityId.size()+1;

        activityRepository.createOneActivity(activity);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{activityId}")
    public ResponseEntity getOneActivity(@PathVariable Integer activityId) {
        Activity activity = activityRepository.getOneActivity(activityId);
        return ResponseEntity.ok(activity);
    }



    @PostMapping("/update")
    public ResponseEntity updateActivity(ClientDateActivityActivityClubEmployeeUser clientDateActivityActivityClubEmployeeUser) {

        Integer idclub = clubRepository.getOneIdClub(clientDateActivityActivityClubEmployeeUser.getName());
        Integer iduser = employeeRepository.getOneiduser(clientDateActivityActivityClubEmployeeUser.getLastName());
        Integer idemployee = employeeRepository.getOneEmployeeIDEmployee(iduser);

        activityRepository.updateOneActivity(clientDateActivityActivityClubEmployeeUser.getIdactivity(), clientDateActivityActivityClubEmployeeUser.getSpeciality(), idclub, idemployee);
        dateActivityRepository.updateDateActivity1(clientDateActivityActivityClubEmployeeUser.getIddateactivity(), clientDateActivityActivityClubEmployeeUser.getStartDate(), clientDateActivityActivityClubEmployeeUser.getEndDate(), clientDateActivityActivityClubEmployeeUser.getStatus(), clientDateActivityActivityClubEmployeeUser.getClientId(), clientDateActivityActivityClubEmployeeUser.getActivityId());


        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete")
    public ResponseEntity deleteActivity(ClientDateActivityActivityClubEmployeeUser clientDateActivityActivityClubEmployeeUser) {

        //dateActivityRepository.setToDelete(null, clientDateActivityActivityClubEmployeeUser.getActivityId());
        activityRepository.setToDelete(clientDateActivityActivityClubEmployeeUser.getIdactivity(), null, null);

        dateActivityRepository.deleteDateActivity(clientDateActivityActivityClubEmployeeUser.getActivityId());
        activityRepository.deleteOneActivity(clientDateActivityActivityClubEmployeeUser.getIdactivity());

        return ResponseEntity.ok().build();
    }








}
