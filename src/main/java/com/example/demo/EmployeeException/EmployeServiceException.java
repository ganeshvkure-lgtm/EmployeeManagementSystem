package com.example.demo.EmployeeException;

import org.springframework.http.HttpStatus;

public class EmployeServiceException extends RuntimeException{
	
	private String errorMessage;
	private  HttpStatus httpStatus;

	
	public EmployeServiceException(String errorMessage, HttpStatus httpStatus) {
		super(errorMessage);
		this.httpStatus= httpStatus;
	}
	
	
	public EmployeServiceException(HttpStatus httpStatus) {
	
		this.httpStatus= httpStatus;
	}
	
	@Override
	public String getMessage() {
		
		return super.getMessage();

	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
}

//hi


