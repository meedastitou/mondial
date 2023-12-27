package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Joueur;

import jakarta.validation.Valid;

public interface JoueurService {

    String save(@Valid Joueur joueur);

    List<Joueur> getAll();

    Joueur getOne(String id);

    void delete(String id);
    
}
