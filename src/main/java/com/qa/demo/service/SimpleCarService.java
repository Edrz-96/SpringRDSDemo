package com.qa.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.demo.dao.Car;

@Service
public class SimpleCarService {

	private List<Car> cars = new ArrayList<>();
	

	public Car create(Car Car) {
		// Add new Car
		this.cars.add(Car);
		// Return last added Car from List
		return this.cars.get(this.cars.size() - 1);
	}

	public List<Car> readAll() {
		// Return the whole List
		return this.cars;
	}

	public Car update(int id, Car Car) {
		// Remove existing Car with matching 'id'
		this.cars.remove(id);
		// Add new Car in its place
		this.cars.add(id, Car); // Return updated Car from List
		return this.cars.get(id);
	}

	public Car delete(int id) {
		// Remove Car and return it
		return this.cars.remove(id);
	}

}
