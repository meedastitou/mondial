package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoueurDTO {
    private String id;
    private String nomComplet;
    private Integer age;
    private String position;
    private byte[] photo;
    private String equipePays;

}
