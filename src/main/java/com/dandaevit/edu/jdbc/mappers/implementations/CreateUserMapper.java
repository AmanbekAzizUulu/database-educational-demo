package com.dandaevit.edu.jdbc.mappers.implementations;

import java.sql.Connection;
import java.sql.SQLException;

import com.dandaevit.edu.jdbc.dao.implementations.RoleDAOImplementation;
import com.dandaevit.edu.jdbc.data_base_connection_manager.DatabaseConnectionManager;
import com.dandaevit.edu.jdbc.dto.CreateUserDTO;
import com.dandaevit.edu.jdbc.mappers.interfaces.Mapper;
import com.dandaevit.edu.jdbc.mappers.utils.LocalDateFormatter;
import com.dandaevit.edu.jdbc.model.user.Gender;
import com.dandaevit.edu.jdbc.model.user.User;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserMapper implements Mapper<User, CreateUserDTO> {
	private static CreateUserMapper INSTANCE = new CreateUserMapper();

	private final static Connection connection = DatabaseConnectionManager.get();

	private final RoleDAOImplementation roleDAOImplementation = RoleDAOImplementation.getInstance(connection);

	@Override
	public User mapFrom(CreateUserDTO createUserDTO) {
		try {
			return User.builder()
					   .firstName(createUserDTO.getFirstName())
					   .lastName(createUserDTO.getLastName())
					   .login(createUserDTO.getLogin())
					   .email(createUserDTO.getEmail())
					   .role(roleDAOImplementation.getRoleByName(createUserDTO.getRole()))
					   .birthDate( LocalDateFormatter.format(createUserDTO.getBirthDate()))
					   .gender(Gender.valueOf(createUserDTO.getGender().toUpperCase()))
					   .password(createUserDTO.getPassword())
					   .confirmPassword(createUserDTO.getConfirmPassword())
					   .build();
		} catch (SQLException e) {
			throw new RuntimeException("Mapping from " + CreateUserDTO.class.getName() + " to " + User.class.getName() + " failed");
		}
	}

	public static CreateUserMapper getInstance() {
		if (INSTANCE == null) {
			synchronized (CreateUserMapper.class) {
				// Дублированная проверка на null для потокобезопасности
				if (INSTANCE == null) {
					INSTANCE = new CreateUserMapper();
				}
			}
		}
		return INSTANCE;
	}
}
