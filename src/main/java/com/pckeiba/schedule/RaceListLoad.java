package com.pckeiba.schedule;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.pckeiba.racedata.RaceDataDefault;
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

	private LocalDate date;
	private List<RaceDataDefault> raceList;
	private final String sql = "CALL RACE_SHOSAI_FROM_DATE(?)";

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
		String kaisai = DateTimeFormat.getDateTimeValue("yyyy-MM-dd HH:mm:ss", date);
		setRaceList(kaisai);
	}

	/**
	 * コンストラクタ
	 * @param String 日付(yyyyMMDD)
	 */
	public RaceListLoad(String kaisai) {
		setRaceList(kaisai);
	}

	/**
	 * 指定された日付を返します。
	 * @return 日付
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * 開催中の競馬場の数を返します。
	 * @return 開催場所の数
	 */
	public int getKeibajoCount() {
		return (int) raceList.stream()
							 .map(s -> s.getKeibajo())
							 .distinct()
							 .count();
	}

	/**
	 * 開催中の競馬場名のリストを返します。
	 * @return 競馬場名のリスト
	 */
	public List<String> getKeibajoList(){
		return raceList.stream()
				       .map(s -> s.getKeibajo())
				       .distinct()
				       .collect(Collectors.toList());
	}

	/**
	 * レースリストを返します。
	 * @return レースリスト
	 */
	public List<RaceDataDefault> getRaceList(){
		return raceList.stream()
					   .collect(Collectors.toList());
	}

	/**
	 * 指定された競馬場のレースリストを返します
	 * @param keibajo 競馬場
	 * @return 指定した競馬場のレースリスト
	 */
	public List<RaceDataDefault> getRaceList(String keibajo){
		return raceList.stream()
				       .filter(s -> s.getKeibajo().equals(keibajo))
				       .collect(Collectors.toList());
	}

	/**
	 * 日付を指定します。
	 * @param date 日付
	 */
	public void setDate(LocalDate date) {
		this.date = date;
		String kaisai = DateTimeFormat.getDateTimeValue("yyyy-MM-dd HH:mm:ss", date);
		setRaceList(kaisai);
	}

	/**
	 * 日付を指定します。
	 * @param String 日付(yyyyMMDD)
	 */
	public void setDate(String kaisai) {
		setRaceList(kaisai);
	}

	/**
	 * 指定された日付のレースリストを検索します。
	 * @param date
	 */
	private void setRaceList(String kaisai) {
		raceList = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/srun_project?autoReconnect=true&useSSL=false", "root", "kent6839");
			PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, kaisai);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				List<BigDecimal> lapTime = new ArrayList<>();
				for(int i = 1; i <= 25; i++) {
					lapTime.add(rs.getBigDecimal("LAP_TIME" + i));
				}
				List<String> kakuTsukaJuni = new ArrayList<>();
				for(int i = 1; i <= 4; i++) {
					kakuTsukaJuni.add(rs.getString("KAKU_TSUKA_JUNI" + i));
				}
				raceList.add(new RaceDataDefault(rs.getString("DATA_KUBUN"),rs.getString("RACE_CODE"),rs.getString("KAISAI_NENGAPPI"),rs.getInt("KAISAI_KAIJI"),
						rs.getInt("KAISAI_NICHIJI"),rs.getInt("RACE_BANGO"),rs.getString("KEIBAJO"),rs.getString("YOBI"),rs.getInt("JUSHO_KAIJI"),rs.getString("KYOSOMEI_HONDAI"),rs.getString("KYOSOMEI_FUKUDAI"),rs.getString("KYOSOMEI_RYAKUSHO_10"),
						rs.getInt("KYOSOMEI_KUBUN"),rs.getString("GRADE"),rs.getString("KYOSO_SHUBETSU"),rs.getString("KYOSO_KIGO"),rs.getString("JURYO_SHUBETSU"),
						rs.getString("KYOSO_JOKEN"),rs.getInt("KYORI"),rs.getString("TRACK_CODE"),rs.getString("HASSO_JIKOKU"),rs.getInt("TOROKU_TOSU"),rs.getInt("SHUSSO_TOSU"),
						rs.getInt("NYUSEN_TOSU"),rs.getString("TENKO"),rs.getString("SHIBA_JOTAI"),rs.getString("DIRT_BABAJOTAI"),lapTime.toArray(new BigDecimal[lapTime.size()]),rs.getBigDecimal("ZENHAN_3F"),
						rs.getBigDecimal("ZENHAN_4F"),rs.getBigDecimal("KOHAN_3F"),rs.getBigDecimal("KOHAN_4F"),rs.getInt("CORNER1"),rs.getInt("CORNER2"),rs.getInt("CORNER3"),
						rs.getInt("CORNER4"),rs.getInt("SHUKAISU1"),rs.getInt("SHUKAISU2"),rs.getInt("SHUKAISU3"),rs.getInt("SHUKAISU4"),kakuTsukaJuni.toArray(new String[kakuTsukaJuni.size()]),rs.getInt("KEIBAJO_CODE")));
			}

		}catch(SQLException e) {
			System.out.println("レースデータが見つかりませんでした。");
			e.printStackTrace();
		}
	}
}
