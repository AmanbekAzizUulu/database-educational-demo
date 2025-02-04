package com.dandaevit.edu;

import java.util.List;

import com.dandaevit.edu.jdbc.dao.DAOFactory;
import com.dandaevit.edu.jdbc.dao.interfaces.TicketDAO;
import com.dandaevit.edu.jdbc.dto.TicketFilter;
import com.dandaevit.edu.jdbc.model.Ticket;
import com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions.AllTicketsSelectionException;

/**
 *
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			TicketDAO ticketDAO = DAOFactory.getTicketDAO();

			List<Ticket> allTickets = ticketDAO.getAllTickets(new TicketFilter(4, "А", 2, 0));

			allTickets.forEach(System.out::println);

		} catch (AllTicketsSelectionException e) {
			e.printStackTrace();
		}
	}
}
