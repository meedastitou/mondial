package com.example.demo.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.JoueurService;
import com.example.demo.model.Joueur;
import com.example.demo.repository.JoueurRepository;

import jakarta.validation.Valid;

@Service
public class JoueurServiceImpl implements JoueurService {


    @Autowired
    private JoueurRepository joueurRepository;
    @Override
    
    public String save(@Valid Joueur joueur) {
        return joueurRepository.save(joueur).getId();
    }

    @Override
    public List<Joueur> getAll() {
        return joueurRepository.findAll();
    }

    @Override
    public Joueur getOne(String id){
        return joueurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: Joueur is not found."));
        
    }
    

    @Override
    public void delete(String id) {
        joueurRepository.deleteById(id);
    }
    
}
