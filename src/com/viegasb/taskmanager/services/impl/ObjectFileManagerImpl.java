package com.viegasb.taskmanager.services.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.viegasb.taskmanager.config.MessageConfig;
import com.viegasb.taskmanager.models.Account;
import com.viegasb.taskmanager.services.ObjectFileManager;

public class ObjectFileManagerImpl implements ObjectFileManager {
	private String path;
	private String fileType;
	private String fullPath;

	private File file;

	public ObjectFileManagerImpl() {
		this.path = "C:\\Users\\Virtual Machine\\Documents";
		this.fileType = "task-manager.txt";
		this.fullPath = String.format("%s%s%s", path, File.separator, fileType);
		this.file = new File(fullPath);
	}

	@Override
	public void createObject(Account object) throws FileNotFoundException, IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath))) {
			writer.write(object.toString());
		}
	}

	@Override
	public Object getObject() throws ClassNotFoundException, IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(fullPath))) {
			StringBuilder builder = new StringBuilder();
			String line = null;

			while ((line = reader.readLine()) != null)
				builder.append(String.format("%s\n", line));

			return builder.toString();
		}
	}

	@Override
	public void updateObject(Account newObject) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath))) {
			writer.write("Update:\n\n");
			writer.write(newObject.toString());
		}
	}

	@Override
	public void deleteObject() throws FileNotFoundException {
		if (!file.exists())
			throw new FileNotFoundException("File Non-Exist");

		file.delete();
		MessageConfig.messagePrint("Deleted File");
	}

}