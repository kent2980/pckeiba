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
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/srun_project?autoReconnect=true&useSSL=false", "root", "kent6839");
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, raceCode);
			ResultSet rs = pstmt.executeQuery();
			rs.absolute(1);
			List<BigDecimal> lapTime = new ArrayList<>();
			for(int i = 1;i <= 25; i++) {
				lapTime.add(rs.getBigDecimal("LAP_TIME" + i));
			}
			List<String> kakuTsukaJuni = new ArrayList<>();
			for(int i = 1; i <= 4; i++) {
				kakuTsukaJuni.add(rs.getString("KAKU_TSUKA_JUNI" + i));
			}
			rds = new RaceDataSet(rs.getString("DATA_KUBUN"),rs.getString("RACE_CODE"),rs.getString("KAISAI_NENGAPPI"),rs.getInt("KAISAI_KAIJI"),
					rs.getInt("KAISAI_NICHIJI"),rs.getInt("RACE_BANGO"),rs.getString("KEIBAJO"),rs.getString("YOBI"),rs.getInt("JUSHO_KAIJI"),rs.getString("KYOSOMEI_HONDAI"),rs.getString("KYOSOMEI_FUKUDAI"),rs.getString("KYOSOMEI_RYAKUSHO_10"),
					rs.getInt("KYOSOMEI_KUBUN"),rs.getString("GRADE"),rs.getString("KYOSO_SHUBETSU"),rs.getString("KYOSO_KIGO"),rs.getString("JURYO_SHUBETSU"),
					rs.getString("KYOSO_JOKEN"),rs.getInt("KYORI"),rs.getString("TRACK_CODE"),rs.getString("HASSO_JIKOKU"),rs.getInt("TOROKU_TOSU"),rs.getInt("SHUSSO_TOSU"),
					rs.getInt("NYUSEN_TOSU"),rs.getString("TENKO"),rs.getString("SHIBA_JOTAI"),rs.getString("DIRT_BABAJOTAI"),lapTime.toArray(new BigDecimal[lapTime.size()]),rs.getBigDecimal("ZENHAN_3F"),
					rs.getBigDecimal("ZENHAN_4F"),rs.getBigDecimal("KOHAN_3F"),rs.getBigDecimal("KOHAN_4F"),rs.getInt("CORNER1"),rs.getInt("CORNER2"),rs.getInt("CORNER3"),
					rs.getInt("CORNER4"),rs.getInt("SHUKAISU1"),rs.getInt("SHUKAISU2"),rs.getInt("SHUKAISU3"),rs.getInt("SHUKAISU4"),kakuTsukaJuni.toArray(new String[kakuTsukaJuni.size()]), rs.getInt("KEIBAJO_CODE"),
					rs.getBigDecimal("RPCI"), rs.getBigDecimal("AVE3F"), rs.getBigDecimal("SRun_row"), rs.getBigDecimal("SRun_55"),rs.getString("Winning_Horse"),rs.getString("TOKUBETSU_KYOSO_BANGO"));
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