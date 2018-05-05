package com.pckeiba.umagoto;

import java.io.Serializable;
import java.math.BigDecimal;

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

	public UmagotoDrunSet(String kaisaiNenGappi, String raceCode, String kyosomei, int wakuban, int umaban,
			String bamei, String kettoTorokuBango, double futanJuryo,  BigDecimal drun, int drunRunk, int kakuteiChakujun) {
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
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getKaisaiNenGappi() {
		return kaisaiNenGappi;
	}

	public String getRaceCode() {
		return raceCode;
	}

	public String getKyosomei() {
		return kyosomei;
	}

	public int getWakuban() {
		return wakuban;
	}

	public int getUmaban() {
		return umaban;
	}

	public String getBamei() {
		return bamei;
	}

	public String getKettoTorokuBango() {
		return kettoTorokuBango;
	}

	public double getFutanJuryo() {
		return futanJuryo;
	}

	public BigDecimal getDrun() {
		return drun;
	}

	public int getDrunRunk() {
		return drunRunk;
	}

	public int getKakuteiChakujun() {
		return kakuteiChakujun;
	}

}
