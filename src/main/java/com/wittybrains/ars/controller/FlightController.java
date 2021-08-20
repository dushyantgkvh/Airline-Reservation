
package com.wittybrains.ars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wittybrains.ars.dto.FlightDTO;
import com.wittybrains.ars.service.FlightService;

@RestController
@RequestMapping(path = "/flight")
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private Environment environment;

	@PostMapping("/create")
	public FlightDTO createFlight(@RequestBody FlightDTO flightDTO) {
		return flightService.createFlight(flightDTO);

	}

	@GetMapping("/searchById")
	public FlightDTO searchFlightById(@RequestParam("id") Long id) {
		return flightService.searchFlightById(id);
	}

	@GetMapping("/search")
	public List<FlightDTO> searchFlight(@RequestParam("sourceId") Long sourceId,
			@RequestParam("destinationId") Long destinationId, @RequestParam("date") String date) {
		return flightService.searchFlight(sourceId, destinationId, date);

	}
	
	@DeleteMapping(path = "/cancel/{id}")
	public void cancelFlight(@PathVariable("id") Long id) {
		flightService.cancelFlight(id);
		
	}
	
	@GetMapping("/envdetails")
	public String envDetails() {
		return environment.toString();
	}

}