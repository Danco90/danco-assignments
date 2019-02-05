package com.travix.medusa.busyflights.exception;

public class FlightSearchException extends Exception {
	
	private static final long serialVersionUID = -3332292346834265371L;
	
	public FlightSearchException(String mex, final String IATA_FROM, String IATA_TO) {
		super("FlightSearchException for flight : " + IATA_FROM + "-" + IATA_TO);
	}

}