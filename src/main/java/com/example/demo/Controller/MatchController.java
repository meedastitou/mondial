package com.example.demo.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

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
    public ResponseEntity<String> updateMatch(@RequestBody Match match) {
        try {
            String updatedMatch = matchService.save(match);
            return ResponseEntity.ok(updatedMatch);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMatch(@PathVariable String id) {
        matchService.delete(id);
        return ResponseEntity.ok("Successfully deleted match with id " + id);
    }


    @GetMapping("/search")
    public Page<Match> searchMatch(
            @RequestParam(required = false)  String stade,
            @RequestParam(required = false) LocalDateTime dateTime,
            @RequestParam(required = false) String equipe,
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "4") Integer size

    ){
        Pageable pageable = PageRequest.of(page, size);
        return matchService.search(stade,dateTime,equipe,status,pageable);
    }



    
}

    
   

    

