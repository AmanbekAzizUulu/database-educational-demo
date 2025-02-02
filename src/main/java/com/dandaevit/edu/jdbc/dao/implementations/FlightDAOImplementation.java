package com.dandaevit.edu.jdbc.dao.implementations;

import java.util.List;

import com.dandaevit.edu.jdbc.dao.interfaces.FlightDAO;
import com.dandaevit.edu.jdbc.model.Ticket;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.AllFlightsSelectionException;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.FlightDeletingException;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.FlightInsertionException;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.FlightUpdatingException;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.NoSuchFlightException;

public class FlightDAOImplementation implements FlightDAO {

	@Override
	public void insertFlight(Ticket ticket) throws FlightInsertionException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'insertFlight'");
	}

	@Override
	public void deleteFlight(int id) throws FlightDeletingException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteFlight'");
	}

	@Override
	public void updateFlight(Ticket ticket) throws FlightUpdatingException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateFlight'");
	}

	@Override
	public Ticket getFlightByID(int id) throws NoSuchFlightException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getFlightByID'");
	}

	@Override
	public List<Ticket> getAllFlights() throws AllFlightsSelectionException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getAllFlights'");
	}

}
