package com.wittybrains.ars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wittybrains.ars.entity.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long>{

}
