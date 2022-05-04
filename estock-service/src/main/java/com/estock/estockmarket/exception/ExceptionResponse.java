package com.estock.estockmarket.exception;

public class ExceptionResponse {
    private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ExceptionResponse(String message) {
		super();
		this.message = message;
	}

	    
}
