package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Entraineur;

import jakarta.validation.Valid;

public interface EntraineurService {

    String save(@Valid Entraineur entraineur);

    List<Entraineur> getAll();

    Entraineur getOne(String id);

    void delete(String id);
    
}
