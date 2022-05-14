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

import com.qa.demo.dao.Car;
import com.qa.demo.dto.CarDTO;
import com.qa.demo.exceptions.CarException;
import com.qa.demo.service.CarMappedService;

@RestController
@RequestMapping("/car")
// /CarDTO/create 
public class CarController {
	// create - @PostMapping - 201 created
	// read - @GetMapping - 200 ok
	// update - @PutMapping - 202 accepted
	// delete - @DeleteMapping - 204 no-content
	// RequestBody - Sending info from the user
	// ResponseBody - Opposite ^ (receiving)
	// parameter input - @PathVariable/param - template for input data

	private CarMappedService service;

	@Autowired
	public CarController(CarMappedService service) {
		this.service = service;
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello world";
	}

	@PostMapping("/create")
	public ResponseEntity<CarDTO> create(@RequestBody Car Car) {
		return new ResponseEntity<CarDTO>(this.service.create(Car), HttpStatus.CREATED);
	}

	@GetMapping("/read")
	public ResponseEntity<List<CarDTO>> read() {
//		return new ResponseEntity<List<CarDTO>>(this.service.readAll(), HttpStatus.OK);
		return ResponseEntity.ok(this.service.read());

	}

//	@GetMapping("/engine/{str}")
//	public ResponseEntity<List<CarDTO>> findByEngine(@PathVariable String str) {
//		return new ResponseEntity<List<CarDTO>>(this.service.findByEngine(str), HttpStatus.OK);
//	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CarDTO> update(@PathVariable Long id, @RequestBody CarDTO CarDTO) throws Exception {
		return new ResponseEntity<CarDTO>(this.service.update(CarDTO, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) throws CarException {
		return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
