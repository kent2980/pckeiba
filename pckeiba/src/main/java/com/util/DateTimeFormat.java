package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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


	/**
	 * LocalDateオブジェクトを指定されたフォーマット文字列に変換します。
	 * @param format フォーマット
	 * @param date 日付
	 * @return フォーマットされた日付文字列
	 */
	public static String getDateTimeValue(String format, LocalDate date) {
		LocalDateTime dateTime = date.atStartOfDay();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return dateTime.format(formatter);
	}
}
