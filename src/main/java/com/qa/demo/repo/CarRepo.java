package com.qa.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.demo.dao.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {


	
	@Query(value = "SELECT * from Car WHERE engine = ?1", nativeQuery = true)
	List<Car> findByEngine(String str); 

}
