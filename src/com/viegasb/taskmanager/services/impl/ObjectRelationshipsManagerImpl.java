package com.viegasb.taskmanager.services.impl;

import java.util.Collection;

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
	public void userProfileAndTask(UserProfile userProfile, Collection<Task> tasks) {
		tasks.stream()
			.forEach(items -> {
				userProfile.getTasks().add(items);
				items.setUserProfile(userProfile);
			});
	}
}