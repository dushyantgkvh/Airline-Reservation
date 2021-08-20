package com.wittybrains.ars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.wittybrains.ars.entity.User;
import com.wittybrains.ars.repository.PassengerRepository;

public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private PassengerRepository passengerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = passengerRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new MyUserDetails(user);
	}

}
