package com.pckeiba.schedule;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.pckeiba.racedata.RaceDataSet;
import com.util.DateTimeFormat;

/**
 * 指定された日付のレースを検索するクラス
 * @author KentaroYoshida
 *
 */
public class RaceListLoad implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private final String sql = "CALL RACE_SHOSAI_FROM_DATE(?)";
	private List<RaceDataSet> raceList;
	private LocalDate date;

	/**
	 * コンストラクタ
	 */
	public RaceListLoad(){}

	/**
	 * コンストラクタ
	 * @param date 日付
	 */
	public RaceListLoad(LocalDate date) {
		this.date = date;
		setRaceList(date);
	}

	/**
	 * 日付を指定します。
	 * @param date 日付
	 */
	public void setDate(LocalDate date) {
		this.date = date;
		setRaceList(date);
	}

	/**
	 * 指定された日付を返します。
	 * @return 日付
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * 指定された日付のレースリストを検索します。
	 * @param date
	 */
	private void setRaceList(LocalDate date) {
		raceList = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		String kaisai = DateTimeFormat.getDateTimeValue("yyyy-MM-dd HH:mm:ss", date);

		try (Connection con = DriverManager.getConnection("jdbc:mysql://192.168.10.60:3306/srun_project?autoReconnect=true&useSSL=false", "root", "kent6839");
			PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, kaisai);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				List<BigDecimal> lapTime = new ArrayList<>();
				for(int i = 28;i < 53; i++) {
					lapTime.add(rs.getBigDecimal(i));
				}
				List<String> kakuTsukaJuni = new ArrayList<>();
				for(int i = 65; i < 69; i++) {
					kakuTsukaJuni.add(rs.getString(i));
				}
				raceList.add(new RaceDataSet(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),
						rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),
						rs.getInt(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),
						rs.getString(18),rs.getInt(19),rs.getString(20),rs.getString(21),rs.getInt(22),rs.getInt(23),
						rs.getInt(24),rs.getString(25),rs.getString(26),rs.getString(27),lapTime.toArray(new BigDecimal[lapTime.size()]),rs.getBigDecimal(53),
						rs.getBigDecimal(54),rs.getBigDecimal(55),rs.getBigDecimal(56),rs.getInt(57),rs.getInt(58),rs.getInt(59),
						rs.getInt(60),rs.getInt(61),rs.getInt(62),rs.getInt(63),rs.getInt(64),kakuTsukaJuni.toArray(new String[kakuTsukaJuni.size()])));
			}

		}catch(SQLException e) {
			System.out.println("レースデータが見つかりませんでした。");
			e.printStackTrace();
		}
	}

	/**
	 * レースリストを返します。
	 * @return
	 */
	public List<RaceDataSet> getRaceList(){
		return raceList;
	}
}
