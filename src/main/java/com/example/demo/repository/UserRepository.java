package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.cdi.MongoRepositoryBean;

import com.example.demo.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	List<User> findByNom(String Nom);
	
	Optional<User> findByEmail(String email);
}
