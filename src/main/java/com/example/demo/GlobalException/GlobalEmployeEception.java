package com.example.demo.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.EmployeeException.EmployeServiceException;

@ControllerAdvice
@Component
public class GlobalEmployeEception {

	@ExceptionHandler(exception = EmployeServiceException.class)
	ResponseEntity HandleEmployeException(EmployeServiceException e) {

		return new ResponseEntity(e.getMessage(), e.getHttpStatus());

	}

	@ExceptionHandler(exception = Exception.class)
	ResponseEntity HandleEmployeException(Exception e) {

		return new ResponseEntity("Something Went Wrong", HttpStatus.BAD_REQUEST);

	}

}
