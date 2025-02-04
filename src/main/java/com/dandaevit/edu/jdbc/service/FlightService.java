package com.dandaevit.edu.jdbc.service;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

import com.dandaevit.edu.jdbc.dao.implementations.FlightDAOImplementation;
import com.dandaevit.edu.jdbc.data_base_connection_manager.DatabaseConnectionManager;
import com.dandaevit.edu.jdbc.dto.FlightDTO;
import com.dandaevit.edu.jdbc.sql_exceptions.flights_exception.AllFlightsSelectionException;

public final class FlightService {
	private static FlightService INSTANCE = new FlightService();

	private final Connection connection = DatabaseConnectionManager.get();
	private final FlightDAOImplementation flightDAOImplementation = FlightDAOImplementation.getInstance(connection);

	public List<FlightDTO> findAll() {
		try {
			return flightDAOImplementation.getAllFlights().stream().map(
					flight -> new FlightDTO(
							flight.getId(),
							"%s — %s — %s".formatted(
							flight.getArrivalAirportCode(),
									flight.getDepartureAirportCode(),
									flight.getStatus())))
					.collect(Collectors.toList());
		} catch (AllFlightsSelectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private FlightService() {
	}

	public static FlightService getInstance() {
		if (INSTANCE == null) {
			synchronized (FlightDAOImplementation.class) {
				// Дублированная проверка на null для потокобезопасности
				if (INSTANCE == null) {
					INSTANCE = new FlightService();
				}
			}
		}
		return INSTANCE;
	}
}
