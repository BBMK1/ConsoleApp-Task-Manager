package com.viegasb.taskmanager.database;

import java.sql.Connection;

public abstract class BaseConnection<T> implements DatabaseManager<T> {
	protected String connectingString;
	protected Connection connection;

	protected BaseConnection(String connectingString) {
		this.connectingString = connectingString;
	}
}