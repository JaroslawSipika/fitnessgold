package com.example.fitnessgold.rest;

import com.example.fitnessgold.dao.AdminRepository;
import com.example.fitnessgold.dao.ClientRepository;
import com.example.fitnessgold.dao.EmployeeRepository;
import com.example.fitnessgold.dao.UserRepository;
import com.example.fitnessgold.model.Admin;
import com.example.fitnessgold.model.Employee;
import com.example.fitnessgold.model.PrincipalProvider;
import com.example.fitnessgold.model.User;
import com.example.fitnessgold.rest.DTO.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    @PostMapping("/login")
    public ResponseEntity login(User user) {
        User userByEmail = userRepository.getUserByEmail(user.getEmail());
        boolean isPasswordValid = userByEmail.getPassword().equals(user.getPassword());
        if (isPasswordValid) {
            PrincipalProvider.storeCurrentUser(userByEmail);
            List<Integer> allAdminUserIdIds = adminRepository.findAllAdminUserIdIds();
            List<Integer> allClientUserIdIds = clientRepository.findAllClientUserIdIds();
            List<Integer> allEmployeeUserIdIds = employeeRepository.findAllEmployeeUserIdIds();

            if (allAdminUserIdIds.contains(userByEmail.getIduser())) {
                PrincipalProvider.setUserType("ADMIN");
                return ResponseEntity.ok(new UserType("ADMIN"));
            } else if (allClientUserIdIds.contains(userByEmail.getIduser())) {
                PrincipalProvider.setUserType("CLIENT");
                return ResponseEntity.ok(new UserType("CLIENT"));
            } else if (allEmployeeUserIdIds.contains(userByEmail.getIduser())) {
                PrincipalProvider.setUserType("EMPLOYEE");
                return ResponseEntity.ok(new UserType("EMPLOYEE"));
            }

        }
        return ResponseEntity.status(401).build();
    }

    @GetMapping("/logout")
    public ResponseEntity logout() {
        PrincipalProvider.clearCurrentUser();
        return ResponseEntity.ok().build();
    }
}