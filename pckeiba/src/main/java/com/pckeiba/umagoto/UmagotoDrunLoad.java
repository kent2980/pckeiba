package com.pckeiba.umagoto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 馬毎のDrunを生成するためのクラス<br>
 * Drunとは競走馬固有の能力値です
 * @author kent2
 *
 */
public class UmagotoDrunLoad implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String raceCode;
	private Map<String,UmagotoDrunSet> drunList;
	private Map<String,BigDecimal> drunMap;
	private List<UmagotoDrunSet> drunSortList;

	/**
	 * コンストラクタ<br>
	 * nullなオブジェクトを生成します
	 */
	public UmagotoDrunLoad() {}

	/**
	 * 指定されたレース出馬表からDrunを取り出します<br>
	 * 引数にレースコードを指定します
	 * @param raceCode レースコード
	 */
	public UmagotoDrunLoad(String raceCode) {
		this.raceCode = raceCode;
		setDrunList(raceCode);
	}

	/**
	 * 指定されているレースコードを返します
	 * @return レースコード
	 */
	public String getRaceCode() {
		return raceCode;
	}

	/**
	 * レースコードを再指定します
	 * @param raceCode レースコード
	 */
	public void setRaceCode(String raceCode) {
		this.raceCode = raceCode;
		setDrunList(raceCode);
	}

	/**
	 * 指定されたレース出馬表からDrunリストオブジェクトを生成します
	 * @param raceCode レースコード
	 */
	public void setDrunList(String raceCode) {
		drunMap = new HashMap<>();
		drunList = new HashMap<>();
		drunSortList = new ArrayList<>();
		String sql = "CALL Drun_Out(?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try(Connection con = DriverManager.getConnection("jdbc:mysql://192.168.10.60:3306/srun_project?autoReconnect=true&useSSL=false", "root", "kent6839");
			PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, raceCode);
			ResultSet rs = pstmt.executeQuery();
			int t = 18; //Drun_Outテーブルの列数を指定します
			while(rs.next()) {
				UmagotoDrunSet umagotoData = new UmagotoDrunSet(rs.getString("KAISAI_NENGAPPI"), rs.getString("RACE_CODE"), rs.getString("KYOSOMEI"), rs.getInt("WAKUBAN"),
											 					rs.getInt("UMABAN"), rs.getString("BAMEI"), rs.getString("KETTO_TOROKU_BANGO"), rs.getDouble("FUTAN_JURYO"),
											 					rs.getBigDecimal("DRUN"),rs.getInt("順位"), rs.getInt("KAKUTEI_CHAKUJUN"), rs.getDouble("BUNSAN"),
											 					rs.getInt("BAREI"), rs.getInt("KYORI"), rs.getBigDecimal("1SOU"), rs.getBigDecimal("2SOU"), rs.getBigDecimal("3SOU"), rs.getBigDecimal("4SOU"));
				drunList.put(rs.getString(7),umagotoData);
				drunMap.put(rs.getString(7), rs.getBigDecimal(t-2));
				drunSortList.add(umagotoData);
			}


		}catch(SQLException e) {

		}
	}

	/**
	 * 血統登録番号をキーにしたDrunリストオブジェクトを返します
	 * @return Drunリストオブジェクト
	 */
	public Map<String,UmagotoDrunSet> getDrunList(){
		return drunList;
	}

	/**
	 * 血統登録番号をキーにしたDrunマップオブジェクトを返します
	 * @return Drunマップオブジェクト
	 */
	public Map<String,BigDecimal> getDrunMap(){
		return drunMap;
	}

	public List<UmagotoDrunSet> getDrunSortList() {
		return drunSortList;
	}

	public void setDrunSortList(List<UmagotoDrunSet> drunSortList) {
		this.drunSortList = drunSortList;
	}

}
