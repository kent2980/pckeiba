package com.pckeiba.sql.test;

import java.time.LocalDate;

import com.pckeiba.racecode.RaceCodeSet;

public class RaceCodeTest {

	public static void main(String[] args) {
		System.out.println(new RaceCodeSet(LocalDate.of(2018, 4, 29),"京都",11));
	}

}
