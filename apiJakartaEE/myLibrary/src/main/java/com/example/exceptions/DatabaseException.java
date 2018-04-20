package com.example.exceptions;

import com.example.model.ErrorResponse;

public class DatabaseException extends Exception {

	public DatabaseException(String message, Throwable cause) {
		super(message,cause);
	}
	
	public ErrorResponse getErrorResponse() {
		return new ErrorResponse(this.getMessage(), this.getCause().getMessage(), 400);		// TODO: 400 is redundant with  BAD_REQUEST
	}
}
