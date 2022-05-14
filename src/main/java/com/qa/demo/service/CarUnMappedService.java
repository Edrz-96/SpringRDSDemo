package com.qa.demo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeException;

import com.qa.demo.dao.Car;
import com.qa.demo.exceptions.CarException;
import com.qa.demo.repo.CarRepo;

@Service
public class CarUnMappedService {

	private CarRepo repo;

	public CarUnMappedService(CarRepo repo) {
		this.repo = repo;
	}

	// create
	public Car create(Car car) {
		return this.repo.saveAndFlush(car);
	}

	// read
	public List<Car> read() {
		return this.repo.findAll();
	}

	// update
	public Car update(Long id, Car car) throws Exception {
		Car update = this.repo.findById(id).orElseThrow(CarException::new);
		update.setDoor(car.getDoor());
		update.setEngineSize(car.getEngineSize());
		return this.repo.saveAndFlush(update);

	}

	// delete
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);

	}

	public List<Car> findByEngine(String str) {
		return this.repo.findByEngine(str);

	}

}
