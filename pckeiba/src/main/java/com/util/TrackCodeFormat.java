package com.util;

/**
 * トラックコードから開催馬場を取得するクラス
 * @author kent2
 *
 */
public class TrackCodeFormat {

	/**
	 * トラックコードから開催馬場を生成します
	 * @param trackCode トラックコード
	 * @return 開催馬場
	 */
	public static String getBaba(String trackCode) {
		try {
			return trackCode.substring(0, trackCode.indexOf("･"));
		}catch(StringIndexOutOfBoundsException e) {
			return trackCode.substring(0, trackCode.indexOf(" "));
		}
	}
}
