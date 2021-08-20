package com.wittybrains.ars.dto;

import com.wittybrains.ars.entity.Airport;

public class AirportDTO {

	private Long id;
	private String airportName;
	private String city;

	public AirportDTO() {

	}

	public AirportDTO(Airport airport) {
		this.id = airport.getId();
		this.airportName = airport.getAirportName();
		this.city = airport.getCity();
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
