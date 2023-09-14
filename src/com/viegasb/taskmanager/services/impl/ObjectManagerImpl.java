package com.viegasb.taskmanager.services.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Scanner;
import java.util.Set;

import com.viegasb.taskmanager.database.DatabaseManager;
import com.viegasb.taskmanager.models.Account;
import com.viegasb.taskmanager.models.Task;
import com.viegasb.taskmanager.models.UserProfile;
import com.viegasb.taskmanager.services.ObjectFileManager;
import com.viegasb.taskmanager.services.ObjectManager;
import com.viegasb.taskmanager.services.ObjectRelationshipsManager;
import com.viegasb.taskmanager.utils.ConsoleUI;

public class ObjectManagerImpl implements ObjectManager {

	private ObjectRelationshipsManager relationshipsManager;
	private ObjectFileManager fileManager;

	private DatabaseManager<Account> accountRepository;
	private DatabaseManager<UserProfile> userProfileRepository;
	private DatabaseManager<Task> taskRepository;

	public ObjectManagerImpl(ObjectRelationshipsManager relationshipsManager,
			ObjectFileManager fileManager,
			DatabaseManager<Account> accountRepository,
			DatabaseManager<UserProfile> userProfileRepository,
			DatabaseManager<Task> taskRepository) {
		this.relationshipsManager = relationshipsManager;
		this.fileManager = fileManager;
		this.accountRepository = accountRepository;
		this.userProfileRepository = userProfileRepository;
		this.taskRepository = taskRepository;
	}

	@Override
	public void creatingObject(Scanner scan)
			throws FileNotFoundException, IOException, SQLException {
		Account account = ConsoleUI.createAccount(scan);
		UserProfile userProfile = ConsoleUI.createUserProfile(scan);
		Set<Task> tasks = ConsoleUI.createTaskFromInput(scan);

		creatingRelationships(account, userProfile, tasks);
		fileManager.createObject(account);

		accountRepository.createEntity(account);
		userProfileRepository.createEntity(userProfile);
		savingsTasksInDatabase(tasks);

	}

	@Override
	public void creatingObjectUpdate(Scanner scan) throws FileNotFoundException, IOException {
		Account account = ConsoleUI.createAccount(scan);
		UserProfile userProfile = ConsoleUI.createUserProfile(scan);
		Set<Task> tasks = ConsoleUI.createTaskFromInput(scan);

		creatingRelationships(account, userProfile, tasks);
		fileManager.updateObject(account);
	}

	private void creatingRelationships(Account account, UserProfile userProfile, Collection<Task> tasks) {
		relationshipsManager.accountAndUserProfile(account, userProfile);
		relationshipsManager.userProfileAndTask(userProfile, tasks);
	}

	private void savingsTasksInDatabase(Collection<Task> tasks) {
			tasks.stream()
				.forEach(item -> {
						try {
							taskRepository.createEntity(item);
						}
						catch (SQLException e) { e.printStackTrace(); }
				});
	}
}