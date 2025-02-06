package com.dandaevit.edu.jdbc.sql_exceptions.user_exceptions;

import java.sql.SQLException;

public class UserDeletingException extends SQLException {
	public UserDeletingException(String message) {
		super(message);
	}

	public UserDeletingException(String message, Throwable cause) {
		super(message, cause);
	}
}
