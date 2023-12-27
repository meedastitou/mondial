package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("ville")
public class Ville {
	
	@Id
	private String id;
	
	@NotBlank(message="nom must not be null")
	@Nonnull
	private String nom;
	private String description;
	private byte[] photo;
	
}
