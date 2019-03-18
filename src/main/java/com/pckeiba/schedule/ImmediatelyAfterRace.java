package com.pckeiba.schedule;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.util.DateTimeFormat;

/**
 * 最も近いレース開催日を検索するクラス
 * @author KentaroYoshida
 *
 */
public class ImmediatelyAfterRace implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private LocalDate date;
	private LocalDate kaisaiNenGappi;
	private LocalDate nextKaisaiNenGappi;
	private final String sql = "CALL IMMEDIATELY＿AFTER＿RACE(?)";

	/**
	 * コンストラクタ
	 */
	public ImmediatelyAfterRace() {}

	/**
	 * コンストラクタ<br>
	 * 引数に日付を指定してください
	 * @param date 日付
	 */
	public ImmediatelyAfterRace(LocalDate date) {
		this.date = date;
		setKaisaiNenGappi(date);
	}

	/**
	 * 日付を設定します。
	 * @param date 日付
	 */
	public void setDate(LocalDate date) {
		this.date = date;
		setKaisaiNenGappi(date);
	}

	/**
	 * 現在設定されている日付を返します
	 * @return 日付
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * 開催年月日を検索します。
	 * @param date 日付
	 */
	private void setKaisaiNenGappi(LocalDate date) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		String day = DateTimeFormat.getDateTimeValue("yyyy-MM-dd HH:mm:ss", date);
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/srun_project?autoReconnect=true&useSSL=false", "root", "kent6839");
			PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, day);
			ResultSet rs = pstmt.executeQuery();
			rs.absolute(1);
			kaisaiNenGappi = rs.getDate(1).toLocalDate();
			rs.absolute(2);
			nextKaisaiNenGappi = rs.getDate(1).toLocalDate();

		}catch(SQLException e) {
			System.out.println("データベースに接続できません");
			e.printStackTrace();
		}

	}

	/**
	 * 最も近い開催年月日を返します。
	 * @return 最も近いの開催年月日
	 */
	public LocalDate getKaisaiNenGappi() {
		return kaisaiNenGappi;
	}

	/**
	 * 次の開催年月日を返します。
	 * @return 次の開催年月日
	 */
	public LocalDate getNextKaisaiNenGappi() {
		return nextKaisaiNenGappi;
	}
}
