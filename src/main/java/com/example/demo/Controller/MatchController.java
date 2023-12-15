package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.MatchService;
import com.example.demo.model.Match;



@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping
    public ResponseEntity<String> createMatch(@RequestBody Match match) {
        try {
            String savedMatchId = matchService.save(match);
            return ResponseEntity.ok(savedMatchId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<?> getAllMatches() {
        List<Match> matches = matchService.getAll();
        return matches.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("No matches available")
                : ResponseEntity.ok(matches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMatchById(@PathVariable String id) {
        try {
            Match match = matchService.getOne(id);
            return ResponseEntity.ok(match);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMatch(@PathVariable String id, @RequestBody Match match) {
        try {
            System.out.println("Received PUT request for match ID: " + id);
            
            System.out.println("Received match details: " + match);
            matchService.update(id, match);
            return ResponseEntity.ok("Updated match with id " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMatch(@PathVariable String id) {
        matchService.delete(id);
        return ResponseEntity.ok("Successfully deleted match with id " + id);
    }





    
}

    
   

    

