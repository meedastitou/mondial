package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User findById(String id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Error: User is not found."));
	}
	
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
}
