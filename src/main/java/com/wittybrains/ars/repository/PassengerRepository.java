package com.wittybrains.ars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.wittybrains.ars.entity.User;

@Repository
public interface PassengerRepository extends JpaRepository<User, Long> {
	User save(User user);

	// Query Method
	public List<User> findByFirstNameAndLastName(String firstName, String lastName);

	// JPQL Query
//	@Query("select u from User u where u.firstName=?1 and u.lastName=?2")
//	public List<User> getPassengerByName(String firstName, String lastName);

	// JPQL Query using named parameters
	@Query("select u from User u where u.firstName=:firstName and u.lastName=:lastName")
	public List<User> getPassengerByName(@Param("firstName") String firstName, @Param("lastName") String lastName);

	// Native Query
	@Query(value = "select * from users as u where u.first_name=?1 and u.last_name=?2", nativeQuery = true)
	public List<User> getPassengerByFirstNameAndLastName(String firstName, String lastName);

	
	public User findByEmail(String username);
	
}
