/**
 *
 */
package com.pckeiba.umagoto;

import java.util.Comparator;

/**
 * @author kent2
 *
 */
public class UmagotoDataIndexSetComparetor implements Comparator<UmagotoDataIndexSet> {

	@Override
	public int compare(UmagotoDataIndexSet o1, UmagotoDataIndexSet o2) {
		int chakujun1 = o1.getKauteiChakujun();
		int chakujun2 = o2.getKauteiChakujun();

		if(chakujun1 > chakujun2) {
			return 1;
		}else if(chakujun1 == chakujun2) {
			return 0;
		}else {
			return -1;
		}
	}

}
