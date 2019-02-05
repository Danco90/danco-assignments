package com.travix.medusa.toughjet.mapper;

import java.util.ArrayList;
import java.util.List;

import com.travix.medusa.toughjet.datasource.FlightDAO;
import com.travix.medusa.toughjet.model.ToughJetResponse;

public class ToughJetMapper {
	
	public static List<ToughJetResponse>mapToResponse(List<FlightDAO> input) {
		
		List<ToughJetResponse> list = new ArrayList<>();
		
		for(FlightDAO dao : input) {
			ToughJetResponse out = new ToughJetResponse();
			out.setCarrier(dao.getCarrier());
			out.setBasePrice(dao.getBasePrice());
			out.setTax(dao.getTax());
			out.setDiscount(dao.getDiscount());
			out.setDepartureAirportName(dao.getFrom());
			out.setArrivalAirportName(dao.getTo());
			out.setOutboundDateTime(dao.getOutboundDate());
			out.setInboundDateTime(dao.getInboundDate());
			list.add(out);
		}
		return list;
	}

}
