package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Entraineur;

import com.example.demo.response.EntraineurResponse;

import jakarta.validation.Valid;

public interface EntraineurService {

    String save(@Valid Entraineur entraineur);

    List<EntraineurResponse> getAll();

    EntraineurResponse getOne(String id) throws Exception;

    void delete(String id);

    public Entraineur getByNomComplet(String nom) ;
    
}
