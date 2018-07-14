package com.pckeiba.sql.test;

import com.pckeiba.analysis.UmagotoAnalysis;
import com.pckeiba.umagoto.UmagotoDataLoad;

public class AnalysisTest {

	public static void main(String[] args) {
		UmagotoDataLoad load = new UmagotoDataLoad("2018060305030211",5);
		UmagotoAnalysis analysis = new UmagotoAnalysis(load);
		//距離適性のテスト
		String evaluation = analysis.getDistanceAnalisis(7);
		System.out.println(evaluation );
		//レース間隔のテスト
		String count = analysis.getRaceInterval(11);
		System.out.println(count);
	}

}
