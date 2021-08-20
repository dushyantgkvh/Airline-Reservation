package com.wittybrains.ars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wittybrains.ars.dto.BookingDTO;
import com.wittybrains.ars.entity.Booking;
import com.wittybrains.ars.service.BookingService;

@RestController
@RequestMapping(path = "/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@PostMapping
	public BookingDTO bookTicket(@RequestBody BookingDTO bookingDTO) {
		return bookingService.bookTicket(bookingDTO);
	}

	@DeleteMapping(path = "/{id}")
	public void cancelTicket(@PathVariable("id") Long id) {
		bookingService.cancelTicket(id);
	}

	@GetMapping
	public List<BookingDTO> getAllBooking() {
		return bookingService.getAllBooking();
	}
	
	@GetMapping(path = "/view/{id}")
	public BookingDTO viewTicket(@PathVariable("id") Long id) {
		return bookingService.viewTicket(id);
	}

}
