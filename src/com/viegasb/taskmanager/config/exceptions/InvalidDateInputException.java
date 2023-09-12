package com.viegasb.taskmanager.config.exceptions;

import java.time.LocalDate;

public class InvalidDateInputException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidDateInputException(LocalDate date) { super("Date Invalid"); }

}