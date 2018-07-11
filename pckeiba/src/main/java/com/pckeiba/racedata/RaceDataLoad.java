package com.pckeiba.racedata;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*************************************************************************************************************
 *************************************************************************************************************
 * !! データベースから取り出すデータに変更があった場合は、必ずこのクラスにも変更を反映してください。
 * !! 変更が反映されていない場合、正しいデータの取得することが出来ません
 * !! データベースのカラムを列番号で指定しているため、間違いの無いようにしてください
 * !! データベースのストアドプロシージャ<<RACE_SHOSAI>>と整合性を保ってください。
 *************************************************************************************************************
 *************************************************************************************************************/


/**
 * データベースからレースの詳細データを取り出します<br>
 * 引数にレースコードを指定してください
 * @author ken
 *
 */
public class RaceDataLoad {
	private final String sql = "CALL RACE_SHOSAI(?)";
	private RaceDataSet rds;

	/**
	 * コンストラクタ
	 * データベースからレース詳細データを取得します
	 * @param raceCode レースコード
	 */
	public RaceDataLoad(String raceCode) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("MySQLのドライバが見つかりません");
			e1.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection("jdbc:mysql://192.168.10.60:3306/srun_project?autoReconnect=true&useSSL=false", "root", "kent6839");
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, raceCode);
			ResultSet rs = pstmt.executeQuery();
			rs.absolute(1);
			List<BigDecimal> lapTime = new ArrayList<>();
			for(int i = 28;i < 53; i++) {
				lapTime.add(rs.getBigDecimal(i));
			}
			List<String> kakuTsukaJuni = new ArrayList<>();
			for(int i = 65; i < 69; i++) {
				kakuTsukaJuni.add(rs.getString(i));
			}
			rds = new RaceDataSet(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),
					rs.getInt(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),
					rs.getInt(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),
					rs.getString(18),rs.getInt(19),rs.getString(20),rs.getString(21),rs.getInt(22),rs.getInt(23),
					rs.getInt(24),rs.getString(25),rs.getString(26),rs.getString(27),lapTime.toArray(new BigDecimal[lapTime.size()]),rs.getBigDecimal(53),
					rs.getBigDecimal(54),rs.getBigDecimal(55),rs.getBigDecimal(56),rs.getInt(57),rs.getInt(58),rs.getInt(59),
					rs.getInt(60),rs.getInt(61),rs.getInt(62),rs.getInt(63),rs.getInt(64),kakuTsukaJuni.toArray(new String[kakuTsukaJuni.size()]));
		}catch(SQLException e) {
			System.out.println("データベースへの接続が確立できませんでした");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * レース詳細データのオブジェクトを返します
	 * @return レースデータセットのオブジェクト
	 */
	public RaceDataSet getRaceDataSet() {
		return rds;
	}
}