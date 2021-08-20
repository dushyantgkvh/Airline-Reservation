package com.wittybrains.ars.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.wittybrains.ars.dto.AirlineDTO;

@Entity
@Table(name = "Airline")

public class Airline {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(mappedBy = "airline")
	private List<Flight> flight;

	private String airlineName;

	public Airline() {

	}

	public Airline(Long id, List<Flight> flight, String airlineName) {
		this.id = id;
		this.flight = flight;
		this.airlineName = airlineName;
	}
	
	public Airline(AirlineDTO airlineDTO) {
	
		
		airlineName=airlineDTO.getAirlineName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Flight> getFlight() {
		return flight;
	}

	public void setFlight(List<Flight> flight) {
		this.flight = flight;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

}
