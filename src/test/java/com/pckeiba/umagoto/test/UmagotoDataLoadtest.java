package com.pckeiba.umagoto.test;

import java.math.BigDecimal;

import com.pckeiba.list.LapList;
import com.pckeiba.umagoto.UmagotoDataLoad;

public class UmagotoDataLoadtest {

	public UmagotoDataLoadtest() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public static void main(String[] args) {
		UmagotoDataLoad uma = new UmagotoDataLoad("2018112505050811",4);
		LapList list = uma.getList().get(0).getLap();
		for(BigDecimal time: list) {
			System.out.println("time" + time);
		}
		System.out.println(list.getHiSpeedPoint());
		System.out.println(list.getSpeedUpperPoint());
		System.out.println(list.getSpeedLowerPoint());
	}

}
