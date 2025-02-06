package com.dandaevit.edu.jdbc.sql_exceptions.user_exceptions;

import java.sql.SQLException;

public class NoSuchUserException extends SQLException {
	public NoSuchUserException(String message) {
		super(message);
	}

	public NoSuchUserException(String message, Throwable cause) {
		super(message, cause);
	}
}
