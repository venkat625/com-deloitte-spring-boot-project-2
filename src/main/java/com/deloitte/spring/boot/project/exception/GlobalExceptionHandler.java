package com.deloitte.spring.boot.project.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.deloitte.spring.boot.project.model.Election;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ElectionNotFoundException.class)
	public ResponseEntity<Election> handleEmployeeNotFoundException(ElectionNotFoundException e) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", e.getMessage());
		ResponseEntity<Election> response = new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
		return response;
	}
}
