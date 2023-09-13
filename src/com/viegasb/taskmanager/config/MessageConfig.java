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

	public static void messagePrint(String message) {
		var formatter = String.format("--- %s ---", message);

		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println(formatter);
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
	}

	public static void messagePrint(String message, String file) {
		var formatter = String.format("--- %s - %s ---", message, file);

		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println(formatter);
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
	}
}