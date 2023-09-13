package com.viegasb.taskmanager.services;

import com.viegasb.taskmanager.models.Account;
import com.viegasb.taskmanager.models.Task;
import com.viegasb.taskmanager.models.UserProfile;

public interface ObjectRelationshipsManager {
	void accountAndUserProfile(Account account, UserProfile userProfile);

	void userProfileAndTask(UserProfile userProfile, Task[] tasks);
}