package com.example.demo.controller;

import java.net.http.HttpResponse;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.exceptions.ExceptionResponse;

@ControllerAdvice
//to share methods across multiple controllers
@RestController
public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webReq){
		
	ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), ex.getMessage(), webReq.getDescription(false));
	return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundExceptions(Exception ex, WebRequest webReq){
		
	ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), ex.getMessage(), webReq.getDescription(false));
	return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	
	}

}
