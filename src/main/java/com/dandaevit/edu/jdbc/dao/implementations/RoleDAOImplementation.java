package com.dandaevit.edu.jdbc.dao.implementations;

import java.sql.Connection;
import java.sql.SQLException;

import com.dandaevit.edu.jdbc.data_base_connection_manager.DatabaseConnectionManager;
import com.dandaevit.edu.jdbc.model.user.Role;
import com.dandaevit.edu.jdbc.sql_exceptions.roles_exceptions.NoSuchRoleException;

public class RoleDAOImplementation {
	private final Connection connection;
	private static RoleDAOImplementation INSTANCE;

	private static final String SELECT_ALL_BY_ROLE_NAME =
			"""
			SELECT
				id,
				role_name,
				role_code
			FROM
				flights_management.roles
			WHERE
				role_name = ?
			""";

	private RoleDAOImplementation(Connection connection) {
		this.connection = DatabaseConnectionManager.get();
	}

	public Role getRoleByName(String roleName) throws SQLException {
		try (var preparedStatement = connection.prepareStatement(SELECT_ALL_BY_ROLE_NAME)) {
			preparedStatement.setString(1, roleName);

			try (var resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					return Role.builder()
							   .id(resultSet.getInt("id"))
							   .roleName(resultSet.getString("role_name"))
							   .roleCode(resultSet.getString("role_code"))
							   .build();
				}
			}
		}
		throw new NoSuchRoleException("Роль не найдена: " + roleName);
	}

	// Статический метод для получения единственного экземпляра
	public static RoleDAOImplementation getInstance(Connection connection) {
		if (INSTANCE == null) {
			synchronized (FlightDAOImplementation.class) {
				// Дублированная проверка на null для потокобезопасности
				if (INSTANCE == null) {
					INSTANCE = new RoleDAOImplementation(connection);
				}
			}
		}
		return INSTANCE;
	}
}
