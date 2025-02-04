package com.dandaevit.edu.jdbc.model;

import java.math.BigDecimal;

public class Ticket {
	private int id;
	private String passportNo;
	private String passengerName;
	private int flightId;
	private Seat seat;
	private BigDecimal cost;

	public Ticket(int id, String passportNo, String passangerName, int flightId, Seat seat, BigDecimal cost) {
		this.id = id;
		this.passportNo = passportNo;
		this.passengerName = passangerName;
		this.flightId = flightId;
		this.seat= seat;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public Seat getSeat() {
		return this.seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Ticket {" +
				"\n\tid=" + this.id +
				",\n\tpassportNo='" + this.passportNo + '\'' +
				",\n\tpassengerName='" + this.passengerName + '\'' +
				",\n\tflightId=" + this.flightId +
				",\n\t" + this.seat.toString() +
				",\n\tcost=" + cost +
		"\n}";
	}

}
