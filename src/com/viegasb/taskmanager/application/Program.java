package com.viegasb.taskmanager.application;

import java.util.Scanner;

import com.viegasb.taskmanager.database.impl.AccountRepository;
import com.viegasb.taskmanager.database.impl.TaskRepository;
import com.viegasb.taskmanager.database.impl.UserProfileRepository;
import com.viegasb.taskmanager.services.ObjectFileManager;
import com.viegasb.taskmanager.services.ObjectRelationshipsManager;
import com.viegasb.taskmanager.services.impl.ObjectFileManagerImpl;
import com.viegasb.taskmanager.services.impl.ObjectManagerImpl;
import com.viegasb.taskmanager.services.impl.ObjectRelationshipsManagerImpl;
import com.viegasb.taskmanager.utils.ConsoleUI;

public class Program {
	public static void main(String[] args) {
		ConsoleUI.menuMain(getImplements(), new ObjectFileManagerImpl(), new Scanner(System.in));
	}

	private static ObjectManagerImpl getImplements() {
		ObjectRelationshipsManager relationshipsManager = new ObjectRelationshipsManagerImpl();
		ObjectFileManager fileManager = new ObjectFileManagerImpl();

		AccountRepository accountRepository = new AccountRepository(getConnectionString());
		UserProfileRepository userProfileRepository = new UserProfileRepository(getConnectionString());
		TaskRepository taskRepository = new TaskRepository(getConnectionString());

		return new ObjectManagerImpl(
				relationshipsManager,
				fileManager,
				accountRepository,
				userProfileRepository,
				taskRepository
				);
	}

	private static String getConnectionString() {
		return "jdbc:sqlite:C:/Workspace/task-manager/database.db";
	}
}