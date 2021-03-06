package com.api.contacts.resources.exceptions;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.contacts.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourcesExceptionsHandler {
	
	  @ExceptionHandler(ResourceNotFoundException.class)
	  public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
	    HttpStatus status = HttpStatus.NOT_FOUND;
	    StandardError err = new StandardError();
	    err.setTimestamp(Instant.now());
	    err.setStatus(status.value());
	    err.setError("Resource not found");
	    err.setMessage(e.getMessage());
	    err.setPath(request.getRequestURI());
	    return ResponseEntity.status(status).body(err);
	  }
	  

	  @ExceptionHandler(MethodArgumentNotValidException.class)
	  public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
	    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
	    ValidationError err = new ValidationError();
	    err.setTimestamp(Instant.now());
	    err.setStatus(status.value());
	    err.setError("Resource not found");
	    err.setMessage(e.getMessage());
	    err.setPath(request.getRequestURI());

	    for (FieldError f : e.getBindingResult().getFieldErrors()) {
	      err.addError(f.getField(), f.getDefaultMessage());
	    }

	    return ResponseEntity.status(status).body(err);
	  }
	  
	  @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	  public ResponseEntity<StandardError> violationIntegrity(SQLIntegrityConstraintViolationException e, HttpServletRequest request) {
		    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		    ValidationError err = new ValidationError();
		    err.setTimestamp(Instant.now());
		    err.setStatus(status.value());
		    err.setError("Violation Integrity of Data Base");
		    err.setMessage(e.getMessage());
		    err.setPath(request.getRequestURI());
		    

		    return ResponseEntity.status(status).body(err);
	  }
}
