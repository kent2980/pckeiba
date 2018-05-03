package com.util;

public class TrackCodeFormat {
	public static String getBaba(String trackCode) {
		try {
			return trackCode.substring(0, trackCode.indexOf("･"));
		}catch(StringIndexOutOfBoundsException e) {
			return trackCode.substring(0, trackCode.indexOf(" "));
		}
	}
}
