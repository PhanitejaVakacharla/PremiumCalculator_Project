package com.precalc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class QueryNotFoundException extends RuntimeException {
	
	public QueryNotFoundException(String message) {
		super(message);

	}

}
