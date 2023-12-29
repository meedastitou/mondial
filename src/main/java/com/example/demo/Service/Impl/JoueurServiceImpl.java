package com.example.demo.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.example.demo.DTO.JoueurDTO;
import com.example.demo.Service.JoueurService;
import com.example.demo.model.Equipe;
import com.example.demo.model.Joueur;
import com.example.demo.repository.EquipeRepository;
import com.example.demo.repository.JoueurRepository;

import jakarta.validation.Valid;
@Service
public class JoueurServiceImpl implements JoueurService {

   
    @Autowired
    private JoueurRepository joueurRepository;

    @Autowired
    private EquipeRepository equipeRepository; 

    

    @Override
    public String save(@Valid Joueur joueur) {
        if (joueur.getPhoto() == null) {
            Joueur joueurUpdated = joueurRepository.findById(joueur.getId())
                    .orElseThrow(() -> new RuntimeException("Error: Joueur is not found."));
            joueur.setPhoto(joueurUpdated.getPhoto());
        }
    
        // Save the player to generate the ID
        Joueur savedJoueur = joueurRepository.save(joueur);
    
        // Associate the player with a team
        if (savedJoueur.getEquipe() != null && savedJoueur.getEquipe().getEquipe_id() != null) {
            Equipe equipe = equipeRepository.findById(savedJoueur.getEquipe().getEquipe_id())
                    .orElseThrow(() -> new RuntimeException("Error: Team is not found."));
            
            // Add the player to the team
            equipe.addJoueur(savedJoueur);
            equipeRepository.save(equipe);
    
            savedJoueur.setEquipe(equipe);
        } else {
            
            throw new RuntimeException("Error: Joueur's team information is missing.");
        }
    
        return savedJoueur.getId();
    }
    
   
    @Override
    public List<JoueurDTO> getAll() {
        List<Joueur> joueurs = joueurRepository.findAll();
        List<JoueurDTO> playerInfoList = new ArrayList<>();

        for (Joueur joueur : joueurs) {
            JoueurDTO playerInfo = new JoueurDTO();
            playerInfo.setId(joueur.getId());
            playerInfo.setNomComplet(joueur.getNomComplet());
            playerInfo.setAge(joueur.getAge());
            playerInfo.setPosition(joueur.getPosition());
            playerInfo.setPhoto(joueur.getPhoto());

            if (joueur.getEquipe() != null) {
                playerInfo.setEquipePays(joueur.getEquipe().getPays()); 
            }

            playerInfoList.add(playerInfo);
        }

        return playerInfoList;
    }

    @Override
    public JoueurDTO getOne(String id) throws Exception {
        Optional<Joueur> joueurOptional = joueurRepository.findById(id);
    
        if (joueurOptional.isPresent()) {
            Joueur joueur = joueurOptional.get();
            JoueurDTO playerInfo = new JoueurDTO();
            playerInfo.setId(joueur.getId());
            playerInfo.setNomComplet(joueur.getNomComplet());
            playerInfo.setAge(joueur.getAge());
            playerInfo.setPosition(joueur.getPosition());
            playerInfo.setPhoto(joueur.getPhoto());
    
            if (joueur.getEquipe() != null) {
                playerInfo.setEquipePays(joueur.getEquipe().getPays());
            }
    
            return playerInfo;
        } else {
            throw new Exception("Joueur with id " + id + " not found");
        }
    }
    
    @Override
    public void delete(String id) {
        joueurRepository.deleteById(id);
    }
}
