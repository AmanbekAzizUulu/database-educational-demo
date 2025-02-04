package com.dandaevit.edu.jdbc.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class UserDTO {

	private int id;

	private String userName;
	private String login;
	private String email;
	private String password;
	private String contactNumber;
	private Role role;

	@ToString
	public enum Role {
		ADMIN("admin"), GUEST("guest"), USER("user");

		private final String roleName;

		private Role(String roleName){
			this.roleName = roleName;
		}
	};
}
