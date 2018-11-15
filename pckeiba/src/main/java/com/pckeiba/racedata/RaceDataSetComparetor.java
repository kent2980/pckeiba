package com.pckeiba.racedata;

import java.util.Comparator;

/**
 * RaceDataSetの比較を行うクラスです
 * @author kent2
 *
 */
public class RaceDataSetComparetor implements Comparator<RaceDataDefault> {

	/**
	 * 引数に指定した2つのオブジェクトの比較を行います
	 */
	@Override
	public int compare(RaceDataDefault o1, RaceDataDefault o2) {
		if(o1.getRaceBango() > o2.getRaceBango())
			return 1;
		if(o1.getRaceBango() < o2.getRaceBango())
			return -1;

		return 0;
	}

}
