package com.dandaevit.edu.jdbc.dao.interfaces;

import java.util.List;

import com.dandaevit.edu.jdbc.dto.TicketFilter;
import com.dandaevit.edu.jdbc.model.Ticket;
import com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions.AllTicketsSelectionException;
import com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions.NoSuchTicketException;
import com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions.TicketDeletingException;
import com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions.TicketInsertionException;
import com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions.TicketUpdatingException;

public interface TicketDAO {
	Ticket insertTicket(Ticket ticket) throws TicketInsertionException;
	void deleteTicket(int id) throws TicketDeletingException;
	Ticket updateTicket(Ticket ticket) throws TicketUpdatingException;

	Ticket getTicketByID(int id) throws NoSuchTicketException;
	List<Ticket> getAllTickets() throws AllTicketsSelectionException;
	List<Ticket> getAllTickets(TicketFilter filter) throws AllTicketsSelectionException;
}
