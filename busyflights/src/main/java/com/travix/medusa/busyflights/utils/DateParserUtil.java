package com.travix.medusa.busyflights.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class DateParserUtil {
	
	public static ZonedDateTime stringToIsoDateTime(String date) {
//		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		//'2011-12-03 10:15:30'
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		return ZonedDateTime.parse(date, format);
		
//		LocalDateTime localdatetime = LocalDateTime.parse(date);
	}
	
	public static ZonedDateTime stringToIsoInstant(String input) {
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
		DateTimeFormatter formatter = new DateTimeFormatterBuilder()
				.appendOptional( DateTimeFormatter.ISO_LOCAL_DATE )
				.toFormatter();
		
		return LocalDate.parse(input, formatter);
	}
	
}
