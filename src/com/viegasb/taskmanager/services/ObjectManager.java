package com.viegasb.taskmanager.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public interface ObjectManager {
	void creatingObject(Scanner scan) throws FileNotFoundException, IOException;

	void creatingObjectUpdate(Scanner scan) throws FileNotFoundException, IOException;
}