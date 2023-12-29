package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Equipe")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Equipe {

    @Id
    private String equipe_id;
    private String pays;

    @JsonManagedReference
    @DBRef
    private List<Joueur> joueurs;
    @DBRef
    private Entraineur entraineur;

    @Field("drapeau")
    private byte[] drapeau;


     public void addJoueur(Joueur joueur) {
        if (joueurs == null) {
            joueurs = new ArrayList<>();
        }
        joueurs.add(joueur);
    }
    
}
