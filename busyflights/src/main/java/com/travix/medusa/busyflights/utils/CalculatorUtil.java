package com.travix.medusa.busyflights.utils;

public class CalculatorUtil {
	
	public static double calcFinalPrice(double basePrice, double tax, double discount) {
		double tot = basePrice+tax;
		
		if( discount > 0 ) 
		{ 
			tot-=tot*discount; 
		}
		return roundToDecimal(tot);
	}
	
	public static double roundToDecimal(double num) {
		return Math.round(num * 100.0) / 100.0;
	}

}
