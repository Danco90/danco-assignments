package com.travix.medusa.toughjet.datasource;

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
	
	@Column(name = "_FROM")
	private String from;

	@Column(name = "_TO")
	private String to;

	@Column(name = "OUTBOUND_DATE")
	private String outboundDate;

	@Column(name = "INBOUND_DATE")
	private String inboundDate;
	
	@Column(name = "NUMBER_OF_ADULTS")
	private int numberOfAdults;

	@Column(name = "CARRIER")
	private String carrier;

	@Column(name = "BASE_PRICE")
	private double basePrice;

	@Column(name = "TAX")
	private double tax;

	@Column(name = "DISCOUNT")
	private double discount;
	
	public FlightDAO() {
		
	}

	public FlightDAO(Long flightId, String from, String to, String outboundDate, String inboundDate, int numberOfAdults,
			String carrier, double basePrice, double tax, double discount) {
		this.flightId = flightId;
		this.from = from;
		this.to = to;
		this.outboundDate = outboundDate;
		this.inboundDate = inboundDate;
		this.numberOfAdults = numberOfAdults;
		this.carrier = carrier;
		this.basePrice = basePrice;
		this.tax = tax;
		this.discount = discount;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getOutboundDate() {
		return outboundDate;
	}

	public void setOutboundDate(String outboundDate) {
		this.outboundDate = outboundDate;
	}

	public String getInboundDate() {
		return inboundDate;
	}

	public void setInboundDate(String inboundDate) {
		this.inboundDate = inboundDate;
	}

	public int getNumberOfAdults() {
		return numberOfAdults;
	}

	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
}