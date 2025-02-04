package com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions;

public class TicketCreationException extends Exception {
	public TicketCreationException(String message) {
		super(message);
	}

	public TicketCreationException(String message, Throwable cause) {
		super(message, cause);
	}
}
