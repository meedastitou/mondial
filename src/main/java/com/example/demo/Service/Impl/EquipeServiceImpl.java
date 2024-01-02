package com.example.demo.Service.Impl;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.EquipeService;
import com.example.demo.model.Equipe;
import com.example.demo.repository.EquipeRepository;

import jakarta.validation.Valid;


@Service
public class EquipeServiceImpl  implements EquipeService{
   
    @Autowired
	private EquipeRepository equipeRepository;
	
	
	public void save(@Valid Equipe equipe, MultipartFile flagImage) {
    try {
        if (flagImage != null && !flagImage.isEmpty()) {
            
            equipe.setDrapeau(flagImage.getBytes());
        }

        
        equipeRepository.save(equipe);
    } catch (IOException e) {
        
        e.printStackTrace(); 
    }
}

	public Equipe getById(String id) {
		return equipeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Error: Equipe is not found."));
	}
	
	public List<Equipe> getAll()
	{
		return equipeRepository.findAll();
	}
	
	public void delete(String id) {
		equipeRepository.deleteById(id);
	}
	
	
    
}
