package com.dandaevit.edu.jdbc.dao.implementations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dandaevit.edu.jdbc.dao.interfaces.TicketDAO;
import com.dandaevit.edu.jdbc.dto.TicketFilter;
import com.dandaevit.edu.jdbc.model.Ticket;
import com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions.AllTicketsSelectionException;
import com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions.NoSuchTicketException;
import com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions.TicketDeletingException;
import com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions.TicketInsertionException;
import com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions.TicketUpdatingException;

public class TicketDAOImplementation implements TicketDAO {
	private final Connection connection;
	private static TicketDAOImplementation INSTANCE;

	private static String SELECTION_QUERY  = """
			select
				id,
				passport_no,
				passenger_name,
				flight_id,
				seat_id,
				cost
			from
				flights_management.tickets

			""";

	private TicketDAOImplementation(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Ticket insertTicket(Ticket ticket) throws TicketInsertionException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'insertTicket'");
	}

	@Override
	public void deleteTicket(int id) throws TicketDeletingException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteTicket'");
	}

	@Override
	public Ticket updateTicket(Ticket ticket) throws TicketUpdatingException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateTicket'");
	}

	@Override
	public Ticket getTicketByID(int id) throws NoSuchTicketException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getTicketByID'");
	}

	@Override
	public List<Ticket> getAllTickets() throws AllTicketsSelectionException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getAllTickets'");
	}

	@Override
	public List<Ticket> getAllTickets(TicketFilter filter) {
		List<Ticket> tickets = new ArrayList<>();

		List<Object> parameters = new ArrayList<>();
		List<String> whereSQL = new ArrayList<>();

		if (filter.passengerName() != null) {
			parameters.add("%" + filter.passengerName() + "%");
			whereSQL.add("passenger_name like ?");
		}
		if (filter.seatId() != null) {
			parameters.add(filter.seatId());
			whereSQL.add("seat_id = ?");
		}
		if (!whereSQL.isEmpty()) {
			SELECTION_QUERY += " WHERE " + String.join(" AND ", whereSQL);
		}

		SELECTION_QUERY += " LIMIT ? OFFSET ?";

		parameters.add(filter.limit());
		parameters.add(filter.offset());

		try (var statement = connection.prepareStatement(SELECTION_QUERY)) {
			for (int i = 0; i < parameters.size(); i++) {
				statement.setObject(i + 1, parameters.get(i));
			}

			try (var result = statement.executeQuery()) {
				while (result.next()) {
					tickets.add(new Ticket(
							result.getInt("id"),
							result.getString("passport_no"),
							result.getString("passenger_name"),
							result.getInt("flight_id"),
							result.getInt("seat_id"),
							result.getBigDecimal("cost"))
					);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tickets;
	}


	// Статический метод для получения единственного экземпляра
	public static TicketDAOImplementation getInstance(Connection connection) {
		if (INSTANCE == null) {
			synchronized (FlightDAOImplementation.class) {
				// Дублированная проверка на null для потокобезопасности
				if (INSTANCE == null) {
					INSTANCE = new TicketDAOImplementation(connection);
				}
			}
		}
		return INSTANCE;
	}
}
