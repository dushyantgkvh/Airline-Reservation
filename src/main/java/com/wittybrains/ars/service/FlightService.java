package com.wittybrains.ars.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wittybrains.ars.dto.FlightDTO;
import com.wittybrains.ars.entity.Airline;
import com.wittybrains.ars.entity.Airplane;
import com.wittybrains.ars.entity.Airport;
import com.wittybrains.ars.entity.Booking;
import com.wittybrains.ars.entity.Flight;
import com.wittybrains.ars.exception.NotFoundException;
import com.wittybrains.ars.exception.UnprocessableEntityException;
import com.wittybrains.ars.repository.AirlineRepository;
import com.wittybrains.ars.repository.AirplaneRepository;
import com.wittybrains.ars.repository.AirportRepository;
import com.wittybrains.ars.repository.BookingRepository;
import com.wittybrains.ars.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private AirlineRepository airlineRepository;
	@Autowired
	private AirplaneRepository airplaneRepository;
	@Autowired
	private AirportRepository airportRepository;
	@Autowired
	private BookingRepository bookingRepository;

	public FlightDTO createFlight(FlightDTO flightDTO) {
		validateFlight(flightDTO);
		Flight flight = new Flight();

		Optional<Airline> airline = airlineRepository.findById(flightDTO.getAirline().getId());
		if (airline.isPresent()) {
			flight.setAirline(airline.get());
		}

		Optional<Airplane> airplane = airplaneRepository.findById(flightDTO.getAirplane().getId());
		if (airplane.isPresent()) {
			flight.setAirplane(airplane.get());
		}

		Optional<Airport> sourceAirport = airportRepository.findById(flightDTO.getSource().getId());
		if (sourceAirport.isPresent()) {
			flight.setSource(sourceAirport.get());
		}

		Optional<Airport> destinationaAirport = airportRepository.findById(flightDTO.getDestination().getId());
		if (destinationaAirport.isPresent()) {
			flight.setDestination(destinationaAirport.get());
		}

		flight.setPrice(flightDTO.getPrice());
		flight.setArrivalTime(flightDTO.getArrivalTime());
		flight.setDepartureTime(flightDTO.getDepartureTime());

		flight = flightRepository.save(flight);
		return new FlightDTO(flight);
	}

	public void validateFlight(FlightDTO flightDTO) {

		if (flightDTO.getAirline().getId() == null || flightDTO.getAirline().getId() == 0
				|| !airlineRepository.existsById(flightDTO.getAirline().getId())) {
			throw new NotFoundException("Please enter valid airline id.");
		}

		if (flightDTO.getAirplane().getId() == null || flightDTO.getAirplane().getId() == 0
				|| !airplaneRepository.existsById(flightDTO.getAirplane().getId())) {
			throw new NotFoundException("Please enter valid airplane id.");
		}

		if (flightDTO.getSource().getId() == null || flightDTO.getSource().getId() == 0
				|| !airportRepository.existsById(flightDTO.getSource().getId())) {
			throw new NotFoundException("Please enter valid source id.");
		}

		if (flightDTO.getDestination().getId() == null || flightDTO.getDestination().getId() == 0
				|| !airportRepository.existsById(flightDTO.getDestination().getId())) {
			throw new NotFoundException("Please enter valid destination id.");
		}

		if (flightDTO.getPrice() <= 0) {
			throw new UnprocessableEntityException("Please enter a valid price");
		}
	}

	public FlightDTO searchFlightById(Long id) {
		validate(id);
		Flight flight = flightRepository.findById(id).get();
		return new FlightDTO(flight);

	}

	public void validate(Long id) {
		if (!flightRepository.existsById(id)) {
			throw new NotFoundException("Please enter a valid flight id");
		}
	}

	public List<FlightDTO> searchFlight(Long sourceId, Long destinationId, String date) {
		// date = date.withTimeAtStartOfDay();

		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dates = null;
		try {
			dates = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// System.out.println(dates);

		// Date dates = new Date();
		// System.out.println(dates);
		Optional<Airport> sourceAirport = airportRepository.findById(sourceId);
		if (!sourceAirport.isPresent()) {
			throw new NotFoundException("Please enter valid source id.");
		}

		Optional<Airport> destinationaAirport = airportRepository.findById(destinationId);
		if (!destinationaAirport.isPresent()) {
			throw new NotFoundException("Please enter valid destination id.");
		}
		// System.out.println(flightRepository.findById(1l).get().getDepartureTime().toDate());

		return flightRepository
				.findBySourceAndDestinationAndDepartureTime(sourceAirport.get(), destinationaAirport.get(), dates)
				.stream().map(f -> new FlightDTO(f)).collect(Collectors.toList());

	}

	public void cancelFlight(Long id) {
		validateFlight(id);
		Flight flight = flightRepository.findById(id).get();

		List<Booking> bookings = bookingRepository.getBookingByFlightId(flight.getId());
		bookings.forEach(booking -> {

			booking.setCancelTime(DateTime.now());
		});

		bookingRepository.saveAll(bookings);

		flight.setCancelTime(DateTime.now());
		flightRepository.save(flight);

	}

	public void validateFlight(Long id) {
		if (!flightRepository.existsById(id)) {
			throw new NotFoundException("Please enter a valid flight id");
		}
	}

}
