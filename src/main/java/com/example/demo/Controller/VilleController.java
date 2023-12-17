package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
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

import com.example.demo.Service.VilleService;
import com.example.demo.model.Ville;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/villes")
@RequiredArgsConstructor
public class VilleController {

    private final VilleService villeService;

    @PostMapping
    public ResponseEntity<?> createVille(@RequestParam("photo") MultipartFile file, @Valid @RequestPart("data") Ville ville){
    	
    	try {
			ville.setPhoto(file.getBytes());
			return ResponseEntity.ok(villeService.saveVille(ville));
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.ok("problemme");
		}
    	
    }


    @GetMapping
    public ResponseEntity<List<Ville>> getAllVilles() {
        return ResponseEntity.ok(villeService.getAllVilles());
    }

    @GetMapping("/{ville}")
    public ResponseEntity<Ville> getVilleById(@PathVariable Ville ville) {
        return ResponseEntity.ok(ville);
    }


    @PutMapping("/{id}")
    public Ville updateVille( @RequestBody Ville updatedVille) {
        return villeService.saveVille(updatedVille);
    }

    @DeleteMapping("/{ville}")
    public void deleteVille(@PathVariable Ville ville) {
    	
        villeService.deleteVille(ville);
    }
    
   
}
