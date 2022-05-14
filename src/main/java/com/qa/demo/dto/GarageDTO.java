package com.qa.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import com.qa.demo.dao.Car;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class GarageDTO {

	Long id;

	String location;

	List<Car> carsInGarage = new ArrayList<>(500);

	int capacity;

}
