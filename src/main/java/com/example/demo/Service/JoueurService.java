package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Joueur;
import com.example.demo.response.JoueurResponse;

import jakarta.validation.Valid;

public interface JoueurService {

    String save(@Valid Joueur joueur);

    List<JoueurResponse> getAll();

    JoueurResponse getOne(String id) throws Exception;

    void delete(String id);
    
}
