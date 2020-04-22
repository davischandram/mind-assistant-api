package com.example.mindassistantapi.controllers;

import com.example.mindassistantapi.models.StudentUser;
import com.example.mindassistantapi.services.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@CrossOrigin(
        origins = {"http://localhost:3000", "https://mind-assistant.herokuapp.com/"},
        allowCredentials = "true"
)
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping("/api/students")
    public List<StudentUser> findAllStudentUsers(){
        return service.findAllStudentUsers();
    }

    @PostMapping("/api/students")
    public StudentUser createStudentUser(@RequestBody StudentUser newUser)
    {
        return service.createStudentUser(newUser);

    }
    
}
