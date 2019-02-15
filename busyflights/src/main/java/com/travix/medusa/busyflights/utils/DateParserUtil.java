package com.travix.medusa.busyflights.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class DateParserUtil {
	
	public static LocalDateTime stringToIsoLocalDateTime(String date) {
		//'2011-12-03T10:15:30'
		//"yyyy-MM-dd'T'HH:mm:ss.SSS";
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		return LocalDateTime.parse(date, outputFormatter);
	}
	
	public static ZonedDateTime stringToIsoInstant(String input) {
		//The ISO instant formatter that formats or parses 
		//an instant in UTC, such as '2011-12-03T10:15:30Z'.
		//Date and time of an Instant 
		
		//2011-12-03T10:15:30Z
		//YYYY-MM-DDThh:mm:ssZ
		
//		"2011-12-03T10:15:30Z";
		
//		DateTimeFormatter formatter =  DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.systemDefault());
		DateTimeFormatter formatter = new DateTimeFormatterBuilder()
			    .append(DateTimeFormatter.ISO_DATE_TIME)
			    .appendLiteral(':')
			    .appendFraction(ChronoField.MILLI_OF_SECOND, 3, 3, false)
			    .appendLiteral('Z')
			    .toFormatter();
		LocalDateTime instant = LocalDateTime.parse(input, formatter);
		ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
		
		return zonedDateTime;
		
//		return ZonedDateTime.parse(input, formatter);
	}
	
	public static LocalDate stringToIsoLocalDate(String input) {
		//'03-12-2011'
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
		
		return LocalDate.parse(input, outputFormatter);
		
	}
	
}
