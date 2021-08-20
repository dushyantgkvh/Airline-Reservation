package com.wittybrains.ars.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.wittybrains.ars.dto.BookingDTO;

@Entity
@Table(name = "Booking")
//@SQLDelete(sql = "update booking set active=0 where id=?")
//@Where(clause = "active=0")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "flight_id")
	private Flight flight;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "passenger_id")
	private User passenger;

	private Integer numOfTickets;
	private DateTime cancelTime;

	// private boolean active = Boolean.TRUE;

	public Booking() {

	}

	public Booking(Long id, Flight flight, User passenger, Integer numOfTickets, DateTime cancelTime) {

		this.id = id;
		this.flight = flight;
		this.passenger = passenger;
		this.numOfTickets = numOfTickets;
		this.cancelTime=cancelTime;
	}

	public Booking(BookingDTO bookingDTO) {
		flight = new Flight(bookingDTO.getFlight());
		passenger = new User(bookingDTO.getPassenger());
		numOfTickets = bookingDTO.getNumOfTickets();
		cancelTime=bookingDTO.getCancelTime();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public User getPassenger() {
		return passenger;
	}

	public void setPassenger(User passenger) {
		this.passenger = passenger;
	}

	public Integer getNumOfTickets() {
		return numOfTickets;
	}

	public void setNumOfTickets(Integer numOfTickets) {
		this.numOfTickets = numOfTickets;
	}

	public DateTime getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(DateTime cancelTime) {
		this.cancelTime = cancelTime;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", flight=" + flight + ", passenger=" + passenger + ", numOfTickets="
				+ numOfTickets + ", cancelTime=" + cancelTime + "]";
	}

//	public boolean isActive() {
//		return active;
//	}
//
//	public void setActive(boolean active) {
//		this.active = active;
//	}

}
