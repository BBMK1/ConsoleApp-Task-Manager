package com.viegasb.taskmanager.models.exceptions;

public class InvalidInputException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidInputException(String email, String password)
		{ super("Email or Password, Invalid"); }

}