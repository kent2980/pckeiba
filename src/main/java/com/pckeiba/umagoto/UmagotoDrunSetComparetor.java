package com.pckeiba.umagoto;

import java.util.Comparator;

public class UmagotoDrunSetComparetor implements Comparator<UmagotoDrunSet> {

	@Override
	public int compare(UmagotoDrunSet o1, UmagotoDrunSet o2) {
		int drun1 = o1.getDrunRunk();
		int drun2 = o2.getDrunRunk();

		//drunの順位でソートします
		 if (drun1 > drun2) {
	            return 1;

	     } else if (drun1 == drun2) {
	            return 0;

	     } else {
	            return -1;

	     }
	}
}
