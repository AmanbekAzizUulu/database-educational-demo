package com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions;

import java.sql.SQLException;

public class AllTicketsSelectionException extends SQLException{
	public AllTicketsSelectionException(String message) {
		super(message);
	}

	public AllTicketsSelectionException(String message, Throwable cause) {
		super(message, cause);
	}
}
