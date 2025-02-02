package com.dandaevit.edu.jdbc.data_base_connection_manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseConnectionManager {
	private final static String URL = "jdbc:postgresql://localhost/flights_repository";
	private final static String USER = "postgres";
	private final static String password = "root";

	private static Connection connection;

	private final static Logger LOGGER = LoggerFactory.getLogger(DatabaseConnectionManager.class.getName());

	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(URL, USER, password);
			LOGGER.info("Connecting to database established successfully");
		}
		return connection;
	}
}
