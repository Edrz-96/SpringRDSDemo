package com.qa.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Scope;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Scope("prototype")
public class Garage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@NotNull
	String location;

	@OneToMany(mappedBy = "garage", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	List<Car> carsInGarage = new ArrayList<>(500); 
	
	@Column(length = 3)
//	@Size(min = 1, max = 3, message = "Garage capacity should be between 1-500")
	@Max(value = 500, message = "Maximum Garage capcaity is 500")
	@Min(value = 1)
	int capacity;

}
