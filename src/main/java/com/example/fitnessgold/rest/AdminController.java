package com.example.fitnessgold.rest;

import com.example.fitnessgold.dao.ActivityRepository;
import com.example.fitnessgold.dao.AdminRepository;
import com.example.fitnessgold.dao.UserRepository;
import com.example.fitnessgold.model.Activity;
import com.example.fitnessgold.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {



    @Autowired
    private AdminRepository adminRepository;





}
