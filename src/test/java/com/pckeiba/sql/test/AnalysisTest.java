package com.pckeiba.sql.test;

import java.util.List;

import com.pckeiba.analysis.UmagotoAnalysis;
import com.pckeiba.umagoto.UmagotoDataLoad;

public class AnalysisTest {

	public static void main(String[] args) {
		UmagotoDataLoad load = new UmagotoDataLoad("2018112505050811",5);
		UmagotoAnalysis analysis = new UmagotoAnalysis(load);
		//距離適性のテスト
		String evaluation = analysis.getDistanceAnalisis(1);
		System.out.println(evaluation );
		//レース間隔のテスト
		String count = analysis.getRaceInterval(1);
		System.out.println(count);
		//脚質判定テスト
		int hantei = analysis.getPredictionKyakushitsuHantei(4);
		System.out.println(hantei);
		List<String> kyakushitsuLabel = analysis.getKyakushitsuLabel(4);
		System.out.println(kyakushitsuLabel);
	}

}
