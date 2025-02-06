package com.dandaevit.edu.jdbc.sql_exceptions.roles_exceptions;

import java.sql.SQLException;

public class NoSuchRoleException extends SQLException {
	public NoSuchRoleException(String message) {
		super(message);
	}

	public NoSuchRoleException(String message, Throwable cause) {
		super(message, cause);
	}
}
