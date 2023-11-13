package com.precalc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(PolicyNotFoundException.class)
	public ResponseEntity<String> handlePolicyNotFoundException(PolicyNotFoundException policyNotFoundException){
		return new ResponseEntity<>(policyNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(QueryNotFoundException.class)
	public ResponseEntity<String> handleQueryNotFoundException(QueryNotFoundException queryNotFoundException){
		return new ResponseEntity<>(queryNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PasswordMismatchException.class)
	public ResponseEntity<String> handlePasswordMismatchException(PasswordMismatchException passwordMismatchException){
		return new ResponseEntity<>(passwordMismatchException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<String> handleEmailAlreadyExistsException(EmailAlreadyExistsException emailAlreadyExistsException){
		return new ResponseEntity<>(emailAlreadyExistsException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<String> handleBadCredentialsException(BadCredentialsException badCredentialsException){
		return new ResponseEntity<>(badCredentialsException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCredentialsForAdminException.class)
	public ResponseEntity<String> handleInvalidCredentialsForAdminException(InvalidCredentialsForAdminException invalidCredentialsForAdminException){
		return new ResponseEntity<>(invalidCredentialsForAdminException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}
