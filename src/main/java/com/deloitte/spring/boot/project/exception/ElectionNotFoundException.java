package com.deloitte.spring.boot.project.exception;

public class ElectionNotFoundException extends RuntimeException {
	
	public ElectionNotFoundException() {
		super();
	}
	
	public ElectionNotFoundException(String message) {
		super(message);
	}
}
