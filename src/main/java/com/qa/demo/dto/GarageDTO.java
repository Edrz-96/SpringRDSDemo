package com.qa.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import com.qa.demo.dao.Car;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GarageDTO {

	Long id;

	String location;
	
	int capacity;

	List<Car> carsInGarage = new ArrayList<>(capacity);

}
