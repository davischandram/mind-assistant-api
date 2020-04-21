package com.example.mindassistantapi.controllers;

import com.example.mindassistantapi.models.Note;
import com.example.mindassistantapi.models.Profile;
import com.example.mindassistantapi.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
        origins = {"http://localhost:3000", "https://mind-assistant.herokuapp.com/"},
        allowCredentials = "true"
)
public class ProfileController {
    @Autowired
    ProfileService service;

    @GetMapping("/api/profiles")
    public List<Profile> findAllProfiles(){
        return service.findAllProfiles();
    }

    @GetMapping("/api/users/{uid}/profiles")
    public Profile findProfileByUser(@PathVariable("uid") int userId){
        return service.findProfileByUser(userId);
    }

    @PostMapping("/api/users/{uid}/profiles")
    public Profile createProfileForUser(@PathVariable("uid") int userId, @RequestBody Profile newProfile){
        return service.createProfileForUser(userId, newProfile);
    }

    @PutMapping("/api/users/{uid}/profiles")
    public int updateProfile(@PathVariable("uid") int userId, @RequestBody Profile updatedProfile){
        return service.updateProfile(userId, updatedProfile);
    }
}
