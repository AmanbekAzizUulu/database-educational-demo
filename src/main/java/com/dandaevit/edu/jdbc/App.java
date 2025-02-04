package com.dandaevit.edu.jdbc;

import java.sql.SQLException;

import com.dandaevit.edu.jdbc.dao.implementations.TicketDAOImplementation;
import com.dandaevit.edu.jdbc.data_base_connection_manager.DatabaseConnectionManager;

public class App {
	public static void main(String[] args) {
		try {
			var ticketDAOImplementation = TicketDAOImplementation.getInstance(DatabaseConnectionManager.get());

			ticketDAOImplementation.getAllTicketsWithSeats().forEach(System.out::println);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
