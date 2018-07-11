package com.pckeiba.racecode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 指定された（日付、競馬場、レース番号）からレースコードを生成します
 * @author kent2
 *
 */
public class RaceCodeSet {
	private String raceCode;
	private RaceValue raceValue;

	/**
	 * コンストラクタ<br>
	 * （日付、競馬場、レース番号）を引数で指定してください
	 * @param date 日付
	 * @param keibajo 競馬場
	 * @param raceBango レース番号
	 */
	public RaceCodeSet(LocalDate date , String keibajo , int raceBango) {
		this.raceValue = new RaceValue(date, keibajo, raceBango);
		setRaceCode(raceValue);
	}

	/**
	 * レースを指定します<br>
	 * （日付、競馬場、レース番号）を引数で指定してください
	 * @param date 日付
	 * @param keibajo 競馬場
	 * @param raceBango レース番号
	 */
	public void setRaceValue(LocalDate date , String keibajo , int raceBango) {
		this.raceValue = new RaceValue(date, keibajo, raceBango);
		setRaceCode(raceValue);
	}

	/**
	 * レースデータからレースコードを生成します
	 * @param raceValue
	 */
	private void setRaceCode(RaceValue raceValue) {

		// 日付を文字列として取り出す
		LocalDateTime day = raceValue.getDate().atStartOfDay();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
		String dateValue = format.format(day);

		//DBからレースコードを取得する
		String sql = "CALL GET_KAISAI_CODE(?,?)";
		try(Connection con = DriverManager.getConnection("jdbc:mysql://192.168.10.60:3306/srun_project?autoReconnect=true&useSSL=false", "root", "kent6839");
			PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, raceValue.getKeibajo());
			pstmt.setString(2, dateValue);
			ResultSet rs = pstmt.executeQuery();
			rs.absolute(1);
			this.raceCode = rs.getString(1) + String.format("%02d", raceValue.getRaceBango());

		}catch(SQLException e) {
			System.out.println("レースコードが見つかりませんでした。");
		}
	}

	/**
	 * レースコードを返します
	 * @return レースコード
	 */
	public String getRaceCode() {
		return raceCode;
	}

	/**
	 * レースコード文字列を返します
	 */
	@Override
	public String toString() {
		return raceCode;
	}

}

class RaceValue{
	private LocalDate date;
	private String keibajo;
	private int raceBango;

	public RaceValue(LocalDate date , String keibajo , int raceBango) {
		this.date = date;
		this.keibajo = keibajo;
		this.raceBango = raceBango;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getKeibajo() {
		return keibajo;
	}

	public int getRaceBango() {
		return raceBango;
	}
}
