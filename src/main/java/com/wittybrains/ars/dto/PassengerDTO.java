package com.wittybrains.ars.dto;

import com.wittybrains.ars.entity.User;
import com.wittybrains.ars.enums.Gender;

public class PassengerDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private Integer age;

	//@Enumerated(EnumType.STRING)
	private Gender gender;
	private String phone;
	private String email;
	private String password;
	private String confirmPassword;

	public PassengerDTO() {

	}

	public PassengerDTO(User user) {

		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.age = user.getAge();
		this.gender = user.getGender();
		this.phone = user.getPhone();
		this.email = user.getEmail();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	

}
