package com.example.demo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.RoleService;
import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}
	
	public Role getById(String id) {
		return roleRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	}
	
	public List<Role> getAllRoles()
	{
		return roleRepository.findAll();
	}
	
	public void deleteRole(Role role) {
		roleRepository.delete(role);
	}
	
	public Role getByNom(String nom) {
		return roleRepository.findByNom(nom)
			.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	}
}