package com.example.demo.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.JwtService;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.request.AuthenticationRequest;
import com.example.demo.request.RegisterRequest;
import com.example.demo.response.AuthenticationResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	private final RoleRepository roleRepository;
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	  private final JwtService jwtService;
	  private final AuthenticationManager authenticationManager;
	  private final RoleService roleService;
	public AuthenticationResponse register (RegisterRequest registerRequest) {
		var user = User.builder()
		        .nom(registerRequest.getNom())
		        .prenom(registerRequest.getPrenom())
		        .email(registerRequest.getEmail())
		        .password(passwordEncoder.encode(registerRequest.getPassword()))
		        .role(roleRepository.findById(registerRequest.getRole()).get())
		        .build();
		userService.saveUser(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}
	
	
	public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
		authenticationManager.authenticate(
		        new UsernamePasswordAuthenticationToken(
		        		authenticationRequest.getEmail(),
		        		authenticationRequest.getPassword()
		        )
		    );
		 var user = userService.findByEmail(authenticationRequest.getEmail())
			        .orElseThrow();
		 
		 var jwtToken = jwtService.generateToken(user);
			return AuthenticationResponse.builder()
					.token(jwtToken)
					.build();
	}
}
