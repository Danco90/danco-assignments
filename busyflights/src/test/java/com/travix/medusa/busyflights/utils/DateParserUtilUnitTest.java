package com.travix.medusa.busyflights.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateParserUtilUnitTest {
	
	
	@Test
	public void testStringToIsoLocalDateTime() {
//		String date = "2011-12-03 10:15:30";
		String date = "2011-12-03T10:15:30";
		
		//out format 2011-12-03T10:15:30
	
		LocalDateTime expectedDataValue = LocalDateTime.of(2011,12,3,10,15,30);  
	         
		LocalDateTime realDataValue = DateParserUtil.stringToIsoLocalDateTime(date);
		
		assertThat(realDataValue).isEqualTo(expectedDataValue);
	}
	
	@Test
	public void testStringToIsoInstant() {
		
		//expected out format '2011-12-03T10:15:30Z'.

//		String date = "2011-12-03 10:15:30";
		String date = "2011-12-03T10:15:30Z";
//		String date = "2011-12-03T10:15:30.000Z";
		
		ZonedDateTime expectedDataValue = ZonedDateTime.of(2011,12,3,10,15,30,0,ZoneId.of("Z"));
	         
		ZonedDateTime realDataValue = DateParserUtil.stringToIsoInstant(date);
		assertThat(realDataValue).isEqualTo(expectedDataValue);
	}
	
	@Test
	public void testStringToIsoLocalDate() {
		
		//expected out format '2011-12-03'
		String date = "03-12-2011";
		
		LocalDate expectedDataValue = LocalDate.of(2011, 12, 3);
		
		LocalDate realDataValue = DateParserUtil.stringToIsoLocalDate(date);

		assertThat(realDataValue).isEqualTo(expectedDataValue);
	}


}
