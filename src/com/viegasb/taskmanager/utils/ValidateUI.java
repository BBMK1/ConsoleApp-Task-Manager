package com.viegasb.taskmanager.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import com.viegasb.taskmanager.config.exceptions.InvalidDateInputException;
import com.viegasb.taskmanager.models.exceptions.InvalidInputException;
import com.viegasb.taskmanager.services.ObjectFileManager;
import com.viegasb.taskmanager.services.ObjectManager;

public class ValidateUI {
	public static boolean isEmailAndPasswordCheck(String email, String password) {
		if (email.contains("@") && password.length() >= 5)
			return true;

		throw new InvalidInputException(email, password);
	}

	public static boolean hasDateCheck(LocalDate date) {
		if (date.getYear() >= 1980 && date.getYear() <= LocalDate.now().getYear())
			return true;

		throw new InvalidDateInputException(date);
	}

	public static void getResponseByMenu(
			ObjectManager objectManager, ObjectFileManager fileManager, Integer response, Scanner scan)
					throws FileNotFoundException, IOException, ClassNotFoundException {
		switch (response) {
		case 1 -> objectManager.creatingObject(scan);
		case 2 -> System.out.println(fileManager.getObject());
		case 3 -> objectManager.creatingObjectUpdate(scan);
		case 4 -> fileManager.deleteObject();
		case 5 -> System.exit(0);
		default -> throw new IllegalArgumentException("Input Invalid");
		}
	}
}