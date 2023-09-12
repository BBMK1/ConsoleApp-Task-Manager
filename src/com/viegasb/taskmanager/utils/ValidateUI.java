package com.viegasb.taskmanager.utils;

import java.time.LocalDate;

import com.viegasb.taskmanager.config.exceptions.InvalidDateInputException;
import com.viegasb.taskmanager.models.exceptions.InvalidInputException;

public class ValidateUI {
	public static boolean isEmailAndPasswordCheck(String email, String password) {
		if (email.contains("@") &&
				password.length() >= 5)
			return true;

		throw new InvalidInputException(email, password);
	}

	public static boolean hasDateCheck(LocalDate date) {
		if(date.getYear() >= 1980 &&
				date.getYear() <= LocalDate.now().getYear())
			return true;

		throw new InvalidDateInputException(date);
	}

}