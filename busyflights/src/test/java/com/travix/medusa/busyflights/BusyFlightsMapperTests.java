package com.travix.medusa.busyflights;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.exception.FlightSearchException;
import com.travix.medusa.busyflights.mapper.BusyFlightsMapper;
import com.travix.medusa.busyflights.service.SortUtil;
import com.travix.medusa.busyflights.utils.DateParserUtil;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BusyFlightsMapperTests {
	
	
	public static final String SUPPLIER_NAME_CRAZYAIR = "CrazyAir";
	public static final String SUPPLIER_NAME_TOUGHJET = "ToughJet";
	
	@Test
	public void testMapToCrazyAirReq() {                               
		BusyFlightsRequest input = new BusyFlightsRequest("BGY","AMS","2019-01-01T12:00:00:000Z","2019-01-01T14:00:00:000Z",1);
		CrazyAirRequest expectedOut = new CrazyAirRequest("BGY","AMS","2019-01-01T12:00:00:000Z","2019-01-01T14:00:00:000Z",1);
		CrazyAirRequest actualOut = BusyFlightsMapper.mapToCrazyAirReq(input);
		
		assertThat(actualOut).isEqualToComparingFieldByField(expectedOut);

	}
	
	@Test
	public void  testMapToToughJetReq() {
		BusyFlightsRequest input = new BusyFlightsRequest("BGY","AMS","2019-01-01T12:00:00+01:00[Europe/Paris]","2019-01-01T12:00:00+01:00[Europe/Paris]",1);
		ToughJetRequest expectedOut = new ToughJetRequest("BGY","AMS","2019-01-01T12:00:00+01:00[Europe/Paris]","2019-01-01T12:00:00+01:00[Europe/Paris]",1);
		ToughJetRequest actualOut =BusyFlightsMapper.mapToToughJetReq(input);

		assertThat(actualOut).isEqualToComparingFieldByField(expectedOut);
	}
	
	
	@Test
	public void testMapToBusyFlightsResp() throws FlightSearchException {
		
		
		CrazyAirResponse crzResp = new CrazyAirResponse("Ryanair", 19.99, "E", "BGY","AMS","2019-01-01","2019-01-01T12:00:00+01:00[Europe/Paris]");		
		CrazyAirResponse crzResp2 = new CrazyAirResponse("Wizzair", 9.99, "E", "BGY","AMS","2019-01-01","2019-01-01T12:00:00+01:00[Europe/Paris]");
		                                            
		List<CrazyAirResponse> crazyAirResultList = Arrays.asList(crzResp, crzResp2);
		
		ToughJetResponse tjtResp = new ToughJetResponse("Ryanair", 19.99, 2.90, 0.15, "BGY","AMS","2019-01-01T12:00:00+01:00[Europe/Paris]","2019-01-01T12:00:00+01:00[Europe/Paris]");		
		ToughJetResponse tjtResp2 = new ToughJetResponse("Wizzair", 9.99, 2.90, 0.25, "BGY","AMS","2019-01-01T12:00:00+01:00[Europe/Paris]","2019-01-01T12:00:00+01:00[Europe/Paris]");	
		
		List<ToughJetResponse> toughJetResultList = Arrays.asList(tjtResp, tjtResp2);
		
		
		BusyFlightsResponse bsfResp = new BusyFlightsResponse("Wizzair","CrazyAir", 19.99, "WAW", "WRO", DateParserUtil.stringToIsoDateTime("2018-12-28T12:30:54"), DateParserUtil.stringToIsoDateTime("2018-12-28T12:30:54"));
		BusyFlightsResponse bsfResp2 = new BusyFlightsResponse("Raynairr","CrazyAir", 29.99, "WAW", "WRO", DateParserUtil.stringToIsoDateTime("2018-12-28T12:30:54"), DateParserUtil.stringToIsoDateTime("2018-12-28T12:30:54"));
		BusyFlightsResponse bsfResp3 = new BusyFlightsResponse("Wizzair","CrazyAir", 49.99, "WAW", "WRO", DateParserUtil.stringToIsoDateTime("2018-12-28T12:30:54"), DateParserUtil.stringToIsoDateTime("2018-12-28T12:30:54"));
		BusyFlightsResponse bsfResp4 = new BusyFlightsResponse("Raynairr","CrazyAir", 79.99, "WAW", "WRO", DateParserUtil.stringToIsoDateTime("2018-12-28T12:30:54"), DateParserUtil.stringToIsoDateTime("2018-12-28T12:30:54"));
		
		List<BusyFlightsResponse> expectedList = Arrays.asList(bsfResp, bsfResp2, bsfResp3, bsfResp4);

		List<BusyFlightsResponse> list = BusyFlightsMapper.mapToBusyFlightsResp(crazyAirResultList, toughJetResultList);

		assertThat(SortUtil.sortByFareAsc(list)).isEqualTo(SortUtil.sortByFareAsc(expectedList));
		

	}
	
}
