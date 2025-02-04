package com.dandaevit.edu.jdbc.dao.interfaces;

import java.util.List;

import com.dandaevit.edu.jdbc.model.Flight;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.AllFlightsSelectionException;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.FlightDeletingException;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.FlightInsertionException;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.FlightUpdatingException;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.NoSuchFlightException;

public interface FlightDAO {
	Flight insertFlight(Flight flight) throws FlightInsertionException;
	boolean deleteFlight(int id) throws FlightDeletingException;
	Flight updateFlight(Flight flight) throws FlightUpdatingException;

	Flight getFlightByID(int id) throws NoSuchFlightException;
	List<Flight> getAllFlights() throws AllFlightsSelectionException;
}
