package com.travix.medusa.crazyair.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.crazyair.datasource.FlightDAO;
import com.travix.medusa.crazyair.datasource.FlightRepository;
import com.travix.medusa.crazyair.exception.FlightSearchException;
import com.travix.medusa.crazyair.mapper.CrazyairMapper;
import com.travix.medusa.crazyair.model.CrazyAirRequest;
import com.travix.medusa.crazyair.model.CrazyAirResponse;

@RequestMapping("/api/crazyair")
@RestController
public class CrazyAirController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	FlightRepository repository;
	
	
	@PutMapping("")
	public List<CrazyAirResponse> getFilteredFlights(@RequestBody CrazyAirRequest input) throws FlightSearchException {
		Optional<List<FlightDAO>> accountOptional = repository.findByOriginAndDestinationAndDepartureDateAndReturnDateAndPassengerCount(input.getOrigin(), input.getDestination(), input.getDepartureDate(), input.getReturnDate(), input.getPassengerCount());

		if(!accountOptional.isPresent()) {
			logger.error("getFilteredFlights result : empty list (Object might be not available for Invalid parameters)");
		}
		
		return CrazyairMapper.mapToResponse(accountOptional.get());
	}

}
