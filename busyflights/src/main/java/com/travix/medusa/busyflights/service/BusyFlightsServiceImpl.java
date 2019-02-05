package com.travix.medusa.busyflights.service;

import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.travix.medusa.busyflights.client.CrazyAirServiceProxy;
import com.travix.medusa.busyflights.client.ToughJetServiceProxy;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.exception.FlightSearchException;
import com.travix.medusa.busyflights.mapper.BusyFlightsMapper;

@Service
public class BusyFlightsServiceImpl implements BusyFlightsService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CrazyAirServiceProxy crazyAir_proxy;
	
	@Autowired
	ToughJetServiceProxy toughJet_proxy;
	
	@Override
	public List<BusyFlightsResponse> lookupBestOffers(@RequestBody BusyFlightsRequest reqModel) throws FlightSearchException{
		logger.info("lookup Best Offers method start");
		
		logger.debug("request : {} ",reqModel.toString());
		CrazyAirRequest crazyAirReq = BusyFlightsMapper.mapToCrazyAirReq(reqModel) ;
		ToughJetRequest toughJetReq = BusyFlightsMapper.mapToToughJetReq(reqModel) ;

		logger.info("Filtering results. Please wait..");
		return aggregateResults(crazyAir_proxy.getFilteredFlights(crazyAirReq), toughJet_proxy.getFilteredFlights(toughJetReq));
	}	
	
	private List<BusyFlightsResponse> aggregateResults(List<CrazyAirResponse> crzAirList, List<ToughJetResponse> tghJetlist) throws FlightSearchException{
		logger.info("aggregate Results method  start");
		List<BusyFlightsResponse> list = BusyFlightsMapper.mapToBusyFlightsResp(crzAirList, tghJetlist);
		
		if(!list.isEmpty()) {
			return SortUtil.sortByFareAsc(list);
		}
		return list;
		
	}
	
	

	 
}
