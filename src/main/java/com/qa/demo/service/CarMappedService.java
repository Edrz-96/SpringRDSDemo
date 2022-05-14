package com.qa.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.demo.dao.Car;
import com.qa.demo.dto.CarDTO;
import com.qa.demo.exceptions.CarException;
import com.qa.demo.repo.CarRepo;

@Service
public class CarMappedService {

	private CarRepo repo;
	private ModelMapper map;

	public CarMappedService(CarRepo repo, ModelMapper map) {
		this.repo = repo;
		this.map = map;
	}

	private CarDTO mapToDTO(Car car) {
		return this.map.map(car, CarDTO.class);
	}

	// create
	public CarDTO create(Car car) {
		return this.mapToDTO(this.repo.save(car));
	}

	// read
	public List<CarDTO> read() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// read one

	public CarDTO readById(Long id) throws CarException {
		return this.mapToDTO(this.repo.findById(id).orElseThrow(CarException::new));
	}

	// update
	public CarDTO update(CarDTO carDTO, Long id) throws CarException {
		Car updateFromRepo = this.repo.findById(id).orElseThrow(CarException::new);

		updateFromRepo.setDoor(carDTO.getDoor());
		updateFromRepo.setEngineSize(carDTO.getEngineSize());

		return this.mapToDTO(this.repo.saveAndFlush(updateFromRepo));
	}

	// delete
	public boolean delete(Long id) throws CarException {
		this.repo.findById(id).orElseThrow(CarException::new);
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
