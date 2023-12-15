package com.example.demo.Service;

import java.util.List;

import com.example.demo.Exception.MatchException;
import com.example.demo.model.Match;

public interface MatchService {

    String save(Match match);

    void update(String id, Match match) throws MatchException;

    void delete(String id);

    Match getOne(String id) throws MatchException;

    List<Match> getAll();

   
    
}
