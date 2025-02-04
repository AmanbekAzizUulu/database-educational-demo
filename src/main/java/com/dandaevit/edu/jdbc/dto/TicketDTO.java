package com.dandaevit.edu.jdbc.dto;

import java.math.BigDecimal;

import com.dandaevit.edu.jdbc.model.Seat;

public record TicketDTO(
		int id,
		String passengerName,
		Seat seat,
		BigDecimal price) {
}
