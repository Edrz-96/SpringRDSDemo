package com.qa.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Garage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@NotNull
	String location;

	@Column(length = 3)
	@Max(value = 500, message = "Maximum Garage capcaity is 500")
	@Min(value = 1)
	int capacity;

	@OneToMany(mappedBy = "garage")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonManagedReference
	List<Car> carsInGarage = new ArrayList<>(capacity);
}
