package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

public interface UserService {
	
	User saveUser(User user);
	User getById(String id);
	List<User> getAllUsers();
	void deleteUser(User user);
	Optional<User> findByEmail(String email);
}
