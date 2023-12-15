package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Joueur {

    private String nom;
    private String prenom;
    private Integer age;
    private String nationalite;
    private String position;
    
}
