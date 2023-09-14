package com.viegasb.taskmanager.database;

import java.sql.SQLException;

public interface DatabaseManager<T> {
	void createEntity(T entity) throws SQLException;

	void getById(Integer id) throws SQLException;

	void updateById(T newEntity, Integer id) throws SQLException;

	void deleteById(Integer id) throws SQLException;
}