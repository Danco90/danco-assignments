package com.travix.medusa.toughjet.datasource;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightDAO, Long> {

	Optional<List<FlightDAO>> findByFromAndToAndOutboundDateAndInboundDateAndNumberOfAdults(String from, String to, String outboundDate, String inboundDate, int numberOfAdults);
	
}
