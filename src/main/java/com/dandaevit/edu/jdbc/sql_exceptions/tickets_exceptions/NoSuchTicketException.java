package com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions;

import java.sql.SQLException;

public class NoSuchTicketException extends SQLException {
	public NoSuchTicketException(String message) {
		super(message);
	}

	public NoSuchTicketException(String message, Throwable cause) {
		super(message, cause);
	}
}
