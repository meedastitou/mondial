package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Entraineur;


public interface EntraineurRepository extends MongoRepository<Entraineur,String>{
    Optional<Entraineur> findByNomComplet(String nom);
}
