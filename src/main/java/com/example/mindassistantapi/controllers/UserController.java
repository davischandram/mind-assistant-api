package com.example.mindassistantapi.controllers;

import com.example.mindassistantapi.models.*;
import com.example.mindassistantapi.models.User;
import org.springframework.web.bind.annotation.*;
import com.example.mindassistantapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(
        origins = {"https://mind-assistant.herokuapp.com/"},
        allowCredentials = "true"
)
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/api/users")
    public List<User> findAllUsers(){
        return service.findAllUsers();
    }

    @GetMapping("/api/users/{uid}")
    public User findUserById(@PathVariable("uid") int userId){
        return service.findUserById(userId);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User newUser, HttpSession session){
        User user = service.findUserByCredentials(newUser.getUsername(), newUser.getPassword());
        session.setAttribute("currentUser", user);
        return user;
    }

    @GetMapping("/currentUser")
    public User currentUser(HttpSession session){
        User current = (User)session.getAttribute("currentUser");
        return current;
    }

    @PostMapping("/logout")
    public void logoutUser(HttpSession session){
        session.invalidate();
    }

    @PostMapping("/api/users")
    public User createUser(@RequestBody User newUser, HttpSession session){
        session.setAttribute("currentUser", newUser);
        return service.createUser(newUser);
    }

    @PutMapping("/api/users/{uid}")
    public int updateUser(@PathVariable("uid") int userId, @RequestBody User updated, HttpSession session){
        session.setAttribute("currentUser", updated);

        return service.updateUser(userId, updated);
    }

    @DeleteMapping("/api/users/{uid}")
    public int deleteUser(@PathVariable("uid") int userId){
        return service.deleteUser(userId);
    }
}
