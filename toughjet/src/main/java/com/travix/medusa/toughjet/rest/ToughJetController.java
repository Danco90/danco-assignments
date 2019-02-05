package com.travix.medusa.toughjet.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.toughjet.datasource.FlightDAO;
import com.travix.medusa.toughjet.datasource.FlightRepository;
import com.travix.medusa.toughjet.exception.FlightSearchException;
import com.travix.medusa.toughjet.mapper.ToughJetMapper;
import com.travix.medusa.toughjet.model.ToughJetRequest;
import com.travix.medusa.toughjet.model.ToughJetResponse;


@RequestMapping("/api/toughjet")
@RestController
public class ToughJetController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	FlightRepository repository;
	
	
	@PutMapping("")
	public List<ToughJetResponse> getFilteredFlights(@RequestBody ToughJetRequest input) throws FlightSearchException {
		Optional<List<FlightDAO>> accountOptional = repository.findByFromAndToAndOutboundDateAndInboundDateAndNumberOfAdults(input.getFrom(), input.getTo(), input.getOutboundDate(), input.getInboundDate(), input.getNumberOfAdults());
		if(!accountOptional.isPresent()) {
			logger.error ("getFilteredFlights result : empty list (Object might be not available for Invalid parameters)");
		}
		
		return ToughJetMapper.mapToResponse(accountOptional.get());
	}
}