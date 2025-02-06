package com.dandaevit.edu.jdbc.sql_exceptions.user_exceptions;

import java.sql.SQLException;

public class UserInsertionException extends SQLException{
	public UserInsertionException(String message) {
		super(message);
	}

	public UserInsertionException(String message, Throwable cause) {
		super(message, cause);
	}
}
