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

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.JoueurService;
import com.example.demo.model.Joueur;
import com.example.demo.response.JoueurResponse;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/joueur")
public class JoueurController {
    

    @Autowired
    private JoueurService joueurService;

     @PostMapping
    public ResponseEntity<String> createPlayer(@RequestParam("photo") MultipartFile file, @Valid @RequestPart("data")  Joueur joueur) {
        try {
            joueur.setPhoto(file.getBytes());
            String savedJoueurId = joueurService.save(joueur);
            return ResponseEntity.ok(savedJoueurId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

 

    @GetMapping
    public ResponseEntity<?> getAllPlayers() {
        List<JoueurResponse> joueurs = joueurService.getAll();
        return joueurs.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("No joueurs available")
                : ResponseEntity.ok(joueurs);
    }

     

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlayerById(@PathVariable String id) {
        try {
            JoueurResponse joueur = joueurService.getOne(id);
            return ResponseEntity.ok(joueur);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlayer(@RequestParam("photo") MultipartFile file, @Valid @RequestPart("data")  Joueur joueur) {
        try {
            joueur.setPhoto(file.getBytes());
            String updatedJoueur = joueurService.save(joueur);
            return ResponseEntity.ok(updatedJoueur);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable String id) {
        joueurService.delete(id);
        return ResponseEntity.ok("Successfully deleted joueur with id " + id);
    }


}
