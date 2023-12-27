package com.example.demo.request;


import com.example.demo.model.Role;
import com.fasterxml.jackson.annotation.JsonIdentityReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	
	private String nom;
	private String prenom;
	private String email;
	private String password;
	
	private String role;
}
