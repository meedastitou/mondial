package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Match;



public interface MatchRepository extends MongoRepository<Match,String> {
    
}
