package com.viegasb.taskmanager.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.viegasb.taskmanager.config.DateConfig;
import com.viegasb.taskmanager.config.MessageConfig;
import com.viegasb.taskmanager.config.exceptions.InvalidDateInputException;
import com.viegasb.taskmanager.models.Account;
import com.viegasb.taskmanager.models.Task;
import com.viegasb.taskmanager.models.UserProfile;
import com.viegasb.taskmanager.models.exceptions.InvalidInputException;
import com.viegasb.taskmanager.services.ObjectFileManager;
import com.viegasb.taskmanager.services.ObjectManager;

public class ConsoleUI {
	public static int menuMain(
			ObjectManager objectManager, ObjectFileManager fileManager, Scanner scan) {
		while (true) {
			try {
				System.out.println("-=-=-=-=-= Menu -=-=-=-=-=-=-=-=-=-=");
				System.out.println("- 1 > Create");
				System.out.println("- 2 > Read");
				System.out.println("- 3 > Update");
				System.out.println("- 4 > Delete");
				System.out.println("- 5 > Exit");
				System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=\n@ ");

				Integer valueInput = Integer.parseInt(scan.nextLine());
				System.out.println();

				ValidateUI.getResponseByMenu(objectManager, fileManager, valueInput, scan);
			}
			catch (FileNotFoundException ex) { MessageConfig.errorMessage(ex); }
			catch (IOException ex) { MessageConfig.errorMessage(ex); }
			catch (ClassNotFoundException ex) { MessageConfig.errorMessage(ex); }
			catch (NumberFormatException ex) { MessageConfig.errorMessage(ex); }
		}
	}

	public static Account createAccount(Scanner scan) {
		while (true) {
			try {
				System.out.println("-=-=-=-=-=-=- Account -=--=-=-=-=-=");

				System.out.print("Email: ");
				String email = scan.nextLine();

				System.out.print("Password: ");
				String password = scan.nextLine();

				if (!ValidateUI.isEmailAndPasswordCheck(email, password))
					continue;

				System.out.println("-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=\n");
				return new Account(email, password);
			}
			catch (InvalidInputException ex) { MessageConfig.errorMessage(ex); }
		}
	}

	public static UserProfile createUserProfile(Scanner scan) {
		while (true) {
			try {
				System.out.println("-=-=-=-=-=- User-Profile -=-=-=-=-=");

				System.out.print("First-Name: ");
				String firstName = scan.nextLine();

				System.out.print("Last-Name: ");
				String lastName = scan.nextLine();

				System.out.print("Birth-Of-Day: ");
				String birthOfDay = scan.nextLine();

				if (!ValidateUI.hasDateCheck(DateConfig.dateFormatter(birthOfDay)))
					continue;

				System.out.println("-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=\n");
				return new UserProfile(firstName, lastName, birthOfDay);
			}
			catch (InvalidDateInputException ex) { MessageConfig.errorMessage(ex); }
			catch (DateTimeParseException ex) { MessageConfig.errorMessage(ex); }
		}
	}

	public static Set<Task> createTaskFromInput(Scanner scan) {
		while(true) {
			try {
				System.out.println("-=-=-=-=-=-=-= Task -=-=-=-=-=-=-=");

				System.out.print("How-Many-Tasks-Create: ");
				Integer numberOfTasks = Integer.parseInt(scan.nextLine());

				Set<Task> newTasks = new HashSet<>();
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=\n");

				for (int i = 0; i < numberOfTasks; i++)
					newTasks.add(createTask(scan));

				if(!ValidateUI.isTaskCollectionSizeEqualTo(newTasks, numberOfTasks))
					continue;

				return newTasks;
			}
			catch (NumberFormatException ex) { MessageConfig.errorMessage(ex); }
			catch (IllegalArgumentException ex) { MessageConfig.errorMessage(ex); }
		}
	}

	private static Task createTask(Scanner scan) {
		System.out.println("-=-=-=-=-= Create Task -=--=-=-=--=");

		System.out.print("Description: ");
		String description = scan.nextLine();

		System.out.print("Category: ");
		String category = scan.nextLine();

		System.out.println("-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=\n");
		return new Task(description, category);
	}
}