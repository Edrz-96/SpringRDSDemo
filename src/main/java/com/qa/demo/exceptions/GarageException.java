package com.qa.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Garage not found")
public class GarageException extends Exception {

	private static final long serialVersionUID = 3322179265522207925L;

}
