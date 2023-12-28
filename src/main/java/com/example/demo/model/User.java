package com.example.demo.model;

import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User implements UserDetails{
	
	@Id
	private String id;
	
	@NotBlank(message = "nom must be not null")
	@Min(message = "nom must be more then 3 charachter", value = 3)
	private String nom;
	@NotBlank(message = "prenom must be not null")
	@Min(message = "prenom must be more then 3 charachter", value = 3)
	private String prenom;

	@NotBlank(message = "email must be not null")
	@Email(message = "email is not valid")
	private String email;
	
	private String password;
	
	
	
	@DBRef
	private Role role;




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority(role.getNom()));
	}




	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}




	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}




	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}




	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}




	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}




	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
