package com.wittybrains.ars.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wittybrains.ars.dto.BookingDTO;
import com.wittybrains.ars.entity.Booking;
import com.wittybrains.ars.entity.Flight;
import com.wittybrains.ars.entity.User;
import com.wittybrains.ars.exception.NotFoundException;
import com.wittybrains.ars.exception.UnprocessableEntityException;
import com.wittybrains.ars.repository.BookingRepository;
import com.wittybrains.ars.repository.FlightRepository;
import com.wittybrains.ars.repository.PassengerRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private PassengerRepository passengerRepository;

	public BookingDTO bookTicket(BookingDTO bookingDTO) {
		validateBooking(bookingDTO);
		Booking booking = new Booking();
		
//		MyUserDetails principal = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		principal.getUsername();
		
		// List<Flight> findCancelFlight = flightRepository.findCancelFlight();

		Optional<Flight> flight = flightRepository.findById(bookingDTO.getFlight().getId());
		if (flight.isPresent()) {

			Flight flightForBooking = flight.get();
			if (flightForBooking.getCancelTime() != null) {
				throw new NotFoundException("Please enter a valid flight id. This flight is canceled");
			}
			booking.setFlight(flightForBooking);
		}

		else {
			throw new NotFoundException("Please enter a valid flight id");
		}

		Optional<User> passenger = passengerRepository.findById(bookingDTO.getPassenger().getId());
		if (passenger.isPresent()) {
			booking.setPassenger(passenger.get());
		}

		booking.setNumOfTickets(bookingDTO.getNumOfTickets());

		booking = bookingRepository.save(booking);
		return new BookingDTO(booking);
	}

	public void validateBooking(BookingDTO bookingDTO) {

		if (bookingDTO.getNumOfTickets() == null || bookingDTO.getNumOfTickets() <= 0) {
			throw new UnprocessableEntityException("Please enter a valid number of ticket");
		}

		if (bookingDTO.getFlight().getId() == null || bookingDTO.getFlight().getId() == 0
				|| !flightRepository.existsById(bookingDTO.getFlight().getId())) {
			throw new NotFoundException("Please enter a valid flight id");
		}

		if (bookingDTO.getPassenger().getId() == null || bookingDTO.getPassenger().getId() == 0
				|| !passengerRepository.existsById(bookingDTO.getPassenger().getId())) {
			throw new NotFoundException("Please enter a valid passenger id");
		}

		// bookingRepository.findDistinctIdByPassengerIdAndFlightId(bookingDTO.getPassenger().getId(),
		// flight.getDepartureTime(), flight.getArrivalTime());
	}

	public void cancelTicket(Long id) {
		validate(id);
//		bookingRepository.deleteById(id);
		Booking booking = bookingRepository.findById(id).get();
		booking.setCancelTime(DateTime.now());
		bookingRepository.save(booking);
	}

	public BookingDTO viewTicket(Long id) {
		validate(id);
		Booking booking = bookingRepository.findById(id).get();
		return new BookingDTO(booking);
	}

	public void validate(Long id) {
		if (!bookingRepository.existsById(id)) {
			throw new NotFoundException("Please enter a valid booking id");
		}
	}

	public List<BookingDTO> getAllBooking() {

		List<Booking> booking = bookingRepository.getBookingList();
		booking.forEach(n -> {
			System.out.println(n);
		});

		System.out.println("______________________________");

		List<Booking> bookingdto2 = bookingRepository.getBookingListById(2l, 1);
		bookingdto2.forEach(n -> {
			System.out.println(n);
		});

		System.out.println("______________________________");

		DateTime start = new DateTime(2021, 7, 22, 01, 00, 0, 0);
		DateTime end = new DateTime(2021, 7, 22, 03, 00, 0, 0);
		List<Booking> bookingdto3 = bookingRepository.findBookings(3l, start, end);
		bookingdto3.forEach(n -> {
			System.out.println(n);
		});

		return bookingRepository.findAll().stream().map(n -> new BookingDTO(n)).collect(Collectors.toList());
	}

}
