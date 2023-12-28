package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;

public interface UserService {
	
	User saveUser(User user);
	User getById(String id);
	List<User> getAllUsers();
	void deleteUser(User user);
	Optional<User> findByEmail(String email);
}
