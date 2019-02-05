package com.travix.medusa.busyflights.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.exception.FlightSearchException;

public interface BusyFlightsEndpoint {
	
	final String ROOT = "/api/busyflights";
	final String SPECIFIC_REQUEST = "/search";
    
	@PutMapping(SPECIFIC_REQUEST)
	public ResponseEntity<List<BusyFlightsResponse>> searchFlights(@RequestBody BusyFlightsRequest reqModel) throws FlightSearchException;

}
