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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.EntraineurService;
import com.example.demo.model.Entraineur;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/entraineur")
public class EntraineurController {
    
    @Autowired
    private EntraineurService entraineurService;

     @PostMapping
    public ResponseEntity<String> createCoach(@RequestParam("photo") MultipartFile file, @Valid @RequestPart("data")  Entraineur entraineur) {
        try {
            entraineur.setPhoto(file.getBytes());
            String savedEntraineurId = entraineurService.save(entraineur);
            return ResponseEntity.ok(savedEntraineurId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }



    @GetMapping
    public ResponseEntity<?> getAllCoachs() {
        List<Entraineur> entraineurs = entraineurService.getAll();
        return entraineurs.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("No coachs available")
                : ResponseEntity.ok(entraineurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCoachById(@PathVariable String id) {
        try {
            Entraineur entraineur = entraineurService.getOne(id);
            return ResponseEntity.ok(entraineur);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCoach(@RequestBody Entraineur entraineur) {
        try {
            String updatedEntraineur = entraineurService.save(entraineur);
            return ResponseEntity.ok(updatedEntraineur);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCoach(@PathVariable String id) {
        entraineurService.delete(id);
        return ResponseEntity.ok("Successfully deleted coach with id " + id);
    }


}
