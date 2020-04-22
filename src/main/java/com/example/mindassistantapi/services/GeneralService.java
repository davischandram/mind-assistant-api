package com.example.mindassistantapi.services;

import com.example.mindassistantapi.models.GeneralUser;
import com.example.mindassistantapi.repositories.GeneralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralService {
    @Autowired
    GeneralRepo generalRepo;

    public List<GeneralUser> findAllGeneralUsers(){
        return (List<GeneralUser>) generalRepo.findAll();
    }

	public GeneralUser createGeneralUser(GeneralUser newUser) {
		return generalRepo.save(newUser);
	}
}
