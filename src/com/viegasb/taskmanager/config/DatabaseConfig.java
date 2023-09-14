package com.viegasb.taskmanager.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
	public static void openConnection(Connection connection, String connectionString) {
		try {
			connection = DriverManager.getConnection(connectionString);
		}
		catch (SQLException e) { e.printStackTrace(); }
	}

	public static void closeConnection(Connection connection) {
		try {
			if(connection != null && !connection.isClosed())
				connection.close();
		}
		catch (SQLException e) { e.printStackTrace(); }
	}
}