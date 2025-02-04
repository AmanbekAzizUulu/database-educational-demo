package com.dandaevit.edu.jdbc.dao.implementations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dandaevit.edu.jdbc.dao.interfaces.FlightDAO;
import com.dandaevit.edu.jdbc.model.Flight;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.AllFlightsSelectionException;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.FlightDeletingException;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.FlightInsertionException;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.FlightUpdatingException;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.NoSuchFlightException;

public class FlightDAOImplementation implements FlightDAO {
	private final Connection connection;
	private static FlightDAOImplementation INSTANCE;
	private static final String SELECT_ALL = """
			select
				*
			from
				flights_management.flights;
			""";

	private FlightDAOImplementation(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Flight insertFlight(Flight flight) throws FlightInsertionException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'insertFlight'");
	}

	@Override
	public boolean deleteFlight(int id) throws FlightDeletingException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteFlight'");
	}

	@Override
	public Flight updateFlight(Flight flight) throws FlightUpdatingException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateFlight'");
	}

	@Override
	public Flight getFlightByID(int id) throws NoSuchFlightException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getFlightByID'");
	}

	@Override
	public List<Flight> getAllFlights() throws AllFlightsSelectionException {
		var flights = new ArrayList<Flight>();

		try (var statement = connection.createStatement();) {
			var retrievedData = statement.executeQuery(SELECT_ALL);

			var flightHolder = new Flight();
			while (retrievedData.next()) {
				flightHolder.setId(retrievedData.getInt("id"));
				flightHolder.setFlightNo(retrievedData.getString("flight_no"));
				flightHolder.setDepartureDate(retrievedData.getTimestamp("departure_date").toLocalDateTime());
				flightHolder.setDepartureAirportCode(retrievedData.getString("departure_airport_code"));
				flightHolder.setArrivalDate(retrievedData.getTimestamp("arrival_date").toLocalDateTime());
				flightHolder.setArrivalAirportCode(retrievedData.getString("arrival_airport_code"));
				flightHolder.setAircraftId(retrievedData.getInt("aircraft_id"));
				flightHolder.setStatus(retrievedData.getString("status"));
				flights.add(new Flight(flightHolder));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flights;
	}

	// Статический метод для получения единственного экземпляра
	public static FlightDAOImplementation getInstance(Connection connection) {
		if (INSTANCE == null) {
			synchronized (FlightDAOImplementation.class) {
				// Дублированная проверка на null для потокобезопасности
				if (INSTANCE == null) {
					INSTANCE = new FlightDAOImplementation(connection);
				}
			}
		}
		return INSTANCE;
	}
}
