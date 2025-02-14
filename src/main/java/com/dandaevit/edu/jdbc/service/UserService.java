package com.dandaevit.edu.jdbc.service;

import java.sql.Connection;
import java.util.Optional;

import com.dandaevit.edu.jdbc.dao.implementations.UserDAOImplementation;
import com.dandaevit.edu.jdbc.data_base_connection_manager.DatabaseConnectionManager;
import com.dandaevit.edu.jdbc.dto.CreateUserDTO;
import com.dandaevit.edu.jdbc.dto.UserDTO;
import com.dandaevit.edu.jdbc.mappers.implementations.CreateUserMapper;
import com.dandaevit.edu.jdbc.mappers.implementations.UserMapper;
import com.dandaevit.edu.jdbc.model.user.User;
import com.dandaevit.edu.jdbc.sql_exceptions.user_exceptions.UserInsertionException;
import com.dandaevit.edu.jdbc.sql_exceptions.validation_exc.ValidationException;
import com.dandaevit.edu.jdbc.validator.CreateUserValidator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserService {
	private static UserService INSTANCE = new UserService();
	private final static CreateUserMapper mapper = CreateUserMapper.getInstance();

	private static Connection connection = DatabaseConnectionManager.get();
	private static final UserDAOImplementation userDAOImplementation = UserDAOImplementation.getInstance(connection);
	private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
	private final UserMapper userMapper = UserMapper.getInstance();

	public User createUser(CreateUserDTO createUserDTO) {
		var validationResult = createUserValidator.isValid(createUserDTO);

		if (!validationResult.isValid()) {
			throw new ValidationException(validationResult.getErrors());
		}
		var user = mapper.mapFrom(createUserDTO);
		try {
			userDAOImplementation.insertUser(user);
		} catch (UserInsertionException e) {
			e.printStackTrace();
		}
		return user;
	}

	public Optional<UserDTO> login(String email, String password) {
		return userDAOImplementation.selectByEmailAndPassword(email, password).map(userMapper::mapFrom);
	}

	public static UserService getInstance() {
		if (INSTANCE == null) {
			synchronized (UserService.class) {
				if (INSTANCE == null) {
					INSTANCE = new UserService();
				}
			}
		}
		return INSTANCE;
	}
}
