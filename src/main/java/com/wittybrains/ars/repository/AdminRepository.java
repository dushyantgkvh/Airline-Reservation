package com.wittybrains.ars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wittybrains.ars.entity.User;

@Repository
public interface AdminRepository extends JpaRepository<User, Long> {

}
