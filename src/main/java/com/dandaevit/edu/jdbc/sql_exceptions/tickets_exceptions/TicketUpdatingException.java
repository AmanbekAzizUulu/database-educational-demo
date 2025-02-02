package com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions;

import java.sql.SQLException;

public class TicketUpdatingException extends SQLException {
	public TicketUpdatingException(String message) {
		super(message);
	}

	public TicketUpdatingException(String message, Throwable cause) {
		super(message, cause);
	}
}
