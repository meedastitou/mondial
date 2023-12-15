package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Equipe;

public interface EquipeRepository extends MongoRepository<Equipe , String>{
    
}
