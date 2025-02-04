package com.dandaevit.edu.jdbc.dto;

public record TicketFilter(
		Integer seatId,
		String passengerName,
		int limit,
		int offset) {
}
