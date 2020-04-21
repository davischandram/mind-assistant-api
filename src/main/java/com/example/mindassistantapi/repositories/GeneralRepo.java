package com.example.mindassistantapi.repositories;

import com.example.mindassistantapi.models.GeneralUser;
import com.example.mindassistantapi.models.StudentUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GeneralRepo extends CrudRepository<GeneralUser, Integer> {
    @Query("select general from GeneralUser general")
    public List<StudentUser> findAllGeneralUsers();
}
