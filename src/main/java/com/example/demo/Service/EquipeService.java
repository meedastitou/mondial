package com.example.demo.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Equipe;

import jakarta.validation.Valid;


public interface EquipeService {


    List<Equipe> getAll();

    Equipe getById(String id);

    void delete(String id);

    void save(@Valid Equipe equipe, MultipartFile flagImage);
    
}
