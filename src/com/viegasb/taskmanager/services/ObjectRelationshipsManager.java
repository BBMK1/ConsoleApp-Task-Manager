package com.viegasb.taskmanager.services;

import java.util.Collection;

import com.viegasb.taskmanager.models.Account;
import com.viegasb.taskmanager.models.Task;
import com.viegasb.taskmanager.models.UserProfile;

public interface ObjectRelationshipsManager {
	void accountAndUserProfile(Account account, UserProfile userProfile);

	void userProfileAndTask(UserProfile userProfile, Collection<Task> tasks);
}