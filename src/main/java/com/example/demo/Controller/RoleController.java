package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.RoleService;
import com.example.demo.model.Role;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {
	private final RoleService roleService;

    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleService.saveRole(role);
    }


    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable String id) {
        return roleService.getById(id);
    }


    @PutMapping("/{id}")
    public Role updateRole(@PathVariable String id, @RequestBody Role updatedRole) {
    	updatedRole.setId(id);
        return roleService.saveRole(updatedRole);
    }

    @DeleteMapping("/{role}")
    public void deleteRole(@PathVariable Role role) {
    	
        roleService.deleteRole(role);
    }
}
