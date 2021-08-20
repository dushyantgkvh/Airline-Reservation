package com.wittybrains.ars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wittybrains.ars.entity.Role;
import com.wittybrains.ars.service.RoleService;

@RestController
@RequestMapping(path = "/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@PostMapping
	public void addRole(@RequestBody List<Role> role) {
		roleService.addRole(role);
	}

	@GetMapping
	public Role getRole() {
		return roleService.getAdminRole();
	}

	@GetMapping(path = "/all")
	public List<Role> getAllRole() {
		return roleService.getAllRole();
	}
}
