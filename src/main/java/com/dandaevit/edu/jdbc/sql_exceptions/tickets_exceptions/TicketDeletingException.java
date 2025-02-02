package com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions;

import java.sql.SQLException;

public class TicketDeletingException extends SQLException {
	public TicketDeletingException(String message) {
		super(message);
	}

	public TicketDeletingException(String message, Throwable cause) {
		super(message, cause);
	}
}
