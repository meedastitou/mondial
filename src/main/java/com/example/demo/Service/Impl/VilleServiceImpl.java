package com.example.demo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.VilleService;
import com.example.demo.model.Ville;
import com.example.demo.repository.VilleRepository;

@Service
public class VilleServiceImpl implements VilleService {
	
	@Autowired
	VilleRepository villeRepository;
	
	
	public Ville saveVille(Ville villeUpdated) {
		if(villeUpdated.getPhoto() == null) {
		
			Ville ville = villeRepository.findById(villeUpdated.getId()).get();
			villeUpdated.setPhoto(ville.getPhoto());
		
		}
		return villeRepository.save(villeUpdated);
	}
	
	public Ville getById(String id) {
		return villeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Error: Ville is not found."));
	}
	
	public List<Ville> getAllVilles()
	{
		return villeRepository.findAll();
	}
	
	public void deleteVille(Ville ville) {
		villeRepository.delete(ville);
	}
	
	public Ville getByNom(String nom) {
		return villeRepository.findByNom(nom)
			.orElseThrow(() -> new RuntimeException("Error: Ville is not found."));
	}
}