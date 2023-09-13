package com.viegasb.taskmanager.services.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.viegasb.taskmanager.config.MessageConfig;
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

	public ObjectManagerImpl(ObjectRelationshipsManager relationshipsManager,
							 ObjectFileManager fileManager) {
		this.relationshipsManager = relationshipsManager;
		this.fileManager = fileManager;
	}

	@Override
	public void creatingObject(Scanner scan) throws FileNotFoundException, IOException {
		Account account = ConsoleUI.createAccount(scan);
		UserProfile userProfile = ConsoleUI.createUserProfile(scan);
		Task[] tasks = ConsoleUI.createTaskFromInput(scan);

		creatingRelationships(account, userProfile, tasks);
		fileManager.createObject(account);

		MessageConfig.messagePrint("Created File");
	}

	@Override
	public void creatingObjectUpdate(Scanner scan) throws FileNotFoundException, IOException {
		Account account = ConsoleUI.createAccount(scan);
		UserProfile userProfile = ConsoleUI.createUserProfile(scan);
		Task[] tasks = ConsoleUI.createTaskFromInput(scan);

		creatingRelationships(account, userProfile, tasks);
		fileManager.updateObject(account);

		MessageConfig.messagePrint("Update File");
	}

	private void creatingRelationships(Account account, UserProfile userProfile, Task[] tasks) {
		relationshipsManager.accountAndUserProfile(account, userProfile);
		relationshipsManager.userProfileAndTask(userProfile, tasks);
	}
}