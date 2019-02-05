package com.travix.medusa.busyflights;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.InputStream;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travix.medusa.busyflights.client.CrazyAirServiceProxy;
import com.travix.medusa.busyflights.client.ToughJetServiceProxy;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.BusyFlightsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusyFlightsServiceImplUnitTest {
	
	@Autowired
	private BusyFlightsService service;
	
	@MockBean
	private CrazyAirServiceProxy crazyAirservice;
	
	@MockBean
	private ToughJetServiceProxy toughJetservice;
	
	@Test
	public void testLookupFlight() throws Exception {
	
		 // Parsing mock file
		InputStream jsonInput = BusyFlightsResponse.class.getResourceAsStream("busyFlightsResponse.json");
		ObjectMapper mapper = new ObjectMapper();
		
		List<BusyFlightsResponse> bFr = mapper.readValue(jsonInput, mapper.getTypeFactory().constructCollectionType(List.class, BusyFlightsResponse.class));//TODO yo be moved in a proper util class
		BusyFlightsRequest bFreq = null;/*to be calculated*/
		
		
		// Mocking remote service
//		when(template.getForEntity(any(String.class), any(Class.class))).thenReturn(new ResponseEntity(mRs, HttpStatus.OK));
	    when(service.lookupBestOffers(any(BusyFlightsRequest.class))).thenReturn(bFr);   
	    
	    BusyFlightsRequest request = null;/*to be calculated*/
		
	    /**
	     * TODO
	     */
		BusyFlightsResponse response = null;
		
		assertThat(response).isNotNull();
	
	}
	
	
	

}
