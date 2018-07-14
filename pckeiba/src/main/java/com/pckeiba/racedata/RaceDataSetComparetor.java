package com.pckeiba.racedata;

import java.util.Comparator;

/**
 * RaceDataSetの比較を行うクラスです
 * @author kent2
 *
 */
public class RaceDataSetComparetor implements Comparator<RaceDataSet> {

	/**
	 * 引数に指定した2つのオブジェクトの比較を行います
	 */
	@Override
	public int compare(RaceDataSet o1, RaceDataSet o2) {
		if(o1.getRaceBango() > o2.getRaceBango())
			return 1;
		if(o1.getRaceBango() < o2.getRaceBango())
			return -1;

		return 0;
	}

}
