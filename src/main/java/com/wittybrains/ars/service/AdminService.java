package com.wittybrains.ars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wittybrains.ars.dto.AdminDTO;
import com.wittybrains.ars.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	public AdminDTO logIn(AdminDTO adminDTO) {
		//return adminRepository.save(adminDTO);
		return null;
	}
}
