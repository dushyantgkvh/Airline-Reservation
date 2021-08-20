package com.wittybrains.ars.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.wittybrains.ars.dto.AirportDTO;

@Entity
@Table(name = "Airport")

public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String airportName;

	@OneToMany(mappedBy = "source")
	private List<Flight> flight;

	private String city;

	public Airport() {

	}

	public Airport(Long id, String airportName, List<Flight> flight, String city) {

		this.id = id;
		this.airportName = airportName;
		this.flight = flight;
		this.city = city;
	}

	public Airport(AirportDTO airportDTO) {
		airportName = airportDTO.getAirportName();
		city = airportDTO.getCity();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public List<Flight> getFlight() {
		return flight;
	}

	public void setFlight(List<Flight> flight) {
		this.flight = flight;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
