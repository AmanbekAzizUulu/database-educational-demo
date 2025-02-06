package com.dandaevit.edu.jdbc.sql_exceptions.user_exceptions;

import java.sql.SQLException;

public class UserCreationException extends SQLException {
	public UserCreationException(String message) {
		super(message);
	}

	public UserCreationException(String message, Throwable cause) {
		super(message, cause);
	}
}
