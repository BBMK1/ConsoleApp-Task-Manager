package com.viegasb.taskmanager.application;

import java.util.Scanner;

import com.viegasb.taskmanager.models.Account;
import com.viegasb.taskmanager.models.Task;
import com.viegasb.taskmanager.models.UserProfile;
import com.viegasb.taskmanager.utils.ConsoleUI;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Account account = ConsoleUI.createAccount(scanner);
		UserProfile userProfile = ConsoleUI.createUserProfile(scanner);
		Task task = ConsoleUI.createTask(scanner);

		System.out.println(account);
		System.out.println(userProfile);
		System.out.println(task);
	}
}