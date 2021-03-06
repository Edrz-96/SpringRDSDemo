package com.qa.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.demo.dao.Garage;
import com.qa.demo.dto.GarageDTO;
import com.qa.demo.exceptions.GarageException;
import com.qa.demo.repo.GarageRepo;

@Service
public class GarageService {

	private GarageRepo repo;
	private ModelMapper map;

	public GarageService(GarageRepo repo, ModelMapper map) {
		this.repo = repo;
		this.map = map;
	}

	private GarageDTO mapToDTO(Garage garage) {
		return this.map.map(garage, GarageDTO.class);
	}

	// create
	public GarageDTO create(Garage garage) {
		return this.mapToDTO(this.repo.save(garage));
		// logic // 
		// as a car is created the service should check the backend so that the capacity
		// limitation matches the arraylist size,
		// given java hasn't got that sort of implementation bar
		// Collections.unmodifiableCollection(list);

	}

	// read
	public List<GarageDTO> read() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// read one

	public GarageDTO readById(Long id) throws GarageException {
		return this.mapToDTO(this.repo.findById(id).orElseThrow(GarageException::new));
	}

	// update
	public GarageDTO update(GarageDTO GarageDTO, Long id) throws GarageException {
		Garage updateFromRepo = this.repo.findById(id).orElseThrow(GarageException::new);
		updateFromRepo.setCapacity(GarageDTO.getCapacity());
		updateFromRepo.setLocation(GarageDTO.getLocation());
		updateFromRepo.setCarsInGarage(GarageDTO.getCarsInGarage());
		return this.mapToDTO(this.repo.saveAndFlush(updateFromRepo));
	}

	// delete
	public boolean delete(Long id) throws GarageException {
		this.repo.findById(id).orElseThrow(GarageException::new);
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
