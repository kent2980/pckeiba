package com.pckeiba.sql.test;

import com.pckeiba.analysis.DistanceAnalysis;
import com.pckeiba.umagoto.UmagotoDataLoad;

public class AnalysisTest {

	public static void main(String[] args) {
		UmagotoDataLoad load = new UmagotoDataLoad("2018071402020310",5);
		DistanceAnalysis analysis = new DistanceAnalysis(load);
		String evaluation = analysis.getAnalisis(6);
		System.out.println(evaluation );
	}

}
