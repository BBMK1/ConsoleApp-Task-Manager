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
import com.viegasb.taskmanager.models.UserProfile;

public class UserProfileRepository extends BaseConnection<UserProfile> {

	public UserProfileRepository(String connectingString)
		{ super(connectingString); }

	@Override
	public void createEntity(UserProfile entity) throws SQLException {
		Integer autoId = Statement.RETURN_GENERATED_KEYS;
		String sqlCommand = "INSERT "
					      + "INTO UserProfile "
					      + "(First_Name, Last_Name, BirthOfDate, Account_Id) "
					      + "VALUES (?, ?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(connectingString)) {
			try (PreparedStatement statement = connection.prepareStatement(sqlCommand, autoId)) {
				statement.setString(1, entity.getFirstName());
				statement.setString(2, entity.getLastName());
				statement.setString(3, entity.getBirthOfDate().toString());
				statement.setString(4, entity.getAccount().getId().toString());

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
					      + "FROM UserProfile "
					      + "WHERE id = ?";

		try (Connection connection = DriverManager.getConnection(connectingString)) {
			try (PreparedStatement statement = connection.prepareStatement(sqlCommand)) {
				statement.setInt(1, id);

				try (ResultSet result = statement.executeQuery()) {
					while (result.next()) {
						System.out.println(result.getString("Id"));
						System.out.println(result.getString("First_Name"));
						System.out.println(result.getString("Last_Name"));
						System.out.println(result.getString("BirthOfDate"));
						System.out.println(result.getString("Account_Id"));
					}
				}
			}
		}
	}

	@Override
	public void updateById(UserProfile newEntity, Integer id) throws SQLException {
		String sqlCommand = "UPDATE UserProfile "
					      + "SET "
					      + "First_Name = ?, Last_Name = ?, BirthOfDate = ? "
					      + "WHERE Id = ?";

		try (Connection connection = DriverManager.getConnection(connectingString)) {
			try (PreparedStatement statement = connection.prepareStatement(sqlCommand)) {
				statement.setString(1, newEntity.getFirstName());
				statement.setString(2, newEntity.getLastName());
				statement.setString(3, newEntity.getBirthOfDate().toString());
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
				  	      + "FROM UserProfile "
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