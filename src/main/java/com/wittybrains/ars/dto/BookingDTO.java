package com.wittybrains.ars.dto;

import org.joda.time.DateTime;

import com.wittybrains.ars.entity.Booking;

public class BookingDTO {
	private Long id;
	private Integer numOfTickets;
	private FlightDTO flight;
	private PassengerDTO passenger;
	private DateTime cancelTime;

	public BookingDTO() {

	}

	public BookingDTO(Booking booking) {
		this.id = booking.getId();
		this.numOfTickets = booking.getNumOfTickets();
		this.cancelTime=booking.getCancelTime();
		this.flight = new FlightDTO(booking.getFlight());
		this.passenger = new PassengerDTO(booking.getPassenger());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumOfTickets() {
		return numOfTickets;
	}

	public void setNumOfTickets(Integer numOfTickets) {
		this.numOfTickets = numOfTickets;
	}

	public FlightDTO getFlight() {
		return flight;
	}

	public void setFlight(FlightDTO flight) {
		this.flight = flight;
	}

	public PassengerDTO getPassenger() {
		return passenger;
	}

	public void setPassenger(PassengerDTO passenger) {
		this.passenger = passenger;
	}

	public DateTime getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(DateTime cancelTime) {
		this.cancelTime = cancelTime;
	}

	@Override
	public String toString() {
		return "BookingDTO [id=" + id + ", numOfTickets=" + numOfTickets + ", flight=" + flight + ", passenger="
				+ passenger + ", cancelTime=" + cancelTime + "]";
	}

}
