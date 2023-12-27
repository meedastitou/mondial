package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Entraineur;

public interface EntraineurRepository extends MongoRepository<Entraineur,String>{
    
}
