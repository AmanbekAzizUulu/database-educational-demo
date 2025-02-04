package com.dandaevit.edu.jdbc.data_base_connection_manager;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DatabaseConnectionManager {
	private final static String URL_KEY = "database.url";
	private final static String USER_KEY = "database.user";
	private final static String PASSWORD_KEY = "database.password";

	private static Connection connection;

	private final static String POOL_SIZE_KEY = "database.connection_pool.size";
	private final static int DEFAULT_POOL_SIZE = 10;

	private static BlockingQueue<Connection> connectionPool;

	private final static Logger LOGGER = LoggerFactory.getLogger(DatabaseConnectionManager.class.getName());

	static {
		loadDriver();
		initConnectionPool();
	}

	private DatabaseConnectionManager() {
	}

	private static void loadDriver() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private static void initConnectionPool() {
		var size = DatabasePropertiesUtil.getProperty(POOL_SIZE_KEY);
		int poolSize = size == null
				? DEFAULT_POOL_SIZE
				: Integer.parseInt(size);

		connectionPool = new ArrayBlockingQueue<Connection>(poolSize);

		for (int i = 0; i < poolSize; i++) {
			Connection connection = open();

			var proxyConnection = (Connection) Proxy.newProxyInstance(
					DatabaseConnectionManager.class.getClassLoader(),
					new Class<?>[] { Connection.class },
					(proxy, method, args) -> method.getName().equals("close")
							? connectionPool.add((Connection) proxy)
							: method.invoke(connection, args));

			connectionPool.add(proxyConnection);
		}
	}

	private static Connection open() {
		try {
			if (connection == null || connection.isClosed()) {
				LOGGER.info("Connecting to database established successfully");

				return DriverManager.getConnection(
						DatabasePropertiesUtil.getProperty(URL_KEY),
						DatabasePropertiesUtil.getProperty(USER_KEY),
						DatabasePropertiesUtil.getProperty(PASSWORD_KEY));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static Connection get() {
		try {
			return connectionPool.take();
		} catch (InterruptedException e) {
			// TODO добавить корректную обработку исключения
			throw new RuntimeException();
		}
	}

}
