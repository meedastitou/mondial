package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.mongodb.event.CommandListener;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLinerRunner(UserRepository userRepository, RoleRepository roleRepository) {
		return args -> {
//			var role = Role.builder().nom("ADMIN").description("do anythings").build();
//			role = roleRepository.save(role);
//			var user = User.builder().nom("meed").prenom("astitou").email("astitou@gamil.com").passwrod("123123")
//					.role(role).build();
//			user = userRepository.save(user);
			
			userRepository.deleteAll();
			roleRepository.deleteAll();
		};

	}
}
