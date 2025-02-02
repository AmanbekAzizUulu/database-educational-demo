package com.dandaevit.edu.jdbc.dao;

import com.dandaevit.edu.jdbc.dao.implementations.FlightDAOImplementation;
import com.dandaevit.edu.jdbc.dao.implementations.TicketDAOImplementation;
import com.dandaevit.edu.jdbc.dao.interfaces.FlightDAO;
import com.dandaevit.edu.jdbc.dao.interfaces.TicketDAO;

public class DAOFactory {
	public static TicketDAO getTicketDAO() {
		return new TicketDAOImplementation();
	}

	public static FlightDAO getFlightDAO() {
		return new FlightDAOImplementation();
	}

	// TODO дописать создание других DAO 
}
