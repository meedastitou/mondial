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

import com.example.demo.Service.EquipeService;

import com.example.demo.model.Equipe;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/equipe")
public class EquipeController {
    
    @Autowired
    private  EquipeService equipeService;

    @PostMapping
    public ResponseEntity<String> createTeam(
        @RequestParam("drapeau") MultipartFile flagImage,
        @Valid @RequestPart("data") Equipe equipe) {

    
        equipeService.save(equipe, flagImage);

        return ResponseEntity.ok("Team created successfully");
}


    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Equipe> equipes = equipeService.getAll();
        return equipes.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("No teams available")
                : ResponseEntity.ok(equipes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipe> getById(@PathVariable String id) {
        return ResponseEntity.ok(equipeService.getById(id));
    }


    @PutMapping("/{id}")
    public Equipe update(@PathVariable String id, 
                        @Valid @RequestPart("data") Equipe updatedEquipe,
                        @RequestParam(name = "drapeau", required = false) MultipartFile flagImage) {
        updatedEquipe.setEquipe_id(id);

        // Check if a new flag image is provided
        equipeService.save(updatedEquipe, flagImage);

        return updatedEquipe;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        equipeService.delete(id);
        return ResponseEntity.ok("Successfully deleted team with id " + id);
    }

}