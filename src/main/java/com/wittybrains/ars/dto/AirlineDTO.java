package com.wittybrains.ars.dto;

import com.wittybrains.ars.entity.Airline;

public class AirlineDTO {

	private Long id;
	private String airlineName;

	public AirlineDTO() {

	}

	public AirlineDTO(Airline airline) {
		this.id = airline.getId();
		this.airlineName = airline.getAirlineName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

}
