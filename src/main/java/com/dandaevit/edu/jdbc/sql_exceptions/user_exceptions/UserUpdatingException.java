package com.dandaevit.edu.jdbc.sql_exceptions.user_exceptions;

import java.sql.SQLException;

public class UserUpdatingException extends SQLException {
	public UserUpdatingException(String message) {
		super(message);
	}

	public UserUpdatingException(String message, Throwable cause) {
		super(message, cause);
	}
}
