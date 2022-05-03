package com.example.fitnessgold.rest;

import com.example.fitnessgold.dao.ClientRepository;
import com.example.fitnessgold.dao.UserRepository;
import com.example.fitnessgold.model.User;
import com.example.fitnessgold.model.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public ResponseEntity getUsers() {
        List<User> users = userRepository.findAllUsers();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{userID}")
    public ResponseEntity getOneUser(@PathVariable Integer userID) {
        User user1 = userRepository.getOneUser(userID);

        return ResponseEntity.ok(user1);
    }


    @PostMapping("/create")
    public ResponseEntity addUser(@RequestBody User user) {

        List<Integer> allUserId = userRepository.findAllUserId();
        Integer id = allUserId.size()+1;
        user.setIduser(id);

        userRepository.createOneUser(user);

        return ResponseEntity.ok().build();
    }


    @PostMapping("/{userID}/update")
    public ResponseEntity updateUser(@RequestBody User user, @PathVariable Integer userID) {

        LocalDate localDate = LocalDate.now();
        user.setUpdateDate(localDate);

        User oneUser = userRepository.getOneUser(userID);

        userRepository.updateUserById(userID, oneUser.getCreateDate(), user.getUpdateDate(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getPhone());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/registration")
    public ResponseEntity addClientUser(UserClient userClient) {

        Random u = new Random();
        Integer id = u.nextInt();
        LocalDate localDate = LocalDate.now();
        Random s = new Random();
        Integer ids = u.nextInt();

        userRepository.registrationOneUser(id, localDate, null, userClient.getEmail(), userClient.getFirstName(), userClient.getLastName(), userClient.getPassword(), userClient.getPhone());
        clientRepository.registrationOneUser(ids,null,null,userClient.getPesel(),null,null,null, id);
        return ResponseEntity.ok().build();
    }


}
