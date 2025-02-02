package com.dandaevit.edu.jdbc.sql_exceptions.flights_exception;

import java.sql.SQLException;

public class AllFlightsSelectionException extends SQLException{
	public AllFlightsSelectionException(String message) {
		super(message);
	}

	public AllFlightsSelectionException(String message, Throwable cause) {
		super(message, cause);
	}
}
