package com.dandaevit.edu.jdbc.dao.implementations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import com.dandaevit.edu.jdbc.dao.interfaces.UserDAO;
import com.dandaevit.edu.jdbc.dao.utils.implementations.ValidateBeforeInsertUtil;
import com.dandaevit.edu.jdbc.data_base_connection_manager.DatabaseConnectionManager;
import com.dandaevit.edu.jdbc.model.user.Gender;
import com.dandaevit.edu.jdbc.model.user.User;
import com.dandaevit.edu.jdbc.sql_exceptions.user_exceptions.AllUsersSelectionException;
import com.dandaevit.edu.jdbc.sql_exceptions.user_exceptions.NoSuchUserException;
import com.dandaevit.edu.jdbc.sql_exceptions.user_exceptions.UserDeletingException;
import com.dandaevit.edu.jdbc.sql_exceptions.user_exceptions.UserInsertionException;
import com.dandaevit.edu.jdbc.sql_exceptions.user_exceptions.UserUpdatingException;

public final class UserDAOImplementation implements UserDAO {
	private final Connection connection;
	private static UserDAOImplementation INSTANCE;
	private static RoleDAOImplementation roleDAOImplementation = RoleDAOImplementation.getInstance(DatabaseConnectionManager.get());

	private static final String INSERT_INTO_USER_SQL = """
					INSERT INTO flights_management.users
							(
							    first_name,
							    last_name,
							    login,
							    email,
							    password,
							    role_id,
							    gender,
							    birth_date
							)
					VALUES
							(
								?,
								?,
								?,
								?,
								?,
								?,
								?::flights_management.gender_type,
								?
							)
					RETURNING
								id;
			""";

	private static final String SELECT_USER_BY_EMAIL_AND_PASSWORD = """
					SELECT
						*
					FROM
						flights_management.users
					WHERE
						email = ? AND password = ?;
			""";


	private UserDAOImplementation(Connection connection) {
		this.connection = DatabaseConnectionManager.get();
	}

	@Override
	public User insertUser(User user) throws UserInsertionException {
		var validateBeforeInsertUtil = new ValidateBeforeInsertUtil();

		if (!validateBeforeInsertUtil.validate(user)) {
			throw new RuntimeException("User is not validated.");
		}

		try (var preparedStatement = connection.prepareStatement(INSERT_INTO_USER_SQL,
				Statement.RETURN_GENERATED_KEYS);) {
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getLogin());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setInt(6, user.getRole().getId());
			preparedStatement.setString(7, user.getGender().name().toLowerCase());
			preparedStatement.setDate(8, Date.valueOf(user.getBirthDate()));

			preparedStatement.executeUpdate();

			var generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				user.setId(generatedKeys.getInt(1));
			} else {
				throw new SQLException("Creating user failed, no ID obtained.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void deleteUser(int id) throws UserDeletingException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
	}

	@Override
	public User updateUser(User user) throws UserUpdatingException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
	}

	@Override
	public User getUsersByID(int id) throws NoSuchUserException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getUsersByID'");
	}

	@Override
	public List<User> getAllUsers() throws AllUsersSelectionException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
	}

	public Optional<User> selectByEmailAndPassword(String email, String password){
		try(var preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL_AND_PASSWORD);){
			preparedStatement.setString(1,email );
			preparedStatement.setString(2, password);

			var resultSet = preparedStatement.executeQuery();

			User user = null;
			if (resultSet.next()) {
				user = User
							.builder()
							.id(resultSet.getInt("id"))
							.firstName(resultSet.getString("first_name"))
							.lastName(resultSet.getString("last_name"))
							.login(resultSet.getString("login"))
							.email(resultSet.getString("email"))
							.password(resultSet.getString("password"))
							.role(roleDAOImplementation.getRoleById(resultSet.getInt("role_id")))
							.gender(Gender.valueOf(resultSet.getString("gender").toUpperCase()))
							.birthDate(resultSet.getDate("birth_date").toLocalDate())
							.build();
			}
			return Optional.ofNullable(user);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static UserDAOImplementation getInstance(Connection connection) {
		if (INSTANCE == null) {
			synchronized (FlightDAOImplementation.class) {
				// Дублированная проверка на null для потокобезопасности
				if (INSTANCE == null) {
					INSTANCE = new UserDAOImplementation(connection);
				}
			}
		}
		return INSTANCE;
	}
}
