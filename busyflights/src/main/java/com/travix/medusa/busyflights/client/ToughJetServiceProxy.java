package com.travix.medusa.busyflights.client;

import java.util.List;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.exception.FlightSearchException;

@FeignClient(name="toughjet-service")
@RibbonClient(name="toughjet-service")
public interface ToughJetServiceProxy {
	
	@PutMapping("/api/toughjet")
	public List<ToughJetResponse> getFilteredFlights(@RequestBody ToughJetRequest request) throws FlightSearchException;

}
