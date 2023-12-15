package com.example.demo.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.MatchException;
import com.example.demo.Service.MatchService;
import com.example.demo.model.Match;
import com.example.demo.repository.MatchRepository;



@Service
public class MatchServiceImpl implements MatchService {


    @Autowired
    private MatchRepository matchRepository;

    @Override
    public String save(Match match) {
        return matchRepository.save(match).getMatchId();
    }

    @Override
    public List<Match> getAll() {
        return matchRepository.findAll();
    }

    @Override
    public void update(String id, Match match) throws MatchException {
      

        Match updatedMatch = matchRepository.findById(id)
                .orElseThrow(() -> new MatchException(MatchException.NotFoundException(id)));

        updatedMatch.setStade(match.getStade());
        updatedMatch.setDateTime(match.getDateTime());
        updatedMatch.setEquipe1(match.getEquipe1());
        updatedMatch.setEquipe2(match.getEquipe2());
        updatedMatch.setScore_equipe1(match.getScore_equipe1());
        updatedMatch.setScore_equipe2(match.getScore_equipe2());
        updatedMatch.setStatus(match.getStatus());
        updatedMatch.setEvenements(match.getEvenements());

        matchRepository.save(updatedMatch);


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

    
    
}
