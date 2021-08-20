package com.wittybrains.ars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wittybrains.ars.entity.Role;
import com.wittybrains.ars.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public void addRole(List<Role> role){
		roleRepository.saveAll(role);
	}

	public Role getAdminRole() {
		return roleRepository.findById(1l).get();
	}

	public Role getPassengerRole() {
		return roleRepository.findById(2l).get();
	}
	
	public List<Role> getAllRole(){
		return roleRepository.findAll();
	}
}
