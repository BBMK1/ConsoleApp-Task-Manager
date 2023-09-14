package com.viegasb.taskmanager.database.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.viegasb.taskmanager.config.MessageConfig;
import com.viegasb.taskmanager.database.BaseConnection;
import com.viegasb.taskmanager.database.exceptions.DatabaseException;
import com.viegasb.taskmanager.models.Task;

public class TaskRepository  extends BaseConnection<Task>{

	public TaskRepository(String connectingString)
		{ super(connectingString); }

	@Override
	public void createEntity(Task entity) throws SQLException {
		Integer autoId = Statement.RETURN_GENERATED_KEYS;
		String sqlCommand = "INSERT "
					      + "INTO Task "
					      + "(Description, Category, CreatedAt, UserProfile_Id) "
					      + "VALUES (?, ?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(connectingString)) {
			try (PreparedStatement statement = connection.prepareStatement(sqlCommand, autoId)) {
				statement.setString(1, entity.getDescription());
				statement.setString(2, entity.getCategory());
				statement.setString(3, entity.getCreatedAt().toString());
				statement.setString(4, entity.getUserProfile().getId().toString());

				if (statement.executeUpdate() > 0)
					MessageConfig.messagePrint("Created in Database");
				else
					throw new DatabaseException();
			}
		}
	}

	@Override
	public void getById(Integer id) throws SQLException {
		String sqlCommand = "SELECT * "
					      + "FROM Task "
					      + "WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(connectingString)) {
			try (PreparedStatement statement = connection.prepareStatement(sqlCommand)) {
				statement.setInt(1, id);

				try (ResultSet result = statement.executeQuery()) {
					while (result.next()) {
						System.out.println(result.getString("Id"));
						System.out.println(result.getString("Description"));
						System.out.println(result.getString("Category"));
						System.out.println(result.getString("CreatedAt"));
						System.out.println(result.getString("UserProfile_Id"));
					}
				}
			}
		}
	}

	@Override
	public void updateById(Task newEntity, Integer id) throws SQLException {
		String sqlCommand = "UPDATE Task "
					      + "SET "
					      + "Description = ?, Category = ?, CreatedAt = ? "
					      + "WHERE Id = ?";

		try (Connection connection = DriverManager.getConnection(connectingString)) {
			try (PreparedStatement statement = connection.prepareStatement(sqlCommand)) {
				statement.setString(1, newEntity.getDescription());
				statement.setString(2, newEntity.getCategory());
				statement.setString(3, newEntity.getCreatedAt().toString());
				statement.setString(4, newEntity.getId().toString());

				if (statement.executeUpdate() > 0)
					MessageConfig.messagePrint("Updated in Database");
				else
					throw new DatabaseException();
			}
		}
	}

	@Override
	public void deleteById(Integer id) throws SQLException {
		String sqlCommand = "DELETE "
				  		  + "FROM Task "
				  		  + "WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(connectingString)) {
			try (PreparedStatement statement = connection.prepareStatement(sqlCommand)) {
				statement.setInt(1, id);

				if (statement.executeUpdate() >= 1)
					MessageConfig.messagePrint("Deleted in Database");
				else
					throw new DatabaseException();
			}
		}
	}
}