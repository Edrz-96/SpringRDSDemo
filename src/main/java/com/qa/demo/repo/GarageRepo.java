package com.qa.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.demo.dao.Garage;

@Repository
public interface GarageRepo extends JpaRepository<Garage, Long> {


	
	@Query(value = "SELECT * from Garage WHERE location = ?1", nativeQuery = true)
	List<Garage> findByLocation(String str); 

}
