package com.wittybrains.ars.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wittybrains.ars.dto.PassengerDTO;
import com.wittybrains.ars.entity.User;
import com.wittybrains.ars.exception.UnprocessableEntityException;
import com.wittybrains.ars.repository.PassengerRepository;

@Service
public class PassengerService {

	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<PassengerDTO> getPassenger() {
		return passengerRepository.findAll().stream().map(n -> new PassengerDTO(n)).collect(Collectors.toList());

	}

	public PassengerDTO signUp(PassengerDTO passengerDTO) {
		validatePassenger(passengerDTO);
		User user = new User(passengerDTO);
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		user.setRole(roleService.getPassengerRole());
		user = passengerRepository.save(user);
		return new PassengerDTO(user);
	}

	private void validatePassenger(PassengerDTO passengerDTO) {

		String regex = "^[A-Za-z]{1,29}";

		if (StringUtils.isBlank(passengerDTO.getFirstName()) || StringUtils.isBlank(passengerDTO.getLastName())) {
			throw new UnprocessableEntityException("Please enter a valid name.");
		}

		/*
		 * Will remove the space before and after the name and capitalize the first
		 * letter of the name.
		 */

		passengerDTO.setFirstName(StringUtils.capitalize(passengerDTO.getFirstName().trim()));
		passengerDTO.setLastName(StringUtils.capitalize(passengerDTO.getLastName().trim()));

		/* Not allow numbers and special characters. */

		if (!passengerDTO.getFirstName().matches(regex) || !passengerDTO.getLastName().matches(regex)) {
			throw new UnprocessableEntityException("Please enter a valid name.");
		}

		if (passengerDTO.getAge() < 0 || passengerDTO.getAge() > 100) {
			throw new UnprocessableEntityException("Please enter a valid age.");
		}

//		if (!passengerDTO.getGender().equals(Gender.MALE) || !passengerDTO.getGender().equals(Gender.FEMALE)) {
//			throw new RuntimeException("Please enter a valid gender.");
//		}

//		if (!Gender.isValid(passengerDTO.getGender())) {
//			throw new RuntimeException("Please enter a valid gender.");
//		}

		String phone = "(0|91)?[7-9][0-9]{9}";
		if (!passengerDTO.getPhone().matches(phone)) {
			throw new UnprocessableEntityException("Please enter a valid phone number.");
		}
		String email = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		if (!passengerDTO.getEmail().matches(email)) {
			throw new UnprocessableEntityException("Please enter a valid email.");
		}

		/*
		 * Minimum eight characters, at least one upper case letter, one lower case
		 * letter, one number and one special character.
		 */

		String password = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
		if (!passengerDTO.getPassword().matches(password)
				|| !passengerDTO.getConfirmPassword().equals(passengerDTO.getPassword())) {
			throw new UnprocessableEntityException("Confirm password does not match");
		}

	}

	public List<PassengerDTO> searchPassenger(String firstName, String lastName) {

		return passengerRepository.findByFirstNameAndLastName(firstName, lastName).stream()
				.map(n -> new PassengerDTO(n)).collect(Collectors.toList());

	}

}
