package com.viegasb.taskmanager.services;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.viegasb.taskmanager.models.Account;

public interface ObjectFileManager {
	void createObject(Account object) throws FileNotFoundException, IOException;

	Object getObject() throws ClassNotFoundException, IOException;

	void updateObject(Account newObject) throws IOException;

	void deleteObject() throws FileNotFoundException;
}