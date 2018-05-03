package com.pckeiba.racecode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.pckeiba.sql.MyDBConnection;

public class RaceCodeSet {
	private String raceCode;
	private RaceValue raceValue;

	public RaceCodeSet(LocalDate date , String keibajo , int raceBango) {
		this.raceValue = new RaceValue(date, keibajo, raceBango);
		setRaceCode(raceValue);
	}

	public void setRaceValue(LocalDate date , String keibajo , int raceBango) {
		this.raceValue = new RaceValue(date, keibajo, raceBango);
		setRaceCode(raceValue);
	}

	private void setRaceCode(RaceValue raceValue) {

		// 日付を文字列として取り出す
		LocalDateTime day = raceValue.getDate().atStartOfDay();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
		String dateValue = format.format(day);

		//DBからレースコードを取得する
		String sql = "CALL GET_KAISAI_CODE(?,?)";
		Connection con = MyDBConnection.getInstanse().getConnection();
		try(PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, raceValue.getKeibajo());
			pstmt.setString(2, dateValue);
			ResultSet rs = pstmt.executeQuery();
			rs.absolute(1);
			this.raceCode = rs.getString(1) + String.format("%02d", raceValue.getRaceBango());

		}catch(SQLException e) {
			System.out.println("レースコードが見つかりませんでした。");
		}
	}

	public String getRaceCode() {
		return raceCode;
	}

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
