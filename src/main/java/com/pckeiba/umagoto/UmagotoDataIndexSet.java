package com.pckeiba.umagoto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 指定されたレースから取得する馬毎の指数セットです。
 * レースコードでレースを指定してデータを取得してください。
 * 出走馬から相対評価を行うことで分析を行います。
 * @author kent
 *
 */
public class UmagotoDataIndexSet implements Serializable,Comparable<UmagotoDataIndexSet> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * フィールド
	 */
	private final int umaban;
	private final String bamei;
	private final int tanshoNinkijun;
	private final String kettoTorokuBango;
	private final int kyakushitsuCode;
	private final String kyakushitsu;
	private final BigDecimal drun;
	private final int averageKyori;
	private final int maxKyori;
	private final BigDecimal zenhan3f;
	private final BigDecimal RPCI;
	private final BigDecimal FPCI;
	private final BigDecimal speedRate;
	private final int kauteiChakujun;

	/**
	 * コンストラクタ
	 * @param umaban 馬番
	 * @param bamei　馬名
	 * @param kettoTorokuBango 血統登録番号
	 * @param kyakushitsuCode　脚質コード
	 * @param kyakushitsu　脚質
	 * @param drun　DRun<タイムランク>
	 * @param averageKyori　平均距離
	 * @param maxKyori　最大距離
	 * @param zenhan3f　前半3F指数
	 * @param rPCI レースチェンジ指数
	 * @param fPCI　上がり3Fチェンジ指数
	 * @param speedRate　スピードレート
	 * @param kauteiChakujun 確定着順
	 */
	public UmagotoDataIndexSet(int umaban, String bamei, int tanshoNinkijun, String kettoTorokuBango, int kyakushitsuCode, BigDecimal drun, int averageKyori,
			int maxKyori, BigDecimal zenhan3f, BigDecimal rPCI, BigDecimal fPCI, BigDecimal speedRate ,int kauteiChakujun) {
		super();
		this.umaban = umaban;
		this.bamei = bamei;
		this.tanshoNinkijun = tanshoNinkijun;
		this.kettoTorokuBango = kettoTorokuBango;
		this.kyakushitsuCode = kyakushitsuCode;
		this.kyakushitsu = setKyakushitsu();
		this.drun = drun;
		this.averageKyori = averageKyori;
		this.maxKyori = maxKyori;
		this.zenhan3f = zenhan3f;
		this.RPCI = rPCI;
		this.FPCI = fPCI;
		this.speedRate = speedRate;
		this.kauteiChakujun = kauteiChakujun;
	}

	/**
	 * 脚質コードから脚質に変換します
	 * @return　脚質
	 */
	private String setKyakushitsu() {

		switch(kyakushitsuCode) {
		case 1:
			return "逃げ";
		case 2:
			return "先行";
		case 3:
			return "差し";
		case 4:
			return "追込";
		default:
			return "不明";
		}
	}

	/**
	 * @return シリアルバージョン
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return 馬名
	 */
	public String getBamei() {
		return bamei;
	}

	/**
	 * @return 脚質コード
	 */
	public int getKyakushitsuCode() {
		return kyakushitsuCode;
	}

	/**
	 * @return 脚質
	 */
	public String getKyakushitsu() {
		return kyakushitsu;
	}

	/**
	 * @return DRun<タイムランク>
	 */
	public BigDecimal getDrun() {
		return drun;
	}

	/**
	 * @return 平均距離
	 */
	public int getAverageKyori() {
		return averageKyori;
	}

	/**
	 * @return 最大距離
	 */
	public int getMaxKyori() {
		return maxKyori;
	}

	/**
	 * @return 前半3F指数
	 */
	public BigDecimal getZenhan3f() {
		return zenhan3f;
	}

	/**
	 * @return レースチェンジ指数
	 */
	public BigDecimal getRPCI() {
		return RPCI;
	}

	/**
	 * @return 上がり3Fチェンジ指数
	 */
	public BigDecimal getFPCI() {
		return FPCI;
	}

	/**
	 * @return スピードレート
	 */
	public BigDecimal getSpeedRate() {
		return speedRate;
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UmagotoDataIndexSet [bamei=" + bamei + ", kyakushitsuCode=" + kyakushitsuCode + ", kyakushitsu="
				+ kyakushitsu + ", drun=" + drun + ", averageKyori=" + averageKyori + ", maxKyori=" + maxKyori
				+ ", zenhan3f=" + zenhan3f + ", RPCI=" + RPCI + ", FPCI=" + FPCI + ", speedRate=" + speedRate + "]";
	}

	/**
	 * @return umaban 馬番
	 */
	public int getUmaban() {
		return umaban;
	}

	/**
	 * @return kettoTorokuBango 血統登録番号
	 */
	public String getKettoTorokuBango() {
		return kettoTorokuBango;
	}

	/**
	 * @return tanshoNinkijun 単勝人気
	 */
	public int getTanshoNinkijun() {
		return tanshoNinkijun;
	}

	/**
	 * @return kauteiChakujun 確定着順
	 */
	public int getKauteiChakujun() {
		return kauteiChakujun;
	}

	@Override
	public int compareTo(UmagotoDataIndexSet o) {
		if(o.getKauteiChakujun() == 0) {
			return -1;
		}else {
			return this.getKauteiChakujun() - o.getKauteiChakujun();
		}
	}
}
