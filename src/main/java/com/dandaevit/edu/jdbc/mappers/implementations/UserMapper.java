package com.dandaevit.edu.jdbc.mappers.implementations;

import com.dandaevit.edu.jdbc.dto.UserDTO;
import com.dandaevit.edu.jdbc.mappers.interfaces.Mapper;
import com.dandaevit.edu.jdbc.model.user.User;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper implements Mapper<UserDTO, User>{
	private static final UserMapper INSTANCE = new UserMapper();

	// private int id;

	// private String userName;
	// private String login;
	// private String email;
	// private String password;
	// private Role role;
	
	@Override
	public UserDTO mapFrom(User entity) {
		return UserDTO
					.builder()
					.id(entity.getId())
					.userName(entity.getFirstName())
					.login(entity.getLogin())
					.email(entity.getEmail())
					.password(entity.getPassword())
					.role(entity.getRole())
					.build();
	}

	public static UserMapper getInstance(){
		return INSTANCE;
	}

}
