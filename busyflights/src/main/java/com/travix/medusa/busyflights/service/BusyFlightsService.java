package com.travix.medusa.busyflights.service;

import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.exception.FlightSearchException;

public interface BusyFlightsService {
	
	List<BusyFlightsResponse> lookupBestOffers(@RequestBody BusyFlightsRequest reqModel) throws FlightSearchException;
	
}
