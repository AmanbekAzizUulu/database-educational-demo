package com.dandaevit.edu.jdbc.controllers;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import com.dandaevit.edu.jdbc.dto.TicketDTO;
import com.dandaevit.edu.jdbc.service.TicketService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TicketServlet extends HttpServlet {
	private static final String TICKETS_HTML = """
		<!DOCTYPE html>
		<html lang="en">
		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
			<title>Tickets for Flight</title>
			<style>
				table {
					width: 100%%;
					border-collapse:
					collapse;
				}
				th, td {
					border: 1px solid black;
					padding: 8px;
					text-align: left;
				}
				th {
					background-color: #f2f2f2;
				}
			</style>
		</head>
		<body>
			<h1>Tickets for Flight</h1>
			<table>
				<thead>
					<tr>
						<th>Passenger Name</th>
						<th>Seat NO</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					%s
				</tbody>
			</table>
		</body>
		</html>
		""";

	private final TicketService ticketService = TicketService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html; charset=UTF-8");
		var writer = resp.getWriter();

		String flightIdParam = req.getParameter("flightId");
		if (flightIdParam == null || flightIdParam.isBlank()) {
			writer.write("<h1>Ошибка: Не указан flightId</h1>");
			return;
		}

		int flightId;
		try {
			flightId = Integer.parseInt(flightIdParam);
		} catch (NumberFormatException e) {
			writer.write("<h1>Ошибка: Некорректный flightId</h1>");
			return;
		}

		List<TicketDTO> tickets = ticketService.getTicketsByFlightId(flightId);

		String ticketsTable = tickets.stream()
				.map(ticket ->
						"<tr><td>" + ticket.passengerName() + "</td>" +
						"<td>" + ticket.seat().getSeatNo() + "</td>" +
						"<td>" + ticket.price().setScale(2, RoundingMode.HALF_UP).toString() + "</td></tr>")
				.collect(Collectors.joining());

		String ticketsListByFlightIdHtml = TICKETS_HTML.formatted( ticketsTable);

		writer.write(ticketsListByFlightIdHtml);
	}
}
