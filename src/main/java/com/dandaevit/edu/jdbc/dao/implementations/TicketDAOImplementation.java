package com.dandaevit.edu.jdbc.dao.implementations;

import java.util.List;

import com.dandaevit.edu.jdbc.dao.interfaces.TicketDAO;
import com.dandaevit.edu.jdbc.model.Ticket;
import com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions.AllTicketsSelectionException;
import com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions.NoSuchTicketException;
import com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions.TicketDeletingException;
import com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions.TicketInsertionException;
import com.dandaevit.edu.jdbc.sql_exceptions.tickets_exceptions.TicketUpdatingException;

public class TicketDAOImplementation implements TicketDAO {

	@Override
	public void insertTicket(Ticket ticket) throws TicketInsertionException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'insertTicket'");
	}

	@Override
	public void deleteTicket(int id) throws TicketDeletingException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteTicket'");
	}

	@Override
	public void updateTicket(Ticket ticket) throws TicketUpdatingException {
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

}
