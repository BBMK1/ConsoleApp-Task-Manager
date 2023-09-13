package com.viegasb.taskmanager.services.impl;

import com.viegasb.taskmanager.models.Account;
import com.viegasb.taskmanager.models.Task;
import com.viegasb.taskmanager.models.UserProfile;
import com.viegasb.taskmanager.services.ObjectRelationshipsManager;

public class ObjectRelationshipsManagerImpl implements ObjectRelationshipsManager {

	@Override
	public void accountAndUserProfile(Account account, UserProfile userProfile) {
		account.setUserProfile(userProfile);
		userProfile.setAccount(account);
	}

	@Override
	public void userProfileAndTask(UserProfile userProfile, Task[] tasks) {
		for(int i = 0; i < tasks.length; i++)
			userProfile.setTasks(tasks);

		for(Task item : tasks)
			item.setUserProfile(userProfile);
	}
}