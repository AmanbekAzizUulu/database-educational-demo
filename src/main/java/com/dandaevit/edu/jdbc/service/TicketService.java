package com.dandaevit.edu.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dandaevit.edu.jdbc.dao.implementations.FlightDAOImplementation;
import com.dandaevit.edu.jdbc.dao.implementations.TicketDAOImplementation;
import com.dandaevit.edu.jdbc.data_base_connection_manager.DatabaseConnectionManager;
import com.dandaevit.edu.jdbc.dto.TicketDTO;
import com.dandaevit.edu.jdbc.model.Ticket;

public final class TicketService {
	private static TicketService INSTANCE = new TicketService();

	private final Connection connection = DatabaseConnectionManager.get();
	private final TicketDAOImplementation ticketDAOImplementation = TicketDAOImplementation.getInstance(connection);

	private final static Logger LOGGER = LoggerFactory.getLogger(TicketService.class.getName());

	public List<TicketDTO> getTicketsByFlightId(int flight) {
		List<TicketDTO> ticketDTOs = new ArrayList<>();

		try {
			List<Ticket> tickets = ticketDAOImplementation.getAllTicketsByFlightId(flight);

			if (tickets == null) {
				tickets = new ArrayList<>();
			}

			for (Ticket ticket : tickets) {
				ticketDTOs.add(new TicketDTO(
						ticket.getId(),
						ticket.getPassengerName(),
						ticket.getSeat(),
						ticket.getCost()));
			}
		} catch (SQLException e) {
			LOGGER.error(null, e);
		}
		return ticketDTOs;
	}

	private TicketService() {
	}

	public static TicketService getInstance() {
		if (INSTANCE == null) {
			synchronized (FlightDAOImplementation.class) {
				// Дублированная проверка на null для потокобезопасности
				if (INSTANCE == null) {
					INSTANCE = new TicketService();
				}
			}
		}
		return INSTANCE;
	}
}
