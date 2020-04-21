package com.example.mindassistantapi.services;

import com.example.mindassistantapi.models.User;
import com.example.mindassistantapi.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<User> findAllUsers(){
        return userRepo.findAllUsers();
    }

    public User findUserById(int userId){
        return userRepo.findUserById(userId);
    }

    public User findUserByCredentials(String username, String password){
        return userRepo.findUserByCredentials(username,password);
    }

    public User createUser(User user){
        return userRepo.save(user);
    }

    public int updateUser(int userId, User user){
        userRepo.save(user);
        User confirm = userRepo.findUserById(userId);
        if(user.equals(confirm)){
            return 1;
        } else {
            return 0;
        }
    }

    public int deleteUser(int userId){
        userRepo.deleteById(userId);
        if(userRepo.findUserById(userId) == null) {
            return 1;
        } else {
            return 0;
        }
    }
}
