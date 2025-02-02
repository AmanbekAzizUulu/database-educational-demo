package com.dandaevit.edu.jdbc.sql_exceptions.flights_exception;

import java.sql.SQLException;

public class FlightDeletingException extends SQLException {
	public FlightDeletingException(String message) {
		super(message);
	}

	public FlightDeletingException(String message, Throwable cause) {
		super(message, cause);
	}
}
