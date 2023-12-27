package com.example.demo.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.EntraineurService;
import com.example.demo.model.Entraineur;
import com.example.demo.repository.EntraineurRepository;


import jakarta.validation.Valid;

@Service
public class EntraineurServiceImpl implements EntraineurService {


    @Autowired
    private EntraineurRepository entraineurRepository;
    @Override
    public String save(@Valid Entraineur entraineur) {
        return entraineurRepository.save(entraineur).getId();
    }

    @Override
    public List<Entraineur> getAll() {
        return entraineurRepository.findAll();
    }

    @Override
    public Entraineur getOne(String id) {
        return entraineurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: Joueur is not found."));
    }

    @Override
    public void delete(String id) {
        entraineurRepository.deleteById(id);
    }
    
}
