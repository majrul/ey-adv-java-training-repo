package com.training.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.training.dto.Status;

import feign.RetryableException;

@ControllerAdvice
public class MyErrorHandler {

	@ExceptionHandler(RetryableException.class)
	public ResponseEntity<Status> handleError(RetryableException e) {
		//loggging and other stuff here
		Status status = new Status(false, "Service down, try after sometime!");
		return new ResponseEntity<Status>(status, HttpStatus.CREATED); 
	}
}
