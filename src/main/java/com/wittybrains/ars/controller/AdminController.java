package com.wittybrains.ars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wittybrains.ars.dto.AdminDTO;
import com.wittybrains.ars.service.AdminService;

@RestController
@RequestMapping(path="/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping(path = "/log-in")
	public AdminDTO logIn(@RequestBody AdminDTO adminDTO) {
		return adminService.logIn(adminDTO);
	}

}
 