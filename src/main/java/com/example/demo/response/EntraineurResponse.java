package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntraineurResponse {
    private String nomComplet;
    private Integer age;
    private byte[] photo;
    private String equipePays;
   
}
