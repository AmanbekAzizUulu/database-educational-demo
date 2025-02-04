package com.dandaevit.edu.jdbc.model;

import java.time.LocalDateTime;

public class Flight {
	private int id; 							// Идентификатор рейса
	private String flightNo; 					// Номер рейса
	private LocalDateTime departureDate; 		// Дата и время вылета
	private LocalDateTime arrivalDate; 			// Дата и время прилета
	private String departureAirportCode; 		// Код аэропорта вылета
	private String arrivalAirportCode; 			// Код аэропорта прилета
	private int aircraftId; 					// Идентификатор самолета
	private String status; 						// Статус рейса (например, "scheduled", "departed", "cancelled")

	public Flight(){
	}

	public Flight(Flight flight){
		this.id = flight.id;
		this.flightNo = flight.flightNo;
		this.departureDate = flight.departureDate;
		this.arrivalDate = flight.arrivalDate;
		this.departureAirportCode = flight.departureAirportCode;
		this.arrivalAirportCode = flight.arrivalAirportCode;
		this.aircraftId = flight.aircraftId;
		this.status = flight.status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}

	public int getAircraftId() {
		return aircraftId;
	}

	public void setAircraftId(int aircraftId) {
		this.aircraftId = aircraftId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Flight {" +
				"\n\tid=" + id +
				",\n\tflightNo='" + flightNo + '\'' +
				",\n\tdepartureDate=" + departureDate +
				",\n\tarrivalDate=" + arrivalDate +
				",\n\tdepartureAirportCode='" + departureAirportCode + '\'' +
				",\n\tarrivalAirportCode='" + arrivalAirportCode + '\'' +
				",\n\taircraftId=" + aircraftId +
				",\n\tstatus='" + status + '\'' +
		"\n}";
	}
}
