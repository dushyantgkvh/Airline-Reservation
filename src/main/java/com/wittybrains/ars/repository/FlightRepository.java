package com.wittybrains.ars.repository;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wittybrains.ars.entity.Airport;
import com.wittybrains.ars.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	Flight save(Flight flight);

	@Query("select f from Flight f where f.source=:source and f.destination=:destination and  CAST(f.departureTime AS date)=:date")
	List<Flight> findBySourceAndDestinationAndDepartureTime(@Param("source") Airport source,
			@Param("destination") Airport destination, @Param("date") Date date);

//	@Query("select f from Flight f where f.cancelTime Is Not Null")
//	List<Flight> findCancelFlight();
	
}
