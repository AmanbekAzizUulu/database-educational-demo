package com.dandaevit.edu.jdbc.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserDTO {
	private String firstName;
	private String lastName;
	private String login;
	private String email;
	private String role;
	private String gender;
	private String birthDate;
	private String password;
	private String confirmPassword;
}
