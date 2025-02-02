package com.dandaevit.edu.jdbc.database_service;

import java.sql.Connection;
import java.sql.SQLException;

import com.dandaevit.edu.jdbc.data_base_connection_manager.DatabaseConnectionManager;

public class TransactioManager {
	private Connection connection;

	public boolean beginTransaction() throws SQLException {
		if (connection != null) {
			connection = DatabaseConnectionManager.getConnection();
			connection.setAutoCommit(false);
			return true;
		}
		return false;
	}

	public boolean commit() throws SQLException {
		connection = DatabaseConnectionManager.getConnection();
		if (connection != null) {
			connection.commit();
			connection.setAutoCommit(true);
			return true;
		}
		return false;
	}

	public boolean rollBack() throws SQLException {
		if (connection != null) {
			connection = DatabaseConnectionManager.getConnection();
			connection.rollback();
			return true;
		}
		return false;
	}
}
