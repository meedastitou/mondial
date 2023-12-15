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

import com.example.demo.Service.EquipeService;

import com.example.demo.model.Equipe;



@RestController
@RequestMapping("/equipe")
public class EquipeController {
    
    @Autowired
    private  EquipeService equipeService;

    @PostMapping
    public Equipe create(@RequestBody Equipe equipe) {
        return equipeService.save(equipe);
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
    public Equipe update(@PathVariable String id, @RequestBody Equipe updatedEquipe) {
    	updatedEquipe.setEquipe_id(id);
        return equipeService.save(updatedEquipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        equipeService.delete(id);
        return ResponseEntity.ok("Successfully deleted team with id " + id);
    }

}