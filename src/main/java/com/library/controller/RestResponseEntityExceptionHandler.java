package com.library.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.library.dao.ApiError;
import com.library.exception.LimitViolationException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(LimitViolationException.class)
	public ResponseEntity<ApiError> handleCityNotFoundException(LimitViolationException ex, WebRequest request) {

		ApiError apiError = new ApiError();
		apiError.setMessage(ex.getMessage());
		apiError.setReason("Limit voilated");
		return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);
	}

}