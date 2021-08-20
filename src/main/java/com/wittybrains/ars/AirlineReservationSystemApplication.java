package com.wittybrains.ars;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.wittybrains.ars.entity.User;
import com.wittybrains.ars.repository.PassengerRepository;

@SpringBootApplication
public class AirlineReservationSystemApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AirlineReservationSystemApplication.class, args);

	}

	@Autowired
	private PassengerRepository passengerRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Word");

		List<User> passenger = passengerRepository.getPassengerByName("Dushyant", "Kumar");
		passenger.forEach(n -> System.out.println(n));

		List<User> pass = passengerRepository.getPassengerByFirstNameAndLastName("Ankit", "Kumar");
		pass.forEach(n -> {
			System.out.println(n);
		});

	}

}
