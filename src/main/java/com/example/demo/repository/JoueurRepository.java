package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.example.demo.model.Joueur;

public interface JoueurRepository extends MongoRepository<Joueur,String>{
    
}
