package com.example.mindassistantapi.repositories;

import com.example.mindassistantapi.models.StudentUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepo extends CrudRepository<StudentUser, Integer> {
    @Query("select student from StudentUser student")
    public List<StudentUser> findAllStudentUsers();
}
