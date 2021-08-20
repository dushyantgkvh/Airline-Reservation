package com.wittybrains.ars.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/passenger/sign-up").permitAll()
			.antMatchers("/").hasAnyAuthority("Passenegr", "Admin") 
			.antMatchers("/booking/**", "/passenger/**").hasAuthority("Passenger")
			.antMatchers("/flight").hasAnyAuthority("Passenegr", "Admin")
			.antMatchers("/flight/create", "/flight/cancel/{id}").hasAuthority("Admin")
			.anyRequest().authenticated();
	}	

}
