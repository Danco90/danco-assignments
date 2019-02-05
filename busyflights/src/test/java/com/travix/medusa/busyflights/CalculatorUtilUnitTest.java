package com.travix.medusa.busyflights;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.travix.medusa.busyflights.utils.CalculatorUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorUtilUnitTest {
	
	@Test
	public void testCalcFinalPrice() {
		double basePrice = 15.0;
		double tax = 2.90;
		double discount = 0.20;
		
		double expected = 14.32;
		double expectedNoDiscount = 17.90;
		
		double realPrice = CalculatorUtil.calcFinalPrice(basePrice, tax, discount);
		assertThat(realPrice).isEqualTo(expected);
		
		realPrice = CalculatorUtil.calcFinalPrice(basePrice, tax, 0);
		assertThat(realPrice).isEqualTo(expectedNoDiscount);
		
	}
	
	@Test
	public void testRoundToDecimal() {
		double num = 14.39887;
		double roundedExpected = 14.40;
		double roundedReal = CalculatorUtil.roundToDecimal(num);
		assertThat(roundedReal).isEqualTo(roundedExpected);
	}

}
