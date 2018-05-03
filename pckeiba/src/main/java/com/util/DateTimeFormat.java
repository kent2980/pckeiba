package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeFormat {
	/**
	 * SQLから取り出した日付型文字列を整形します。<br>引数 mode で形式を指定します。１が日付、２が時間を返します。
	 * @param date
	 * @param mode
	 * @return
	 * @throws ParseException
	 */
	public static String dateFormat(String date, int mode) {
		try {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s");
		Date day = sf.parse(date);
		switch(mode) {
		case 1:
			return new SimpleDateFormat("yyyy年MM月dd日").format(day);
		case 2:
			return new SimpleDateFormat("HH:mm").format(day);
		default:
			return null;
		} 
		}catch(ParseException e) {
			return null;
		}
	}
}
