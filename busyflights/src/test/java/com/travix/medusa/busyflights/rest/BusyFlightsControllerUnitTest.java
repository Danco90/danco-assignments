package com.travix.medusa.busyflights.rest;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.gson.Gson;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.rest.BusyFlightsController;
import com.travix.medusa.busyflights.service.BusyFlightsServiceImpl;
import com.travix.medusa.busyflights.utils.DateParserUtil;



@RunWith(SpringRunner.class)
@WebMvcTest(BusyFlightsController.class)
public class BusyFlightsControllerUnitTest {
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private BusyFlightsServiceImpl service;

	
	@Test
	public void givenBusyFlightsRequest_whenSearch_thenReturnJsonLisOfResultedFlights() throws Exception{
//		BusyFlightsRequest request = new BusyFlightsRequest("WAW", "WRO", "2018-12-28T10:15:30+01:00", "2018-01-01T10:15:30+01:00", 1);
//		
//		BusyFlightsResponse resp1 = new BusyFlightsResponse("Wizzair","CrazyAir", 19.99, "WAW", "WRO", DateParserUtil.stringToIsoDateTime("2018-12-28T10:15:30+01:00"), DateParserUtil.stringToIsoDateTime("2018-01-01T10:15:30+01:00"));
//		BusyFlightsResponse resp2 = new BusyFlightsResponse("Raynairr","CrazyAir", 29.99, "WAW", "WRO", DateParserUtil.stringToIsoDateTime("2018-12-28T10:15:30+01:00"), DateParserUtil.stringToIsoDateTime("2018-01-01T10:15:30+01:00"));
//		
		BusyFlightsRequest request = new BusyFlightsRequest("WAW", "WRO", "2018-12-28", "2018-01-01", 1);
		
		BusyFlightsResponse resp1 = new BusyFlightsResponse("Wizzair","CrazyAir", 19.99, "WAW", "WRO", DateParserUtil.stringToIsoLocalDateTime("2018-12-28"), DateParserUtil.stringToIsoLocalDateTime("2018-01-01"));
		BusyFlightsResponse resp2 = new BusyFlightsResponse("Raynairr","CrazyAir", 29.99, "WAW", "WRO", DateParserUtil.stringToIsoLocalDateTime("2018-12-28"), DateParserUtil.stringToIsoLocalDateTime("2018-01-01"));
		
		
		List<BusyFlightsResponse> allResults = Arrays.asList(resp1,resp2);
	
		given(service.lookupBestOffers(request)).willReturn(allResults);
		
		Gson gson = new Gson();
	    String json = gson.toJson(request);
	    
	    String jsonList = gson.toJson(allResults);
		
	    MvcResult result = mvc.perform(put("/api/busyflights/search")
			      .contentType(MediaType.APPLICATION_JSON)
			      .content(json)
				  .characterEncoding("utf-8"))
	    		      .andExpect(status().isOk())
	    		      .andExpect(MockMvcResultMatchers.content().json(jsonList))
	    		      .andReturn();   

	}
	
	
	
}