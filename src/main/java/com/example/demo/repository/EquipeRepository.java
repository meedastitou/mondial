package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Equipe;

public interface EquipeRepository extends MongoRepository<Equipe , String>{
    Optional<Equipe> findByPays(String pays);
}
