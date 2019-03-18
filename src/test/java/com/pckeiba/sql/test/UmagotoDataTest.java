package com.pckeiba.sql.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.pckeiba.umagoto.UmagotoDataLoad;
import com.pckeiba.umagoto.UmagotoDataSet;

public class UmagotoDataTest {

	public static void main(String[] args) {
		UmagotoDataLoad load = new UmagotoDataLoad("2018071402020311",5);
		List<UmagotoDataSet> list = load.getList();
		String day = list.get(0).getKaisaiNenGappi();
		System.out.println(day);
		LocalDate date7 = LocalDate.parse(day, DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
		System.out.println(date7);
	}

}
