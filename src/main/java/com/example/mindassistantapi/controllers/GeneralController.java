//package com.example.mindassistantapi.controllers;
//
//import com.example.mindassistantapi.models.GeneralUser;
//import com.example.mindassistantapi.services.GeneralService;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(
//        origins = {"http://localhost:3000", "https://mind-assistant.herokuapp.com/"},
//        allowCredentials = "true"
//)
//public class GeneralController {
//    @Autowired
//    GeneralService service;
//
//    @GetMapping("/api/generalUsers")
//    public List<GeneralUser> findAllGeneralUsers(){
//        return service.findAllGeneralUsers();
//    }
//}
