// данный класс использовался для получения данных

package com.dandaevit.edu.jdbc.dto;

import com.dandaevit.edu.jdbc.model.user.Role;

import lombok.Builder;
import lombok.Data;

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

}
