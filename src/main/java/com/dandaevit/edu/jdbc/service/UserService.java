package com.dandaevit.edu.jdbc.service;

import java.sql.Connection;

import com.dandaevit.edu.jdbc.dao.implementations.UserDAOImplementation;
import com.dandaevit.edu.jdbc.data_base_connection_manager.DatabaseConnectionManager;
import com.dandaevit.edu.jdbc.dto.CreateUserDTO;
import com.dandaevit.edu.jdbc.mappers.implementations.CreateUserMapper;
import com.dandaevit.edu.jdbc.model.user.User;
import com.dandaevit.edu.jdbc.sql_exceptions.user_exceptions.UserInsertionException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserService {
	private static UserService INSTANCE = new UserService();
	private final static CreateUserMapper mapper = CreateUserMapper.getInstance();

	private static Connection connection = DatabaseConnectionManager.get();
	private static final UserDAOImplementation userDAOImplementation = UserDAOImplementation.getInstance(connection);

	public User createUser(CreateUserDTO createUserDTO) {
		var user = mapper.mapFrom(createUserDTO);
		try {
			userDAOImplementation.insertUser(user);
		} catch (UserInsertionException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static UserService getInstance() {
		if (INSTANCE == null) {
			synchronized (UserService.class) {
				// Дублированная проверка на null для потокобезопасности
				if (INSTANCE == null) {
					INSTANCE = new UserService();
				}
			}
		}
		return INSTANCE;
	}
}
