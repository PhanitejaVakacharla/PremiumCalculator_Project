package com.virtusa.precalc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PasswordMismatchException extends RuntimeException{
	
	public PasswordMismatchException(String message) {
		super(message);

	}

}
