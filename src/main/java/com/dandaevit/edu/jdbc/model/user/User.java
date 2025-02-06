package com.dandaevit.edu.jdbc.model.user;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
	private Integer id;
	private final String firstName;
	private final String lastName;
	private final String login;
	private final String email;
	private final String password;
	private final String confirmPassword;
	private final Role role; // Связь с таблицей roles
	private final Gender gender;
	private final LocalDate birthDate;

	private User(Integer id, String firstName, String lastName, String login, String email, String password,
			String confirmPassword, Role role, Gender gender, LocalDate birthDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.role = role;
		this.gender = gender;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getLogin() {
		return login;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Role getRole() {
		return role;
	}

	public Gender getGender() {
		return gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String toString() {
		return "User {" +
				"\n\tid = " + this.id +
				"\n\tfirst_name = " + this.firstName +
				"\n\tlast_name = " + this.lastName +
				"\n\tlogin = " + this.login +
				"\n\temail = " + this.email +
				"\n\trole = " + this.role.getRoleName() +
				"\n\tgender = " + this.gender.name() +
				"\n\tpassword = " + this.password +
				"\n\tconfirm_password = " + this.confirmPassword +
				"\n}";

	}
}
