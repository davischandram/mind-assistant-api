package com.example.mindassistantapi.services;

import com.example.mindassistantapi.models.StudentUser;
import com.example.mindassistantapi.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public List<StudentUser> findAllStudentUsers(){
        return studentRepo.findAllStudentUsers();
    }

	public StudentUser createStudentUser(StudentUser newUser) {
		return studentRepo.save(newUser);
	}
}
