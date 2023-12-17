package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Ville;

public interface VilleService {
	public Ville saveVille(Ville ville) ;
	
	public Ville getById(String id) ;
	
	public List<Ville> getAllVilles();
	
	public void deleteVille(Ville ville) ;
	
	public Ville getByNom(String nom) ;
}
