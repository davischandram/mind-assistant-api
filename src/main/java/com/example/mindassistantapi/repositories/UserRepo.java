package com.example.mindassistantapi.repositories;

import com.example.mindassistantapi.models.User;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {
    @Query("select user from User user")
    public List<User> findAllUsers();

    @Query("select user from User user where user.id=:uid")
    public User findUserById(@Param("uid") int userId);

    @Query("select user from User user where user.username=:username and user.password=:password")
    public User findUserByCredentials(
            @Param("username") String username,
            @Param("password") String password);

    // @Modifying
    // @Query("update User user set user.dtype = :dtype where user.id = :uid")
    // public void updateDtype(
    //     @Param("dtype") String dtype,
    //     @Param("uid") int uid);
     


    
}
