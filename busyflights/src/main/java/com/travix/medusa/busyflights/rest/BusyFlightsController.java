package com.travix.medusa.busyflights.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.exception.FlightSearchException;
import com.travix.medusa.busyflights.service.BusyFlightsServiceImpl;

@RestController
@RequestMapping(value = BusyFlightsEndpoint.ROOT)
public class BusyFlightsController implements BusyFlightsEndpoint {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Autowired
	BusyFlightsServiceImpl service;
	
	@Override
	@PutMapping(SPECIFIC_REQUEST)
	public ResponseEntity<List<BusyFlightsResponse>> searchFlights(@RequestBody BusyFlightsRequest reqModel) throws FlightSearchException{
		logger.info("search flights  start");
		logger.debug("search flights request : {}", reqModel);
		
		logger.info("Looking for your best solutions. Please wait...");
		List<BusyFlightsResponse> responseList = service.lookupBestOffers(reqModel);
		if(responseList.isEmpty()){
			logger.info("look up flights result : no flight found");
			return ResponseEntity.notFound().build();
		}
		
		logger.info("look up flights result : " + responseList.size() + "found flights -> {}", responseList.toString());
		 return new ResponseEntity(responseList, HttpStatus.OK);

	}

}
