package com.dandaevit.edu.jdbc.dao;

import java.sql.Connection;

import com.dandaevit.edu.jdbc.dao.implementations.FlightDAOImplementation;
import com.dandaevit.edu.jdbc.dao.implementations.TicketDAOImplementation;
import com.dandaevit.edu.jdbc.dao.interfaces.FlightDAO;
import com.dandaevit.edu.jdbc.dao.interfaces.TicketDAO;
import com.dandaevit.edu.jdbc.data_base_connection_manager.DatabaseConnectionManager;

public class DAOFactory {
	private static Connection connection;

	static {
			connection = DatabaseConnectionManager.get();
	}

	public static TicketDAO getTicketDAO() {
		return TicketDAOImplementation.getInstance(connection);
	}

	public static FlightDAO getFlightDAO() {
		return FlightDAOImplementation.getInstance(connection);
	}

	// TODO дописать создание других DAO
}
