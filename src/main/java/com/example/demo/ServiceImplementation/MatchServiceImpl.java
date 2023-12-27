package com.example.demo.ServiceImplementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.MatchException;
import com.example.demo.Service.MatchService;

import com.example.demo.model.Match;

import com.example.demo.repository.MatchRepository;



@Service
public class MatchServiceImpl implements MatchService {


    @Autowired
    private MatchRepository matchRepository;

    @Autowired 
    private MongoTemplate mongoTemplate;

    @Override
    public String save(Match match) {
        return matchRepository.save(match).getMatchId();
    }

    @Override
    public List<Match> getAll() {
        return matchRepository.findAll();
    }


    @Override
    public void delete(String id){
        matchRepository.deleteById(id);
    }

    @Override
    public Match getOne(String id) throws MatchException {
        return matchRepository.findById(id)
            .orElseThrow(() -> new MatchException(MatchException.NotFoundException(id)));
            //The orElseThrow method is used to either get the value from the Optional if it is present or throw an exception if it is not
    }

    @Override
    public Page<Match> search(String stade, LocalDateTime dateTime, String equipe, String status,
            Pageable pageable) {
        Query query = new Query().with(pageable);
        List<Criteria> criteria = new ArrayList<>();

        if(stade != null && !stade.isEmpty()){
            criteria.add(Criteria.where("stade").regex(stade,"i"));
        }

        if (dateTime != null) {
            criteria.add(Criteria.where("dateTime").is(dateTime));
        }

        if (status != null) {
            criteria.add(Criteria.where("status").is(status));
        }

        
        
        /*if (equipe != null && !equipe.isEmpty()) {
        
        criteria.add(Criteria.where("equipe1.nom").is(equipe));
        
        }*/
        

        if(!criteria.isEmpty()){
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
        }

        Page<Match> matches = PageableExecutionUtils.getPage(
                mongoTemplate.find(query,Match.class)
                ,pageable,
                () -> mongoTemplate.count(query.skip(0).limit(0),Match.class));
               

        return matches;
    }

    
    
}
