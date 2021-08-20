package com.wittybrains.ars.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.wittybrains.ars.dto.PassengerDTO;
import com.wittybrains.ars.enums.Gender;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	private Role role;

	@OneToMany(mappedBy = "passenger")
	private List<Booking> booking;

	private String firstName;
	private String lastName;
	private Integer age;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String phone;
	private String email;
	private String password;

	public User() {

	}

	public User(Long id, Role role, List<Booking> booking, String firstName, String lastName, Integer age,
			Gender gender, String phone, String email, String password) {

		this.id = id;
		this.role = role;
		this.booking = booking;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	public User(PassengerDTO passengerDTO) {
		firstName = passengerDTO.getFirstName();
		lastName = passengerDTO.getLastName();
		age = passengerDTO.getAge();
		gender = passengerDTO.getGender();
		phone = passengerDTO.getPhone();
		email = passengerDTO.getEmail();
		password = passengerDTO.getPassword();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
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


	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender="
				+ gender + ", phone=" + phone + "]";
	}

}
