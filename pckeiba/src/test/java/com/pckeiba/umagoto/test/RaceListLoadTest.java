package com.pckeiba.umagoto.test;

import java.time.LocalDate;

import com.pckeiba.schedule.RaceListLoad;

public class RaceListLoadTest {

	public static void main(String[] args) {
		RaceListLoad loader = new RaceListLoad(LocalDate.parse("2018-05-06"));
		System.out.println(loader.getKeibajoCount());
		System.out.println(loader.getKeibajoList());
	}

}
