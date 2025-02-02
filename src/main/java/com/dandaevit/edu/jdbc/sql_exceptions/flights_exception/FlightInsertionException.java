package com.dandaevit.edu.jdbc.sql_exceptions.flights_exception;

import java.sql.SQLException;

public class FlightInsertionException extends SQLException{
	public FlightInsertionException(String message) {
		super(message);
	}

	public FlightInsertionException(String message, Throwable cause){
		super(message, cause);
	}
}
