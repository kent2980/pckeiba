package com.pckeiba.umagoto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * MYSQLクエリを実行して馬毎データ指数リストを生成します
 * @author kent2
 *
 */
public class UmagotoDataIndexLoad implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final String sql = "CALL UMAGOTO_DATA_KAKO_INDEX(?, ?)";
	private final List<UmagotoDataIndexSet> indexList;

	/**
	 * @param レースコード
	 * @param 対象レース数
	 */
	public UmagotoDataIndexLoad(String raceCode, int hit) {
		indexList = new ArrayList<>();

		/************************************************
		 ************************************************
		 **********							*************
		 **********　ここからデータベース読み込みを	*************
		 **********　開始していきます。('ω')ノ		*************
		 **********							*************
		 ************************************************
		 ************************************************
		 */

		/**************************************
		 ******* MYSQLのJDBCドライバを読み込みます
		 **************************************/
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりませんでした");
			e.getStackTrace();
		}

		/**************************************
		 ******* MYSQLのクエリを実行していきます
		 **************************************/
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/srun_project?autoReconnect=true&useSSL=false", "root", "kent6839");
				PreparedStatement pstmt = con.prepareStatement(sql)){

			//レースコード,対象レース数をSQLに代入します
			pstmt.setString(1, raceCode);
			pstmt.setInt(2, hit);
			//クエリを実行して結果セットを取得します
			ResultSet rs = pstmt.executeQuery();
			//結果セットをUmagotoDataIndexSetに代入してリストに追加します
			while(rs.next()) {
				UmagotoDataIndexSet dataSet = new UmagotoDataIndexSet(rs.getInt("UMABAN"), rs.getString("BAMEI"), rs.getInt("TANSHO_NINKIJUN"),rs.getString("KETTO_TOROKU_BANGO"), rs.getInt("KYAKUSHITSU"), rs.getBigDecimal("DRUN"), rs.getInt("AVERAGE_KYORI"), rs.getInt("MAX_KYORI"), rs.getBigDecimal("ZENHAN_3F"), rs.getBigDecimal("RPCI"), rs.getBigDecimal("FPCI"), rs.getBigDecimal("RATE"), rs.getInt("KAKUTEI_CHAKUJUN"));
				indexList.add(dataSet);
			}

		}catch(SQLException e) {
			System.out.println("データベースに接続できませんでした");
			e.getStackTrace();
		}
	}

	/**
	 * 指定したレースのインデックスリストを返します
	 * @return インデックスリスト
	 */
	public List<UmagotoDataIndexSet> getIndexList() {
		return indexList;
	}

	public int getAverageKyori(String kettoTorokuBango) {
		int kyori;
		try {
			kyori = indexList.stream()
								 .filter(s -> s.getKettoTorokuBango().equals(kettoTorokuBango))
								 .mapToInt(s -> s.getAverageKyori())
								 .findFirst()
								 .getAsInt();
		}catch(NoSuchElementException e) {
			kyori = 0;
		}
		return kyori;
	}
	/**********************************************************
	 ************								***************
	 ************  ここから分析用のメソッドを記述します	***************
	 ************  Let's Go (^^)/				***************
	 ************								***************
	 ******************************************************************************/

	/******** 各種平均値を求めます(*‘ω‘ *) **********/

	/**
	 * テン3Fの平均値を算出します
	 * @return 平均テン3F
	 */
	public BigDecimal getAverageZenhan3f() {
		//リストから平均値を求めます
		double average3f = indexList.stream()
									.mapToDouble(s -> s.getZenhan3f().doubleValue())
									.average()
									.getAsDouble();
		//doubleからBigDecimalに変換して丸め処理を行います
		return BigDecimal.valueOf(average3f).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * DRun<タイムランク>の平均値を算出します
	 * @return 平均DRun<タイムランク>
	 */
	public BigDecimal getAverageDrun() {
		//リストから平均値を求めます
		double average3f = indexList.stream()
									.mapToDouble(s -> s.getDrun().doubleValue())
									.average()
									.getAsDouble();
		//doubleからBigDecimalに変換して丸め処理を行います
		return BigDecimal.valueOf(average3f).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * RPCIの平均値を算出します
	 * @return 平均RPCI
	 */
	public BigDecimal getAverageRPCI() {
		//リストから平均値を求めます
		double average3f = indexList.stream()
									.mapToDouble(s -> s.getRPCI().doubleValue())
									.average()
									.getAsDouble();
		//doubleからBigDecimalに変換して丸め処理を行います
		return BigDecimal.valueOf(average3f).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * FPCIの平均値を算出します
	 * @return 平均FPCI
	 */
	public BigDecimal getAverageFPCI() {
		//リストから平均値を求めます
		double average3f = indexList.stream()
									.mapToDouble(s -> s.getFPCI().doubleValue())
									.average()
									.getAsDouble();
		//doubleからBigDecimalに変換して丸め処理を行います
		return BigDecimal.valueOf(average3f).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * RPCIのスピードレートを算出します
	 * @return 平均スピードレート
	 */
	public BigDecimal getAverageSpeedRate() {
		//リストから平均値を求めます
		double average3f = indexList.stream()
									.mapToDouble(s -> s.getSpeedRate().doubleValue())
									.average()
									.getAsDouble();
		//doubleからBigDecimalに変換して丸め処理を行います
		return BigDecimal.valueOf(average3f).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/******** 各種分散値を求めます(*‘ω‘ *) **********/

	/**
	 * テン3Fの分散値を算出します
	 * @return 分散テン3F
	 */
	public BigDecimal getDispersionZenhan3f() {
		BigDecimal average = getAverageZenhan3f();
		//リストから分散値を求めます
		double dispersion = indexList.stream()
										.mapToDouble(s -> s.getZenhan3f().subtract(average).multiply(s.getZenhan3f().subtract(average)).doubleValue())
										.average()
										.getAsDouble();
		//doubleからBigDecimalに変換して丸め処理を行います
		return BigDecimal.valueOf(dispersion).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * DRun<タイムランク>の分散値を算出します
	 * @return 分散DRun<タイムランク>
	 */
	public BigDecimal getDispersionDrun() {
		BigDecimal average = getAverageDrun();
		//リストから分散値を求めます
		double dispersion = indexList.stream()
										.mapToDouble(s -> s.getDrun().subtract(average).multiply(s.getDrun().subtract(average)).doubleValue())
										.average()
										.getAsDouble();
		//doubleからBigDecimalに変換して丸め処理を行います
		return BigDecimal.valueOf(dispersion).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * RPCIの分散値を算出します
	 * @return 分散RPCI
	 */
	public BigDecimal getDispersionRPCI() {
		BigDecimal average = getAverageRPCI();
		//リストから分散値を求めます
		double dispersion = indexList.stream()
										.mapToDouble(s -> s.getRPCI().subtract(average).multiply(s.getRPCI().subtract(average)).doubleValue())
										.average()
										.getAsDouble();
		//doubleからBigDecimalに変換して丸め処理を行います
		return BigDecimal.valueOf(dispersion).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * FPCIの分散値を算出します
	 * @return 分散FPCI
	 */
	public BigDecimal getDispersionFPCI() {
		BigDecimal average = getAverageFPCI();
		//リストから分散値を求めます
		double dispersion = indexList.stream()
										.mapToDouble(s -> s.getFPCI().subtract(average).multiply(s.getFPCI().subtract(average)).doubleValue())
										.average()
										.getAsDouble();
		//doubleからBigDecimalに変換して丸め処理を行います
		return BigDecimal.valueOf(dispersion).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * RPCIのスピードレートを算出します
	 * @return 分散スピードレート
	 */
	public BigDecimal getDispersionSpeedRate() {
		BigDecimal average = getAverageSpeedRate();
		//リストから分散値を求めます
		double dispersion = indexList.stream()
										.mapToDouble(s -> s.getSpeedRate().subtract(average).multiply(s.getSpeedRate().subtract(average)).doubleValue())
										.average()
										.getAsDouble();
		//doubleからBigDecimalに変換して丸め処理を行います
		return BigDecimal.valueOf(dispersion).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/******** 各種最大値/最小値を求めます(*‘ω‘ *) **********/

	/******** < 最大値 > *********/
	/**
	 * DRun<タイムランク>の最大値を求めます
	 * @return DRun<タイムランク>最大値
	 */
	public BigDecimal getMaxDrun() {
		//リスト方最大値を求めます
		double max = indexList.stream()
							  .mapToDouble(s -> s.getDrun().doubleValue())
							  .max().getAsDouble();
		//doubleからBigDecimalに変換します
		return BigDecimal.valueOf(max);
	}

	/**
	 * 前半3Fの最大値を求めます
	 * @return 前半3F最大値
	 */
	public BigDecimal getMaxZenhan3f() {
		//リスト方最大値を求めます
		double max = indexList.stream()
							  .mapToDouble(s -> s.getZenhan3f().doubleValue())
							  .max().getAsDouble();
		//doubleからBigDecimalに変換します
		return BigDecimal.valueOf(max);
	}

	/**
	 * RPCIの最大値を求めます
	 * @return RPCI最大値
	 */
	public BigDecimal getMaxRPCI() {
		//リスト方最大値を求めます
		double max = indexList.stream()
							  .mapToDouble(s -> s.getRPCI().doubleValue())
							  .max().getAsDouble();
		//doubleからBigDecimalに変換します
		return BigDecimal.valueOf(max);
	}

	/**
	 * FPCIの最大値を求めます
	 * @return FPCI最大値
	 */
	public BigDecimal getMaxFPCI() {
		//リスト方最大値を求めます
		double max = indexList.stream()
							  .mapToDouble(s -> s.getFPCI().doubleValue())
							  .max().getAsDouble();
		//doubleからBigDecimalに変換します
		return BigDecimal.valueOf(max);
	}

	/**
	 * スピードレートの最大値を求めます
	 * @return スピードレート最大値
	 */
	public BigDecimal getMaxSpeedRate() {
		//リスト方最大値を求めます
		double max = indexList.stream()
							  .mapToDouble(s -> s.getSpeedRate().doubleValue())
							  .max().getAsDouble();
		//doubleからBigDecimalに変換します
		return BigDecimal.valueOf(max);
	}

	/******** < 最小値 > *********/
	/**
	 * DRun<タイムランク>の最小値を求めます
	 * @return DRun<タイムランク>最小値
	 */
	public BigDecimal getMinDrun() {
		//リスト方最小値を求めます
		double min = indexList.stream()
							  .mapToDouble(s -> s.getDrun().doubleValue())
							  .min().getAsDouble();
		//doubleからBigDecimalに変換します
		return BigDecimal.valueOf(min);
	}

	/**
	 * 前半3Fの最小値を求めます
	 * @return 前半3F最小値
	 */
	public BigDecimal getMinZenhan3f() {
		//リスト方最小値を求めます
		double min = indexList.stream()
							  .mapToDouble(s -> s.getZenhan3f().doubleValue())
							  .min().getAsDouble();
		//doubleからBigDecimalに変換します
		return BigDecimal.valueOf(min);
	}

	/**
	 * RPCIの最小値を求めます
	 * @return RPCI最小値
	 */
	public BigDecimal getMinRPCI() {
		//リスト方最小値を求めます
		double min = indexList.stream()
							  .mapToDouble(s -> s.getRPCI().doubleValue())
							  .min().getAsDouble();
		//doubleからBigDecimalに変換します
		return BigDecimal.valueOf(min);
	}

	/**
	 * FPCIの最小値を求めます
	 * @return FPCI最小値
	 */
	public BigDecimal getMinFPCI() {
		//リスト方最小値を求めます
		double min = indexList.stream()
							  .mapToDouble(s -> s.getFPCI().doubleValue())
							  .min().getAsDouble();
		//doubleからBigDecimalに変換します
		return BigDecimal.valueOf(min);
	}

	/**
	 * スピードレートの最小値を求めます
	 * @return スピードレート最小値
	 */
	public BigDecimal getMinSpeedRate() {
		//リスト方最小値を求めます
		double min = indexList.stream()
							  .mapToDouble(s -> s.getSpeedRate().doubleValue())
							  .min().getAsDouble();
		//doubleからBigDecimalに変換します
		return BigDecimal.valueOf(min);
	}

	/******** フィールド間の比較を行います ***********/

	/**
	 * 指定した順位のタイムランクと一つしたのタイムランクとの間で差を求めます。
	 * 1.5以上の差が生じた際は逆転が難しくなります。
	 * @param runk DRun<タイムランク>の順位
	 * @return 差
	 */
	public BigDecimal getDrunMargin(int runk) {
		BigDecimal drun = indexList.get(runk - 1).getDrun();
		BigDecimal drunRefe = indexList.get(runk).getDrun();
		BigDecimal margin = drun.subtract(drunRefe);
		return margin;
	}

	/******** レース傾向を求めます(*^▽^*) **********/

	public String getRaceConvoy() {
		if(getAverageRPCI().doubleValue() >= 50) {
			return "ショート";
		}else if(getDispersionZenhan3f().doubleValue() > 0.5) {
			return "縦長";
		}else {
			return "ショート";
		}
	}

	public String getRacePace() {
		double RPCI = getAverageRPCI().doubleValue();
		if(RPCI < 48) {
			return "ハイペース";
		}else if(RPCI > 50) {
			return "スローペース";
		}else {
			return "ミドルペース";
		}
	}
}
