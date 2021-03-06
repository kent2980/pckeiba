package com.pckeiba.umagoto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 出馬表の馬毎Drunを表すオブジェクト<br>
 * このクラスから生成したインスタンスは直列化されます
 * @author KentaroYoshida
 *
 */
public class UmagotoDrunSet implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private final String kaisaiNenGappi;
	private final String raceCode;
	private final String kyosomei;
	private final int wakuban;
	private final int umaban;
	private final String bamei;
	private final String kettoTorokuBango;
	private final double futanJuryo;
	private final BigDecimal drun;
	private final int drunRunk;
	private final int kakuteiChakujun;
	private final double bunsan;
	private final int barei;
	private final int kyori;
	private final BigDecimal Srun_1sou;
	private final BigDecimal Srun_2sou;
	private final BigDecimal Srun_3sou;
	private final BigDecimal Srun_4sou;

	/**
	 *
	 * @param kaisaiNenGappi 開催年月日
	 * @param raceCode レースコード
	 * @param kyosomei 競争名
	 * @param wakuban 枠番
	 * @param umaban 馬番
	 * @param bamei 馬名
	 * @param kettoTorokuBango 血統登録番号
	 * @param futanJuryo 斤量
	 * @param drun Drun
	 * @param drunRunk Drun順位
	 * @param kakuteiChakujun 確定着順
	 * @param bunsan Srunの分散値
	 * @param barei 馬齢
	 * @param kyori 距離
	 * @param srun_1sou １走前のSRun
	 * @param srun_2sou 2走前のSRun
	 * @param srun_3sou 3走前のSRun
	 * @param srun_4sou 4走前のSRun
	 */
	public UmagotoDrunSet(String kaisaiNenGappi, String raceCode, String kyosomei, int wakuban, int umaban,
			String bamei, String kettoTorokuBango, double futanJuryo,  BigDecimal drun, int drunRunk, int kakuteiChakujun, double bunsan,
			int barei, int kyori, BigDecimal srun_1sou, BigDecimal srun_2sou, BigDecimal srun_3sou, BigDecimal srun_4sou) {
		super();
		this.kaisaiNenGappi = kaisaiNenGappi;
		this.raceCode = raceCode;
		this.kyosomei = kyosomei;
		this.wakuban = wakuban;
		this.umaban = umaban;
		this.bamei = bamei;
		this.kettoTorokuBango = kettoTorokuBango;
		this.futanJuryo = futanJuryo;
		this.drun = drun;
		this.drunRunk = drunRunk;
		this.kakuteiChakujun = kakuteiChakujun;
		this.bunsan = bunsan;
		this.barei = barei;
		this.kyori = kyori;
		this.Srun_1sou = srun_1sou;
		this.Srun_2sou = srun_2sou;
		this.Srun_3sou = srun_3sou;
		this.Srun_4sou = srun_4sou;
	}

	/**
	 * @return srun_1sou １走前のSRunを返します
	 */
	public BigDecimal getSrun_1sou() {
		return Srun_1sou;
	}

	/**
	 * @return srun_2sou 2走前のSRunを返します
	 */
	public BigDecimal getSrun_2sou() {
		return Srun_2sou;
	}

	/**
	 * @return srun_3sou 3走前のSRunを返します
	 */
	public BigDecimal getSrun_3sou() {
		return Srun_3sou;
	}

	/**
	 * @return srun_4sou 4走前のSRunを返します
	 */
	public BigDecimal getSrun_4sou() {
		return Srun_4sou;
	}

	/**
	 * 直列化クラスのシリアルバージョンを返します。
	 * @return シリアルバージョン Not Null
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 開催年月日を返します
	 * @return 開催年月日
	 */
	public String getKaisaiNenGappi() {
		return kaisaiNenGappi;
	}

	/**
	 * レースコードを返します
	 * @return レースコード
	 */
	public String getRaceCode() {
		return raceCode;
	}

	/**
	 * 競争名を返します
	 * @return 競争名
	 */
	public String getKyosomei() {
		return kyosomei;
	}

	/**
	 * 枠番を返します
	 * @return 枠番
	 */
	public int getWakuban() {
		return wakuban;
	}

	/**
	 * 馬番を返します
	 * @return 馬番
	 */
	public int getUmaban() {
		return umaban;
	}

	/**
	 * 馬名を返します
	 * @return 馬名
	 */
	public String getBamei() {
		return bamei;
	}

	/**
	 * 血統登録番号を返します
	 * @return 血統登録番号
	 */
	public String getKettoTorokuBango() {
		return kettoTorokuBango;
	}

	/**
	 * 斤量を返します
	 * @return 斤量
	 */
	public double getFutanJuryo() {
		return futanJuryo;
	}

	/**
	 * Drunを返します
	 * @return Drun
	 */
	public BigDecimal getDrun() {
		return drun;
	}

	/**
	 * Drun順位を返します
	 * @return Drun順位
	 */
	public int getDrunRunk() {
		return drunRunk;
	}

	/**
	 * 確定着順を返します
	 * @return 確定着順
	 */
	public int getKakuteiChakujun() {
		return kakuteiChakujun;
	}

	/**
	 * Srunの分散値を返します
	 * @return Srunの分散値
	 */
	public double getBunsan() {
		return bunsan;
	}

	/**
	 * 馬齢を返します
	 * @return 馬齢
	 */
	public int getBarei() {
		return barei;
	}

	/**
	 * 距離を返します
	 * @return 距離
	 */
	public int getKyori() {
		return kyori;
	}

}
