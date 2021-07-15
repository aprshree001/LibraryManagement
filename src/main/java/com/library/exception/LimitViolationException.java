package com.library.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class LimitViolationException extends RuntimeException {
	
	
	public LimitViolationException(String errorMessage) {
		
		super(errorMessage);
		
	}

}
