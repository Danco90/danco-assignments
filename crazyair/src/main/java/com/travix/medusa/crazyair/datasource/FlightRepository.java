package com.travix.medusa.crazyair.datasource;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travix.medusa.crazyair.exception.FlightSearchException;

public interface FlightRepository extends JpaRepository<FlightDAO, Long> {

	Optional<List<FlightDAO>> findByOriginAndDestinationAndDepartureDateAndReturnDateAndPassengerCount(String from, String to, String outboundDate, String inboundDate, int numberOfAdults) throws FlightSearchException;
	
}
