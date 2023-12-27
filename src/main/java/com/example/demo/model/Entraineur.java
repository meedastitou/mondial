package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Entraineur")
public class Entraineur {

    @Id
    private String id;
    private String nomComplet;
    private Integer age;
    @DBRef
    private Equipe equipe;
    @Field("photo")
    private byte[] photo;
    

}
