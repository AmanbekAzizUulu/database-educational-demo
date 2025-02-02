package com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions;

import java.sql.SQLException;

public class TicketInsertionException extends SQLException{
	public TicketInsertionException(String message) {
		super(message);
	}

	public TicketInsertionException(String message, Throwable cause){
		super(message, cause);
	}
}
