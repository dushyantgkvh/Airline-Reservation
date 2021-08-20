package com.wittybrains.ars.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.wittybrains.ars.dto.AirplaneDTO;

@Entity
@Table(name = "Airplane")

public class Airplane {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String airplaneName;
	private Integer seats;

	@OneToMany(mappedBy = "airplane")
	private List<Flight> flight;

	public Airplane() {

	}

	public Airplane(Long id, String airplaneName, Integer seats, List<Flight> flight) {
		this.id = id;
		this.airplaneName = airplaneName;
		this.seats = seats;
		this.flight = flight;
	}
	public Airplane(AirplaneDTO airplaneDTO) {
		
		airplaneName=airplaneDTO.getAirplaneName();
		seats=airplaneDTO.getSeats();

		
	
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

	public List<Flight> getFlight() {
		return flight;
	}

	public void setFlight(List<Flight> flight) {
		this.flight = flight;
	}

}
