package com.travix.medusa.busyflights.client;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.exception.FlightSearchException;

@FeignClient(name="crazyair-service")
@RibbonClient(name="crazyair-service")
public interface CrazyAirServiceProxy {

	@PutMapping("/api/crazyair")
	public List<CrazyAirResponse> getFilteredFlights(@RequestBody CrazyAirRequest input) throws FlightSearchException;
	
}
