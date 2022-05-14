package com.qa.demo.dto;

import com.qa.demo.dao.Garage;

import lombok.Data;

@Data
public class CarDTO {

	Long id;

	int door;

	String engineSize;

	Garage garage;
}
