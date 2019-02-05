package com.travix.medusa.crazyair.mapper;

import java.util.ArrayList;
import java.util.List;

import com.travix.medusa.crazyair.datasource.FlightDAO;
import com.travix.medusa.crazyair.model.CrazyAirResponse;

public class CrazyairMapper {
	
	public static List<CrazyAirResponse>mapToResponse(List<FlightDAO> input) {
		
		List<CrazyAirResponse> list = new ArrayList<>();
			for(FlightDAO dao : input) {
				CrazyAirResponse out = new CrazyAirResponse();
				out.setAirline(dao.getAirline());
				out.setDepartureDate(dao.getDepartureDate());
				out.setArrivalDate(dao.getReturnDate());
				out.setCabinclass(dao.getCabinClass());
				out.setDepartureAirportCode(dao.getOrigin());
				out.setDestinationAirportCode(dao.getDestination());
				out.setPrice(dao.getPrice());
				list.add(out);
			}
		return list;
	}

}
