package com.travix.medusa.crazyair.datasource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "FLIGHT", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class FlightDAO {
	
	@Id
	@SequenceGenerator(name="flight_generator", sequenceName = "seq_flight"/*, initialValue = 5, allocationSize = 100*/)
	@GeneratedValue(generator = "flight_generator", strategy = GenerationType.SEQUENCE )
	@Column(name = "ID")
	private Long flightId;
	
	@Column(name = "ORIGIN")
	private String origin;

	@Column(name = "DESTINATION")
	private String destination;

	@Column(name = "DEPARTURE_DATE")
	private String departureDate;

	@Column(name = "RETURN_DATE")
	private String returnDate;
	
	@Column(name = "PASSENGER_COUNT")
	private int passengerCount;

	@Column(name = "AIRLINE")
	private String airline;

	@Column(name = "PRICE")
	private double price;

	@Column(name = "CABIN_CLASS")
	private String cabinClass;

	public FlightDAO() {
		
	}
	
	public FlightDAO(Long flightId, String origin, String destination, String departureDate, String returnDate,
			int passengerCount, String airline, double price, String cabinClass) {
		super();
		this.flightId = flightId;
		this.origin = origin;
		this.destination = destination;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.passengerCount = passengerCount;
		this.airline = airline;
		this.price = price;
		this.cabinClass = cabinClass;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCabinClass() {
		return cabinClass;
	}

	public void setCabinClass(String cabinClass) {
		this.cabinClass = cabinClass;
	}


}	