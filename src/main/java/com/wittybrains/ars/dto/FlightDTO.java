package com.wittybrains.ars.dto;

import org.joda.time.DateTime;

import com.wittybrains.ars.entity.Flight;

public class FlightDTO {

	private Long id;
	private AirplaneDTO airplane;
	private AirportDTO source;
	private AirportDTO destination;
	private AirlineDTO airline;

	private DateTime departureTime;
	private DateTime arrivalTime;
	private Double price;
	private DateTime cancelTime;

	public FlightDTO() {

	}

	public FlightDTO(Flight flight) {

		this.id = flight.getId();
		this.airplane = new AirplaneDTO(flight.getAirplane());
		this.source = new AirportDTO(flight.getSource());
		this.destination = new AirportDTO(flight.getDestination());
		this.airline = new AirlineDTO(flight.getAirline());
		this.departureTime = flight.getDepartureTime();
		this.arrivalTime = flight.getArrivalTime();
		this.price = flight.getPrice();
		this.cancelTime=flight.getCancelTime();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AirplaneDTO getAirplane() {
		return airplane;
	}

	public void setAirplane(AirplaneDTO airplane) {
		this.airplane = airplane;
	}

	public AirportDTO getSource() {
		return source;
	}

	public void setSource(AirportDTO source) {
		this.source = source;
	}

	public AirportDTO getDestination() {
		return destination;
	}

	public void setDestination(AirportDTO destination) {
		this.destination = destination;
	}

	public AirlineDTO getAirline() {
		return airline;
	}

	public void setAirline(AirlineDTO airline) {
		this.airline = airline;
	}

	public DateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(DateTime departureTime) {
		this.departureTime = departureTime;
	}

	public DateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(DateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public DateTime getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(DateTime cancelTime) {
		this.cancelTime = cancelTime;
	}

	@Override
	public String toString() {
		return "FlightDTO [id=" + id + ", source=" + source + ", destination=" + destination + "]";
	}

}
