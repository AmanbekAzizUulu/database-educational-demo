package com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions;

import java.sql.SQLException;

public class TicketCreationException extends SQLException {
	public TicketCreationException(String message) {
		super(message);
	}

	public TicketCreationException(String message, Throwable cause) {
		super(message, cause);
	}
}
