package com.dandaevit.edu.jdbc.sql_exceptions.flights_exception;

import java.sql.SQLException;

public class FlightUpdatingException extends SQLException {
	public FlightUpdatingException(String message) {
		super(message);
	}

	public FlightUpdatingException(String message, Throwable cause) {
		super(message, cause);
	}
}
