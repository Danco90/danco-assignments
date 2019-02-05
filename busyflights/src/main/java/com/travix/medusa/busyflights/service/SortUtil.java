package com.travix.medusa.busyflights.service;

import java.util.Comparator;
import java.util.List;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.exception.FlightSearchException;

public class SortUtil {
	
	public static List<BusyFlightsResponse> sortByFareAsc(List<BusyFlightsResponse> list) throws FlightSearchException{
		if(!list.isEmpty()) {
			list.sort(Comparator.comparing(BusyFlightsResponse::getFare));
		}
		return list;
	}
		

}
