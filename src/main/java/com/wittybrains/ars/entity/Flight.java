package com.wittybrains.ars.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.joda.time.DateTime;

import com.wittybrains.ars.dto.FlightDTO;

@Entity
@Table(name = "FLIGHT")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "airplane_id")
	private Airplane airplane;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "source_id")
	private Airport source;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "destination_id")
	private Airport destination;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "airline_id")
	private Airline airline;

	@OneToMany(mappedBy = "flight")
	private List<Booking> booking;

	private DateTime departureTime;
	private DateTime arrivalTime;
	private Double price;
	private DateTime cancelTime;

	public Flight() {

	}

	public Flight(Long id, Airplane airplane, Airport source, Airport destination, Airline airline,
			List<Booking> booking, DateTime departureTime, DateTime arrivalTime, Double price, DateTime cancelTime) {

		this.id = id;
		this.airplane = airplane;
		this.source = source;
		this.destination = destination;
		this.airline = airline;
		this.booking = booking;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
		this.cancelTime = cancelTime;
	}

	public Flight(FlightDTO flightDTO) {

		airplane = new Airplane(flightDTO.getAirplane());
		source = new Airport(flightDTO.getSource());
		destination = new Airport(flightDTO.getDestination());
		airline = new Airline(flightDTO.getAirline());
		departureTime = flightDTO.getDepartureTime();
		arrivalTime = flightDTO.getArrivalTime();
		price = flightDTO.getPrice();
		cancelTime=flightDTO.getCancelTime();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public Airport getSource() {
		return source;
	}

	public void setSource(Airport source) {
		this.source = source;
	}

	public Airport getDestination() {
		return destination;
	}

	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
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
		return "Flight [id=" + id + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", price="
				+ price + ", cancelTime=" + cancelTime + "]";
	}

}