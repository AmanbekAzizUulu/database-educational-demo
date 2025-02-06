package com.dandaevit.edu.jdbc.sql_exceptions.user_exceptions;

import java.sql.SQLException;

public class AllUsersSelectionException extends SQLException{
	public AllUsersSelectionException(String message) {
		super(message);
	}

	public AllUsersSelectionException(String message, Throwable cause) {
		super(message, cause);
	}
}
