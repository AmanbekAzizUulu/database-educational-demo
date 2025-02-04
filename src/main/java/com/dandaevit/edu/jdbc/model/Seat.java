package com.dandaevit.edu.jdbc.model;

public class Seat {
	private final int id;
	private final int aircraftId;
	private final String seatNo;

	public Seat(int id, int aircraftId, String seatNo) {
		this.id = id;
		this.aircraftId = aircraftId;
		this.seatNo = seatNo;
	}

	public Seat(Seat seat) {
		this.id = seat.id;
		this.aircraftId = seat.aircraftId;
		this.seatNo = seat.seatNo;
	}

	public int getId() {
		return id;
	}

	public int getAircraftId() {
		return aircraftId;
	}

	public String getSeatNo() {
		return seatNo;
	}

	@Override
	public String toString() {
		return "Seat { seat id = " + this.id + ", seat no = " + this.seatNo +", aircraft id = " + this.aircraftId + " }";
	}

}
