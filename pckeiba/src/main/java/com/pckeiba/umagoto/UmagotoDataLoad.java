package com.pckeiba.umagoto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * データベースから出馬表の詳細データを取り出します<br>
 * 引数にレースコードを指定してください
 * @author KentaroYoshida
 *
 */
public class UmagotoDataLoad {
	private final String sql = "CALL UMAGOTO_DATA(?,?)";
	private final List<UmagotoDataSet> list;
	private final String raceCode;

	/**
	 * コンストラクタ<br>
	 * データベースから出馬表の詳細データを取得します
	 * @param raceCode レースコード
	 * @param hit 過去レース数
	 */
	public UmagotoDataLoad(String raceCode, int hit) {
		this.raceCode = raceCode;
		list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("DBのドライバが見つかりません");
			e1.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection("jdbc:mysql://192.168.10.60:3306/srun_project?autoReconnect=true&useSSL=false", "root", "kent6839");
			PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, raceCode);
			pstmt.setInt(2, hit);
			ResultSet rs = pstmt.executeQuery();
			int i = 77;	//ストアドプロシージャ'UMAGOTO_DATA'のumaIDの列番号を指定します
			while(rs.next()) {
				list.add(new UmagotoDataSet(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),
						rs.getInt(11),rs.getString(12),rs.getString(13),rs.getInt(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),
						rs.getDouble(21),rs.getInt(22),rs.getString(23),rs.getString(24),rs.getString(25),rs.getInt(26),rs.getString(27),rs.getString(28),rs.getInt(29),rs.getInt(30),
						rs.getBigDecimal(31),rs.getInt(32),rs.getInt(33),rs.getInt(34),rs.getInt(35),rs.getDouble(36),rs.getInt(37),rs.getBigDecimal(38),rs.getBigDecimal(39),rs.getDouble(40),
						rs.getString(41),rs.getString(42),rs.getString(43),rs.getString(44),rs.getString(45),rs.getString(46),rs.getString(47),rs.getString(48),rs.getString(49),rs.getString(50),
						rs.getString(51),rs.getString(52),rs.getString(53),rs.getInt(54),rs.getInt(55),rs.getInt(56),rs.getString(57),rs.getBigDecimal(58),rs.getString(59),rs.getString(60),
						rs.getString(61), rs.getString(62), rs.getString(63), rs.getInt(64), rs.getInt(65), rs.getInt(i), rs.getInt(i+1), rs.getBigDecimal(66), rs.getBigDecimal(67), rs.getBigDecimal(68),
						rs.getBigDecimal(69), rs.getBigDecimal(70), rs.getBigDecimal(71), rs.getString(72), rs.getBigDecimal(73), rs.getBigDecimal(74), rs.getBigDecimal(75), rs.getInt(76)));
			}

		}catch(SQLException e) {
			System.out.println("データベース接続が確立できません");
			e.printStackTrace();
		}
	}

	/**
	 * 出馬表の詳細データのオブジェクトを返します
	 * @return 出馬表の詳細データのオブジェクト
	 */
	public List<UmagotoDataSet> getList() {
		return list;
	}

	/**
	 * 馬番と紐づいた出馬表の詳細データのオブジェクトを返します
	 * @param UmaID レース指定ID（前走を1とします）
	 * @return 出馬表の詳細データのオブジェクト
	 */
	public Map<Integer,UmagotoDataSet> getMap(int UmaID){
		Map<Integer,UmagotoDataSet> map = new HashMap<>();
		List<UmagotoDataSet> l = list.stream().filter(s -> s.getUmaID()==UmaID).collect(Collectors.toList());
		for(UmagotoDataSet uma : l) {
			map.put(uma.getUmaGroup(), uma);
		}
		return map;
	}

	/**
	 * 血統登録番号と紐づいた出馬表の詳細データのオブジェクトを返します
	 * @param UmaID レース指定ID（前走を1とします）
	 * @return 出馬表の詳細データのオブジェクト
	 */
	public Map<String,UmagotoDataSet> getMapFromKettoTorokuBango(int UmaID){
		Map<String,UmagotoDataSet> map = new HashMap<>();
		List<UmagotoDataSet> l = list.stream().filter(s -> s.getUmaID()==UmaID).collect(Collectors.toList());
		for(UmagotoDataSet uma : l) {
			map.put(uma.getKettoTorokuBango(), uma);
		}
		return map;
	}

	/** 今走のレースコードを返します
	 * @return raceCode
	 */
	public String getRaceCode() {
		return raceCode;
	}

}
