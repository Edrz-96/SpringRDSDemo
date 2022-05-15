package com.qa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.dao.Garage;
import com.qa.demo.dto.GarageDTO;
import com.qa.demo.exceptions.GarageException;
import com.qa.demo.service.GarageService;

@RestController
@RequestMapping("/garage")
public class GarageController {

	private GarageService service;

	@Autowired
	public GarageController(GarageService service) {
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<GarageDTO> create(@RequestBody Garage Garage) {
		return new ResponseEntity<GarageDTO>(this.service.create(Garage), HttpStatus.CREATED);
	}

	@GetMapping("/read")
	public ResponseEntity<List<GarageDTO>> read() {
		return ResponseEntity.ok(this.service.read());

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<GarageDTO> update(@PathVariable Long id, @RequestBody GarageDTO GarageDTO) throws Exception {
		return new ResponseEntity<GarageDTO>(this.service.update(GarageDTO, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) throws GarageException {
		return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
