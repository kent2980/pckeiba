package com.pckeiba.umagoto.test;

import java.math.BigDecimal;
import java.util.List;

import com.pckeiba.umagoto.UmagotoDataIndexLoad;
import com.pckeiba.umagoto.UmagotoDataIndexSet;

public class UmagotoDataIndexLoadTest {
	private final UmagotoDataIndexLoad index;
	private final List<UmagotoDataIndexSet> dataList;

	/**
	 * コンストラクタ
	 */
	public UmagotoDataIndexLoadTest(String raceCode, int hit) {
		index = new UmagotoDataIndexLoad(raceCode, hit);
		dataList = index.getIndexList();
	}

	/**
	 * @return dataList
	 */
	public List<UmagotoDataIndexSet> getDataList() {
		return dataList;
	}

	/**
	 * @return index
	 */
	public UmagotoDataIndexLoad getIndex() {
		return index;
	}

	public static void main(String[] args) {
		List<UmagotoDataIndexSet> list;
		String raceCode = "2018112505050811";
		int hit = 4;
		UmagotoDataIndexLoadTest test = new UmagotoDataIndexLoadTest(raceCode, hit);
		list = test.getDataList();

		list.forEach(s -> {
			System.out.println(s);
		});
		UmagotoDataIndexLoad load = test.getIndex();
		System.out.println("【平均値】");
		System.out.println("DRun= " + load.getAverageDrun());
		System.out.println("テン3F= " + load.getAverageZenhan3f());
		System.out.println("RPCI= " + load.getAverageRPCI());
		System.out.println("FPCI= " + load.getAverageFPCI());
		System.out.println("スピードレート= " + load.getAverageSpeedRate());

		System.out.println("【分散】");
		System.out.println("DRun= " + load.getDispersionDrun());
		System.out.println("テン3F= " + load.getDispersionZenhan3f());
		System.out.println("RPCI= " + load.getDispersionRPCI());
		System.out.println("FPCI= " + load.getDispersionFPCI());
		System.out.println("スピードレート= " + load.getDispersionSpeedRate());

		System.out.println("【レース傾向】");
		System.out.println("隊列= " + load.getRaceConvoy());
	}


}
