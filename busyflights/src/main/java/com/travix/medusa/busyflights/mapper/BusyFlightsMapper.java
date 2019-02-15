package com.travix.medusa.busyflights.mapper;

import java.util.ArrayList;
import java.util.List;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.utils.CalculatorUtil;
import com.travix.medusa.busyflights.utils.DateParserUtil;

public class BusyFlightsMapper {
	
	public static final String SUPPLIER_NAME_CRAZYAIR = "CrazyAir";
	public static final String SUPPLIER_NAME_TOUGHJET = "ToughJet";
	
	public static CrazyAirRequest mapToCrazyAirReq(BusyFlightsRequest input) {
		CrazyAirRequest out = new CrazyAirRequest();
		out.setOrigin(input.getOrigin());
		out.setDestination(input.getDestination());
		out.setDepartureDate(input.getDepartureDate());
		out.setReturnDate(input.getReturnDate());
		out.setPassengerCount(input.getNumberOfPassengers());
		
		return out;
	}
	
	public static ToughJetRequest mapToToughJetReq(BusyFlightsRequest input) {
		ToughJetRequest out = new ToughJetRequest();
		out.setFrom(input.getOrigin());
		out.setTo(input.getDestination());
		out.setOutboundDate(input.getDepartureDate());
		out.setInboundDate(input.getReturnDate());
		out.setNumberOfAdults(input.getNumberOfPassengers());
		
		return out;
	}
	
	public static List<BusyFlightsResponse> mapToBusyFlightsResp(List<CrazyAirResponse> crazyAirResultList, List<ToughJetResponse> toughJetResultList) {
		List<BusyFlightsResponse> outFinalList = new ArrayList<>();

		if(!crazyAirResultList.isEmpty()) {
			final BusyFlightsResponse out = new BusyFlightsResponse();
			crazyAirResultList.stream()
			.filter( elem -> elem != null)
			.forEach(elem -> { 
				out.setAirline(elem.getAirline());
				out.setSupplier(SUPPLIER_NAME_CRAZYAIR);
				out.setFare(elem.getPrice());
				out.setDepartureAirportCode(elem.getDepartureAirportCode());
				out.setDestinationAirportCode(elem.getDestinationAirportCode());
				out.setDepartureDate(DateParserUtil.stringToIsoLocalDateTime(elem.getDepartureDate()));
				out.setArrivalDate(DateParserUtil.stringToIsoLocalDateTime(elem.getArrivalDate()));
				
				outFinalList.add(out);
			});
		}
		
		
		if(!toughJetResultList.isEmpty()) {
			final BusyFlightsResponse out = new BusyFlightsResponse();
			toughJetResultList.stream()
			.filter(elem -> elem != null)
			.forEach(elem -> { 
				out.setAirline(elem.getCarrier());
				out.setSupplier(SUPPLIER_NAME_TOUGHJET);
				out.setFare(CalculatorUtil.calcFinalPrice(elem.getBasePrice(),elem.getTax(),elem.getDiscount()));
				out.setDepartureAirportCode(elem.getDepartureAirportName());
				out.setDestinationAirportCode(elem.getArrivalAirportName());
				out.setDepartureDate(DateParserUtil.stringToIsoLocalDateTime(elem.getOutboundDateTime()));
				out.setArrivalDate(DateParserUtil.stringToIsoLocalDateTime(elem.getInboundDateTime()));
				outFinalList.add(out);
			});
		}	
			
		return outFinalList;
	}
	
}
