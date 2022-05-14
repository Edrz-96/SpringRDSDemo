package com.qa.demo.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Scope("prototype")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	int wheel;

	@NotNull
	int door;

	@Column(name = "engine", length = 30)
	String engineSize;
	{ wheel = 4; }; 
	
	
	@ManyToOne
	@NotNull
	private Garage garage;

}