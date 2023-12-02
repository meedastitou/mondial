package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User {
	
	@Id
	private String id;
	
	private String nom;
	private String prenom;
	private String email;
	private String passwrod;
	
	
	
	
	private Role role;
	
}
