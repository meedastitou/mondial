package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Ville;


public interface VilleRepository extends MongoRepository<Ville, String>{
	Optional<Ville> findByNom(String nom);
}
