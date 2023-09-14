package com.viegasb.taskmanager.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public interface ObjectManager {
	void creatingObject(Scanner scan) throws FileNotFoundException, IOException, SQLException;

	void creatingObjectUpdate(Scanner scan) throws FileNotFoundException, IOException;
}