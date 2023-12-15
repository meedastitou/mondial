package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Equipe;


public interface EquipeService {

    Equipe save(Equipe equipe);

    List<Equipe> getAll();

    Equipe getById(String id);

    void delete(String id);
    
}
