package com.wittybrains.ars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wittybrains.ars.entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

}
