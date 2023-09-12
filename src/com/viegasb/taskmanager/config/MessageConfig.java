package com.viegasb.taskmanager.config;

import java.time.format.DateTimeParseException;

public class MessageConfig {
	public static void errorMessage(Exception ex) {
		var formatter = String.format("--- %s ---", ex.getMessage());

		System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println(formatter);
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
	}

	public static void errorMessage(DateTimeParseException ex) {
		var formatter = String.format("--- %s ---", ExceptionConfig.getErrorMessageOnParse(ex));

		System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println(formatter);
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
	}
}