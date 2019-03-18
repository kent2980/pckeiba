package com.pckeiba.sql.test;

import java.math.BigDecimal;
import java.util.List;

import com.pckeiba.umagoto.UmagotoDrunLoad;
import com.pckeiba.umagoto.UmagotoDrunSet;

public class DrunGetTest {

	public static void main(String[] args) {
		
		BigDecimal time = BigDecimal.valueOf(122.5);
		BigDecimal minute = time.divide(BigDecimal.valueOf(60), 0, BigDecimal.ROUND_DOWN);
		BigDecimal second = time.subtract(minute.multiply(BigDecimal.valueOf(60))).setScale(0, BigDecimal.ROUND_DOWN);
		BigDecimal comma = time.subtract(minute.multiply(BigDecimal.valueOf(60))).subtract(second);
		String value = minute + ":" + String.format("%02d", second.intValue()) + "." + comma.multiply(BigDecimal.TEN).setScale(0);
		System.out.println(value);
	}

}
