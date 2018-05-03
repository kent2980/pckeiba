package com.pckeiba.racecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class RaceCodeSet {
	private String raceCode;
	
	public RaceCodeSet(LocalDate date , String keibajo , int raceBango) {
		/**
		 * フィールド
		 */
		String SchedulefindValue = null;
		String jvCodeValue = null;
		// 日付を文字列として取り出す
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
		String dateValue = format.format(date);
		//csvから対象行を取り出す
		Path SchedulePath = Paths.get("D:\\jvdata\\jv_Kaisai_Schedule.csv");
		Path jvCodePath = Paths.get("D:\\jvdata\\jv_Keibajo_Code.csv");
		try(BufferedReader Schedulereader = Files.newBufferedReader(SchedulePath, StandardCharsets.UTF_8);
				BufferedReader jvCodereader = Files.newBufferedReader(jvCodePath, StandardCharsets.UTF_8)){
			//開催スケジュールを取得する
			Optional<String> SchedulereaderFind = Schedulereader.lines()
																										.filter(s -> s.contains(dateValue))
																										.filter(s -> s.contains(keibajo))
																										.findFirst();
			SchedulefindValue = SchedulereaderFind.get();
			//競馬場コードを取得する
			Optional<String> jvCodereaderFind = jvCodereader.lines()
																											.filter(s -> s.contains(keibajo))
																											.findFirst();
			jvCodeValue = jvCodereaderFind.get();
			jvCodeValue = jvCodeValue.substring(jvCodeValue.indexOf(",") + 1, jvCodeValue.length());
		}catch(IOException e) {
			System.out.println(e);
		}
		//レースコードを取得する
		int kaiji = Integer.parseInt(SchedulefindValue.substring(SchedulefindValue.indexOf(",") + 1, SchedulefindValue.indexOf("回")));
		int nichiji = Integer.parseInt(SchedulefindValue.substring(SchedulefindValue.indexOf(keibajo) + 2, SchedulefindValue.indexOf("日目")));
		this.raceCode = dateValue + jvCodeValue + String.format("%02d", kaiji) + String.format("%02d", nichiji) + String.format("%02d", raceBango);
	}
	
	public String getRaceCode() {
		return raceCode;
	}
	
	@Override
	public String toString() {
		return raceCode;
	}
}
