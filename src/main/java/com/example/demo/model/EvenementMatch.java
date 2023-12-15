package com.example.demo.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EvenementMatch {

    public enum TypeEvenement {
        BUT,
        CARTON_JAUNE,
        CARTON_ROUGE
        
    }

    private LocalDateTime timestamp;
    private TypeEvenement typeEvenement;
    private String description;
    private Joueur joueur;

}
