package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Role;

public interface RoleService {
	public Role saveRole(Role role) ;
	
	public Role getById(String id) ;
	
	public List<Role> getAllRoles();
	
	public void deleteRole(Role role) ;
	
	public Role getByNom(String nom) ;
}
