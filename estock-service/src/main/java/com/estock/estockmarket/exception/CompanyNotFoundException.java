package com.estock.estockmarket.exception;

public class CompanyNotFoundException extends Exception{

	private static final long serialVersionUID = 7057307888970707494L;

	public CompanyNotFoundException(String message)
	{
		super(message);
	}
}
