package com.wittybrains.ars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wittybrains.ars.entity.Airplane;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

}
