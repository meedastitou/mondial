package com.example.demo.ServiceImplementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.EquipeService;
import com.example.demo.model.Equipe;
import com.example.demo.repository.EquipeRepository;


@Service
public class EquipeServiceImpl  implements EquipeService{
   
    @Autowired
	private EquipeRepository equipeRepository;
	
	
	public Equipe save(Equipe equipe) {
		return equipeRepository.save(equipe);
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
