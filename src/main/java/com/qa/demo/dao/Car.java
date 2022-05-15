package com.qa.demo.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@JsonIgnoreProperties("garage")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	int wheel;

	@NotNull
	int door;

	@Column(name = "engine", length = 30)
	String engineSize;

	@ManyToOne(targetEntity = Garage.class)
	@JsonBackReference
	private Garage garage;

	{
		wheel = 4;
	};
}