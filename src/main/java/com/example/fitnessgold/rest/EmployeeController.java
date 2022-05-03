package com.example.fitnessgold.rest;


import com.example.fitnessgold.dao.ClubRepository;
import com.example.fitnessgold.dao.EmployeeRepository;
import com.example.fitnessgold.dao.UserRepository;
import com.example.fitnessgold.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ClubRepository clubRepository;



//    @GetMapping("/all")
//    public ResponseEntity getEmployees() {
//        List<UserEmployee> employees = employeeRepository.findAll1Employees();
//        return ResponseEntity.ok(employees);
//    }

    @GetMapping("/all")
    public ResponseEntity getEmployees() {
        List<UserEmployeeClub> employees = employeeRepository.findAll2Employees();
        return ResponseEntity.ok(employees);
    }




    @PostMapping("/create")
    public ResponseEntity addEmployee(UserEmployee userEmployee) {

        //   List<Integer> allUserId = userRepository.findAllUserId();
        //  Integer id = allUserId.size()+1;
        Random u = new Random();
        Integer id = u.nextInt();
        userEmployee.setIdemployee(id);
        LocalDate localDate = LocalDate.now();
        userEmployee.setCreateDate(localDate);

        userRepository.createOneUser1(userEmployee.getIdemployee(),userEmployee.getCreateDate(),null,userEmployee.getEmail(),userEmployee.getFirstName(),userEmployee.getLastName(),userEmployee.getPassword(),userEmployee.getPhone());

       // List<Integer> allEmployeeUserIdIds = employeeRepository.findAllEmployeeUserIdIds();
       // Integer id1 = allEmployeeUserIdIds.size()+1;
        Random e = new Random();
        Integer id1 = e.nextInt();
        Integer oneIdClub = clubRepository.getOneIdClub(userEmployee.getNameClub());

        employeeRepository.createOneEmployee1(id1, userEmployee.getNote(), userEmployee.getSpeciality(), userEmployee.getIdemployee(), oneIdClub);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/edit")
    public ResponseEntity getEmployees1() {
        List<UserEmployeeClub> employees = employeeRepository.findAll2Employees();
        return ResponseEntity.ok(employees);
    }


    @PostMapping("/update")
    public ResponseEntity updateUser(UserEmployeeClub userEmployeeClub) {

        LocalDate localDate = LocalDate.now();
        userEmployeeClub.setUpdateDate(localDate);

        Integer idUser = userRepository.getOneEmployeeIDUser(userEmployeeClub.getEmail());
        Integer idEmploy = employeeRepository.getOneEmployeeIDEmployee(idUser);

        userEmployeeClub.setIdUser(idUser);
        userEmployeeClub.setIdemployee(idEmploy);

        User oneUser = userRepository.getOneUser(userEmployeeClub.getIdUser());

        userRepository.updateUserById(userEmployeeClub.getIdUser(), oneUser.getCreateDate(), userEmployeeClub.getUpdateDate(), userEmployeeClub.getEmail(), userEmployeeClub.getFirstName(), userEmployeeClub.getLastName(), userEmployeeClub.getPassword(), userEmployeeClub.getPhone());
        employeeRepository.updateEmployeeById(userEmployeeClub.getIdemployee(), userEmployeeClub.getNote(), userEmployeeClub.getSpeciality());
        return ResponseEntity.ok().build();
    }



    @PostMapping("/delete")
    public ResponseEntity deleteEmployee(UserEmployeeClub userEmployeeClub) {
        Integer userId = employeeRepository.getOneEmployeeIDiduser(userEmployeeClub.getIdemployee());
        userRepository.deleteOneUser(userId);
        employeeRepository.deleteOneEmployee(userEmployeeClub.getIdemployee());
        return ResponseEntity.ok().build();
    }




    @GetMapping("/{employeeId}")
    public ResponseEntity getOneEmployee(@PathVariable Integer employeeId) {
        Employee employee = employeeRepository.getOneEmployee(employeeId);
        return ResponseEntity.ok(employee);
    }




    @GetMapping("/all1")
    public ResponseEntity getDataforClient() {
        List<UserEmployeeClub> dataEmployee = null;
        if (PrincipalProvider.isAdmin()) {
            dataEmployee = employeeRepository.findAll2Employees();
        }
        else {
            User currentUser = PrincipalProvider.getCurrentUser();
            Integer id = currentUser.getIduser();
            dataEmployee = employeeRepository.findEmployeeById(id);
        }
        return ResponseEntity.ok(dataEmployee);
    }

    
    
}
