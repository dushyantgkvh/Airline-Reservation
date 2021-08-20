package com.wittybrains.ars.dto;

import com.wittybrains.ars.entity.Airplane;

public class AirplaneDTO {
	private Long id;
	private String airplaneName;
	private Integer seats;

	public AirplaneDTO() {

	}

	public AirplaneDTO(Airplane airplane) {
		this.id = airplane.getId();
		this.airplaneName = airplane.getAirplaneName();
		this.seats = airplane.getSeats();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirplaneName() {
		return airplaneName;
	}

	public void setAirplaneName(String airplaneName) {
		this.airplaneName = airplaneName;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

}
