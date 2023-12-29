package com.example.demo.Service;

import java.util.List;

import com.example.demo.DTO.JoueurDTO;
import com.example.demo.model.Joueur;

import jakarta.validation.Valid;

public interface JoueurService {

    String save(@Valid Joueur joueur);

    List<JoueurDTO> getAll();

    JoueurDTO getOne(String id) throws Exception;

    void delete(String id);
    
}
