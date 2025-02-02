package com.dandaevit.edu.jdbc.dao.interfaces;

import java.util.List;

import com.dandaevit.edu.jdbc.model.Ticket;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.AllFlightsSelectionException;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.FlightDeletingException;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.FlightInsertionException;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.FlightUpdatingException;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.NoSuchFlightException;

public interface FlightDAO {
	void insertFlight(Ticket ticket) throws FlightInsertionException;
	void deleteFlight(int id) throws FlightDeletingException;
	void updateFlight(Ticket ticket) throws FlightUpdatingException;

	Ticket getFlightByID(int id) throws NoSuchFlightException;
	List<Ticket> getAllFlights() throws AllFlightsSelectionException;
}
