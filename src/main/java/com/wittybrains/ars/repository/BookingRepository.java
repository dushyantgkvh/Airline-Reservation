package com.wittybrains.ars.repository;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wittybrains.ars.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	Booking save(Booking booking);

//	@Query(value = "SELECT b FROM Booking b WHERE b.passengerId=:pId")
//	List<Booking> findDistinctIdByPassengerIdAndFlightId(@Param(value = "pId") Long passengerId, DateTime departureTime, DateTime arrivalTime);

	@Query("select b FROM Booking b")
	public List<Booking> getBookingList();

	@Query("select b FROM Booking b WHERE b.id=:i AND b.numOfTickets=:nOT")
	public List<Booking> getBookingListById(@Param(value = "i") Long id, @Param(value = "nOT") Integer numOfTickets);

	// @Query(value = "select * from booking", nativeQuery = true)

//	@Query(value = "SELECT f.id, f.departure_time, f.arrival_time, b.id AS booking_id, u.id AS passenger_id\r\n"
//			+ "FROM booking as b JOIN flight as f\r\n"
//			+ "ON b.flight_id=f.id\r\n"
//			+ "JOIN users AS u\r\n"
//			+ "ON b.passenger_id=u.id\r\n"
//			+ "WHERE f.departure_time BETWEEN '2021-07-22 01:00:00' AND '2021-07-22 03:00:00'\r\n"
//			+ "AND f.arrival_time BETWEEN '2021-07-22 01:00:00' AND '2021-07-22 03:00:00' AND u.id=3", nativeQuery = true)


	@Query("SELECT b FROM Booking b JOIN b.passenger p JOIN b.flight f WHERE p.id=:passengerId AND (f.departureTime BETWEEN :start AND :end OR f.arrivalTime BETWEEN :start AND :end)")
	public List<Booking> findBookings(@Param("passengerId") Long passengerId, @Param("start") DateTime start,
			@Param("end") DateTime end);
	
	@Query("SELECT b From Booking b JOIN b.flight f WHERE f.id=:flightId")
	List<Booking> getBookingByFlightId(@Param("flightId") Long flightId);
	
	//List<Booking> findByFlightId(Long flightId);

}
