package com.wittybrains.ars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wittybrains.ars.dto.PassengerDTO;
import com.wittybrains.ars.service.PassengerService;

@RestController
@RequestMapping(path = "/passenger")
public class PassengerController {
	@Autowired
	private PassengerService passengerService;

	@PostMapping(path = "/sign-up")
	public PassengerDTO signUp(@RequestBody PassengerDTO passengerDTO) {
		return passengerService.signUp(passengerDTO);
	}

	@GetMapping(path = "/pass")
	public List<PassengerDTO> getPassenger() {
		return passengerService.getPassenger();
	}
	
//	@GetMapping(path = "/search/{firstName}/{lastName}")
	@GetMapping(path = "/search")
	public List<PassengerDTO> searchPassenger(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
		return passengerService.searchPassenger(firstName, lastName);
	}

}
