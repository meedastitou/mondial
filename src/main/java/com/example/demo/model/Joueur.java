package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonBackReference;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Joueur")
public class Joueur {

    @Id
    private String id;
    private String nomComplet;
    private Integer age;
    @JsonBackReference
    @DBRef
    private Equipe equipe;
    private String position;
    @Field("photo")
    private byte[] photo;
    
    @Transient
    public String getEquipePays() {
        return equipe != null ? equipe.getPays() : null;
    }
    
}
