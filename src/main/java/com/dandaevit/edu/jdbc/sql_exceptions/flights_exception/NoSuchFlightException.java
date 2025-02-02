package com.dandaevit.edu.jdbc.sql_exceptions.flights_exception;

import java.sql.SQLException;

public class NoSuchFlightException extends SQLException {
	public NoSuchFlightException(String message) {
		super(message);
	}

	public NoSuchFlightException(String message, Throwable cause) {
		super(message, cause);
	}
}
