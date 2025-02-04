package com.dandaevit.edu.jdbc.database_service;

import java.sql.Connection;
import java.sql.SQLException;

import com.dandaevit.edu.jdbc.data_base_connection_manager.DatabaseConnectionManager;

public class TransactionManager {
	private Connection connection;

	public boolean beginTransaction() throws SQLException {
		if (connection != null) {
			connection = DatabaseConnectionManager.get();
			connection.setAutoCommit(false);
			return true;
		}
		return false;
	}

	public boolean commit() throws SQLException {
		connection = DatabaseConnectionManager.get();
		if (connection != null) {
			connection.commit();
			connection.setAutoCommit(true);
			return true;
		}
		return false;
	}

	public boolean rollBack() throws SQLException {
		if (connection != null) {
			connection = DatabaseConnectionManager.get();
			connection.rollback();
			return true;
		}
		return false;
	}
}
