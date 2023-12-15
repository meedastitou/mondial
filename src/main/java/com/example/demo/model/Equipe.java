package com.example.demo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
@Document(collection = "Equipe")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Equipe {

    @Id
    private String equipe_id;
    private String nom;
    private Pays pays;
    private List<Joueur> joueurs;
    private Entraineur entraineur;
    
}
