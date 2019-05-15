/**
 * 
 */
package com.amrit.springboot.demo.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author amrit
 *
 */
@ControllerAdvice
@RestController
public class ApplicationResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * 
	 */
	public ApplicationResponseEntityExceptionHandler() {
		// TODO Auto-generated constructor stub
	}
	
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage() , request.getDescription(false));
		
		ResponseEntity<ExceptionResponse> responseEntity = new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		return responseEntity;
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ExceptionResponse> handleApplicationUserNotFoundException(ApplicationUserNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage() , request.getDescription(false));
		
		ResponseEntity<ExceptionResponse> responseEntity = new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
		return responseEntity;
	}

}
