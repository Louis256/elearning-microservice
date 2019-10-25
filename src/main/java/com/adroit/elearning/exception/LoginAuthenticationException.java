package com.adroit.elearning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class LoginAuthenticationException extends Exception {

	private static final long serialVersionUID = 1L;

	public LoginAuthenticationException(String message) {
		super(message);
	}

	public LoginAuthenticationException(String message, Throwable t) {
		super(message, t);
	}
}
