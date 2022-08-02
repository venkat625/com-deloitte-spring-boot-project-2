package com.deloitte.spring.boot.project.exception;

public class ElectionPartyNotFoundException extends RuntimeException {

	public ElectionPartyNotFoundException() {
		super();
	}
	
	public ElectionPartyNotFoundException(String message) {
		super(message);
	}
}
