package com.pckeiba.racedata;

import java.io.Serializable;
import java.math.BigDecimal;

import com.util.DateTimeFormat;
import com.util.TrackCodeFormat;

/**
 * レース詳細データを取得するためのクラス
 * @author kent
 *
 */
public class RaceDataSet implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String dataKubun;
	private String raceCode;
	private String kaisaiNenGappi;
	private int kaisaiKaiji;
	private int kaisaiNichiji;
	private int raceBango;
	private String keibajo;
	private String yobi;
	private int Jusho_Kaiji;
	private String kyosomeiHondai;
	private String kyosomeiFukudai;
	private String kyosomeiRyaku10;
	private int kyosomeiKubun;
	private String grade;
	private String kyosoShubetsu;
	private String kyosoKigo;
	private String juryoShubetsu;
	private String kyosoJoken;
	private int kyori;
	private String trackCode;
	private String hassoJikoku;
	private int torokuTosu;
	private int shussoTosu;
	private int nyusenTosu;
	private String tenko;
	private String shibaJotai;
	private String dirtJotai;
	private BigDecimal[] lapTime;
	private BigDecimal zenhan3f;
	private BigDecimal zenhan4f;
	private BigDecimal kohan3f;
	private BigDecimal kohan4f;
	private int coner1;
	private int coner2;
	private int coner3;
	private int coner4;
	private int shukaisu1;
	private int shukaisu2;
	private int shukaisu3;
	private int shukaisu4;
	private String[] kakuTsukaJuni;
	private String baba;

	public RaceDataSet() {}
	public RaceDataSet(String dataKubun, String raceCode, String kaisaiNenGappi, int kaisaiKaiji, int kaisaiNichiji,
			int raceBango, String keibajo, String yobi, int Jusho_Kaiji, String kyosomeiHondai, String kyosomeiFukudai, String kyosomeiRyaku10,
			int kyosomeiKubun, String grade, String kyosoShubetsu, String kyosoKigo, String juryoShubetsu,
			String kyosoJoken, int kyori, String trackCode, String hassoJikoku, int torokuTosu, int shussoTosu,
			int nyusenTosu, String tenko, String shibaJotai, String dirtJotai, BigDecimal[] lapTime,
			BigDecimal zenhan3f, BigDecimal zenhan4f, BigDecimal kohan3f, BigDecimal kohan4f, int coner1, int coner2,
			int coner3, int coner4, int shukaisu1, int shukaisu2, int shukaisu3, int shukaisu4,
			String[] kakuTsukaJuni) {
		this.dataKubun = dataKubun;
		this.raceCode = raceCode;
		this.kaisaiNenGappi = DateTimeFormat.dateFormat(kaisaiNenGappi,1);
		this.kaisaiKaiji = kaisaiKaiji;
		this.kaisaiNichiji = kaisaiNichiji;
		this.raceBango = raceBango;
		this.keibajo = keibajo;
		this.yobi = yobi;
		this.Jusho_Kaiji = Jusho_Kaiji;
		this.kyosomeiHondai = kyosomeiHondai;
		this.kyosomeiFukudai = kyosomeiFukudai;
		this.kyosomeiRyaku10 = kyosomeiRyaku10;
		this.kyosomeiKubun = kyosomeiKubun;
		this.grade = grade;
		this.kyosoShubetsu = kyosoShubetsu;
		this.kyosoKigo = kyosoKigo;
		this.juryoShubetsu = juryoShubetsu;
		this.kyosoJoken = kyosoJoken;
		this.kyori = kyori;
		this.trackCode = trackCode;
		this.hassoJikoku = DateTimeFormat.dateFormat(hassoJikoku,2);
		this.torokuTosu = torokuTosu;
		this.shussoTosu = shussoTosu;
		this.nyusenTosu = nyusenTosu;
		this.tenko = tenko;
		this.shibaJotai = shibaJotai;
		this.dirtJotai = dirtJotai;
		this.lapTime = lapTime;
		this.zenhan3f = zenhan3f;
		this.zenhan4f = zenhan4f;
		this.kohan3f = kohan3f;
		this.kohan4f = kohan4f;
		this.coner1 = coner1;
		this.coner2 = coner2;
		this.coner3 = coner3;
		this.coner4 = coner4;
		this.shukaisu1 = shukaisu1;
		this.shukaisu2 = shukaisu2;
		this.shukaisu3 = shukaisu3;
		this.shukaisu4 = shukaisu4;
		this.kakuTsukaJuni = kakuTsukaJuni;
		this.baba = TrackCodeFormat.getBaba(trackCode);
	}

	public String getBaba() {
		return baba;
	}

	public String getDataKubun() {
		return dataKubun;
	}

	public String getRaceCode() {
		return raceCode;
	}

	public String getKaisaiNenGappi() {
		return kaisaiNenGappi;
	}

	public int getKaisaiKaiji() {
		return kaisaiKaiji;
	}

	public int getKaisaiNichiji() {
		return kaisaiNichiji;
	}

	public int getRaceBango() {
		return raceBango;
	}

	public String getKeibajo() {
		return keibajo;
	}

	public int getJushoKaiji() {
		return Jusho_Kaiji;
	}

	public String getYobi() {
		return yobi;
	}

	public String getKyosomeiHondai() {
		return kyosomeiHondai;
	}

	public String getKyosomeiFukudai() {
		return kyosomeiFukudai;
	}

	public String getKyosomeiRyaku10() {
		return kyosomeiRyaku10;
	}

	public int getKyosomeiKubun() {
		return kyosomeiKubun;
	}

	public String getGrade() {
		return grade;
	}

	public String getKyosoShubetsu() {
		return kyosoShubetsu;
	}

	public String getKyosoKigo() {
		return kyosoKigo;
	}

	public String getJuryoShubetsu() {
		return juryoShubetsu;
	}

	public String getKyosoJoken() {
		return kyosoJoken;
	}

	public int getKyori() {
		return kyori;
	}

	public String getTrackCode() {
		return trackCode;
	}

	public String getHassoJikoku() {
		return hassoJikoku;
	}

	public int getTorokuTosu() {
		return torokuTosu;
	}

	public int getShussoTosu() {
		return shussoTosu;
	}

	public int getNyusenTosu() {
		return nyusenTosu;
	}

	public String getTenko() {
		return tenko;
	}

	public String getShibaJotai() {
		return shibaJotai;
	}

	public String getDirtJotai() {
		return dirtJotai;
	}

	public BigDecimal[] getLapTime() {
		return lapTime;
	}

	public BigDecimal getZenhan3f() {
		return zenhan3f;
	}

	public BigDecimal getZenhan4f() {
		return zenhan4f;
	}

	public BigDecimal getKohan3f() {
		return kohan3f;
	}

	public BigDecimal getKohan4f() {
		return kohan4f;
	}

	public int getConer1() {
		return coner1;
	}

	public int getConer2() {
		return coner2;
	}

	public int getConer3() {
		return coner3;
	}

	public int getConer4() {
		return coner4;
	}

	public int getShukaisu1() {
		return shukaisu1;
	}

	public int getShukaisu2() {
		return shukaisu2;
	}

	public int getShukaisu3() {
		return shukaisu3;
	}

	public int getShukaisu4() {
		return shukaisu4;
	}

	public String[] getKakuTsukaJuni() {
		return kakuTsukaJuni;
	}

}
