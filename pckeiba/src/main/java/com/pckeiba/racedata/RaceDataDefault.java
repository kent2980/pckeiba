package com.pckeiba.racedata;

import java.io.Serializable;
import java.math.BigDecimal;

import com.util.DateTimeFormat;
import com.util.TrackCodeFormat;

public class RaceDataDefault implements Serializable,Comparable<RaceDataSet>{
	private static final long serialVersionUID = 1L;
	private String dataKubun;
	private String raceCode;
	private String kaisaiNenGappi;
	private int kaisaiKaiji;
	private int kaisaiNichiji;
	private int raceBango;
	private String keibajo;
	private String yobi;
	private int JushoKaiji;
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
	private int keibajoCode;

	/**
	 * コンストラクタ<br>
	 * nullなオブジェクトを生成します
	 */
	public RaceDataDefault() {}

	/**
	 * コンストラクタ<br>
	 * 引数に各レース詳細データを指定してオブジェクトを生成します
	 * @param dataKubun データ区分
	 * @param raceCode レースコード
	 * @param kaisaiNenGappi 開催年月日
	 * @param kaisaiKaiji 開催回次
	 * @param kaisaiNichiji 開催日次
	 * @param raceBango レース番号
	 * @param keibajo 競馬場
	 * @param yobi 曜日
	 * @param Jusho_Kaiji 重賞回次
	 * @param kyosomeiHondai 競争名本題
	 * @param kyosomeiFukudai 競争名副題
	 * @param kyosomeiRyaku10 競争名略称10文字
	 * @param kyosomeiKubun 競争名区分
	 * @param grade 競走グレード
	 * @param kyosoShubetsu 競争種別
	 * @param kyosoKigo 競争記号
	 * @param juryoShubetsu 重量種別
	 * @param kyosoJoken 競争条件
	 * @param kyori 距離
	 * @param trackCode トラックコード
	 * @param hassoJikoku 発送時刻
	 * @param torokuTosu 登録頭数
	 * @param shussoTosu 出走頭数
	 * @param nyusenTosu 入選頭数
	 * @param tenko 天候
	 * @param shibaJotai 芝馬場状態
	 * @param dirtJotai ダート馬場状態
	 * @param lapTime ラップタイム
	 * @param zenhan3f 前半3fタイム
	 * @param zenhan4f 前半4fタイム
	 * @param kohan3f 後半3fタイム
	 * @param kohan4f 後半4fタイム
	 * @param coner1 コーナー1順位
	 * @param coner2 コーナー2順位
	 * @param coner3 コーナー3順位
	 * @param coner4 コーナー4順位
	 * @param shukaisu1 周回数1
	 * @param shukaisu2 周回数2
	 * @param shukaisu3 周回数3
	 * @param shukaisu4 周回数4
	 * @param kakuTsukaJuni 角通過順位
	 * @param keibajoCode 競馬場コード
	 */
	public RaceDataDefault(String dataKubun, String raceCode, String kaisaiNenGappi, int kaisaiKaiji, int kaisaiNichiji,
			int raceBango, String keibajo, String yobi, int JushoKaiji, String kyosomeiHondai, String kyosomeiFukudai, String kyosomeiRyaku10,
			int kyosomeiKubun, String grade, String kyosoShubetsu, String kyosoKigo, String juryoShubetsu,
			String kyosoJoken, int kyori, String trackCode, String hassoJikoku, int torokuTosu, int shussoTosu,
			int nyusenTosu, String tenko, String shibaJotai, String dirtJotai, BigDecimal[] lapTime,
			BigDecimal zenhan3f, BigDecimal zenhan4f, BigDecimal kohan3f, BigDecimal kohan4f, int coner1, int coner2,
			int coner3, int coner4, int shukaisu1, int shukaisu2, int shukaisu3, int shukaisu4,
			String[] kakuTsukaJuni, int keibajoCode) {
		this.dataKubun = dataKubun;
		this.raceCode = raceCode;
		this.kaisaiNenGappi = DateTimeFormat.dateFormat(kaisaiNenGappi,1);
		this.kaisaiKaiji = kaisaiKaiji;
		this.kaisaiNichiji = kaisaiNichiji;
		this.raceBango = raceBango;
		this.keibajo = keibajo;
		this.yobi = yobi;
		this.JushoKaiji = JushoKaiji;
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
		this.keibajoCode = keibajoCode;
	}

	/**
	 * 馬場状態を返します
	 * @return 馬場状態
	 */
	public String getBaba() {
		return baba;
	}

	/**
	 * データ区分を返します
	 * @return データ区分
	 */
	public String getDataKubun() {
		return dataKubun;
	}

	/**
	 * レースコードを返します
	 * @return レースコード
	 */
	public String getRaceCode() {
		return raceCode;
	}

	/**
	 * 開催年月日を返します
	 * @return 開催年月日
	 */
	public String getKaisaiNenGappi() {
		return kaisaiNenGappi;
	}

	/**
	 * 開催回次を返します
	 * @return　開催回次
	 */
	public int getKaisaiKaiji() {
		return kaisaiKaiji;
	}

	/**
	 * 開催日次を返します
	 * @return 開催日次
	 */
	public int getKaisaiNichiji() {
		return kaisaiNichiji;
	}

	/**
	 * レース番号を返します
	 * @return レース番号
	 */
	public int getRaceBango() {
		return raceBango;
	}

	/**
	 * 競馬場名を返します
	 * @return 競馬場
	 */
	public String getKeibajo() {
		return keibajo;
	}

	/**
	 * 重賞回次を返します
	 * @return 重賞回次
	 */
	public int getJushoKaiji() {
		return JushoKaiji;
	}

	/**
	 * 開催曜日を返します
	 * @return 曜日
	 */
	public String getYobi() {
		return yobi;
	}

	/**
	 * 競争名本題を返します
	 * @return 競争名本題
	 */
	public String getKyosomeiHondai() {
		return kyosomeiHondai;
	}

	/**
	 * 競争名副題を返します
	 * @return 競争名副題
	 */
	public String getKyosomeiFukudai() {
		return kyosomeiFukudai;
	}

	/**
	 * 競争名略称10文字を返します
	 * @return 競争名略称10文字
	 */
	public String getKyosomeiRyaku10() {
		return kyosomeiRyaku10;
	}

	/**
	 * 競争名区分を返します
	 * @return 競争名区分
	 */
	public int getKyosomeiKubun() {
		return kyosomeiKubun;
	}

	/**
	 * 競走グレードを返します
	 * @return グレード
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * 競争種別を返します
	 * @return 競争種別
	 */
	public String getKyosoShubetsu() {
		return kyosoShubetsu;
	}

	/**
	 * 競争記号を返します
	 * @return 競争記号
	 */
	public String getKyosoKigo() {
		return kyosoKigo;
	}

	/**
	 * 重量種別を返します
	 * @return 重量種別
	 */
	public String getJuryoShubetsu() {
		return juryoShubetsu;
	}

	/**
	 * 競争条件を返します
	 * @return 競争条件
	 */
	public String getKyosoJoken() {
		return kyosoJoken;
	}

	/**
	 * 施工されるレース距離を返します
	 * @return 距離
	 */
	public int getKyori() {
		return kyori;
	}

	/**
	 * トラックコードを返します
	 * @return トラックコード
	 */
	public String getTrackCode() {
		return trackCode;
	}

	/**
	 * 発送時刻を返します
	 * @return 発送時刻
	 */
	public String getHassoJikoku() {
		return hassoJikoku;
	}

	/**
	 * 登録頭数を返します
	 * @return 登録頭数
	 */
	public int getTorokuTosu() {
		return torokuTosu;
	}

	/**
	 * 出走頭数を返します
	 * @return 出走頭数
	 */
	public int getShussoTosu() {
		return shussoTosu;
	}

	/**
	 * 入選頭数を返します
	 * @return 入選頭数
	 */
	public int getNyusenTosu() {
		return nyusenTosu;
	}

	/**
	 * 天候を返します
	 * @return 天候
	 */
	public String getTenko() {
		return tenko;
	}

	/**
	 * 芝馬場状態を返します
	 * @return 芝馬場状態
	 */
	public String getShibaJotai() {
		return shibaJotai;
	}

	/**
	 * ダート馬場状態を返します
	 * @return ダート馬場状態
	 */
	public String getDirtJotai() {
		return dirtJotai;
	}

	/**
	 * ラップタイムを配列で返します
	 * @return ラップタイム
	 */
	public BigDecimal[] getLapTime() {
		return lapTime;
	}

	/**
	 * 前半3fタイムを返します
	 * @return 前半3fタイム
	 */
	public BigDecimal getZenhan3f() {
		return zenhan3f;
	}

	/**
	 * 前半4fタイムを返します
	 * @return 前半4fタイム
	 */
	public BigDecimal getZenhan4f() {
		return zenhan4f;
	}

	/**
	 * 後半3fタイムを返します
	 * @return 後半3fタイム
	 */
	public BigDecimal getKohan3f() {
		return kohan3f;
	}

	/**
	 * 後半4fタイムを返します
	 * @return 後半4fタイム
	 */
	public BigDecimal getKohan4f() {
		return kohan4f;
	}

	/**
	 * コーナー1順位を返します
	 * @return コーナー1順位
	 */
	public int getConer1() {
		return coner1;
	}

	/**
	 * コーナー2順位を返します
	 * @return コーナー2順位
	 */
	public int getConer2() {
		return coner2;
	}

	/**
	 * コーナー3順位を返します
	 * @return コーナー3順位
	 */
	public int getConer3() {
		return coner3;
	}

	/**
	 * コーナー4順位を返します
	 * @return コーナー4順位
	 */
	public int getConer4() {
		return coner4;
	}

	/**
	 * 周回数1を返します
	 * @return 周回数1
	 */
	public int getShukaisu1() {
		return shukaisu1;
	}

	/**
	 * 周回数2を返します
	 * @return 周回数2
	 */
	public int getShukaisu2() {
		return shukaisu2;
	}

	/**
	 * 周回数3を返します
	 * @return 周回数3
	 */
	public int getShukaisu3() {
		return shukaisu3;
	}

	/**
	 * 周回数4を返します
	 * @return 周回数4
	 */
	public int getShukaisu4() {
		return shukaisu4;
	}

	/**
	 * 角通過順位を返します
	 * @return 角通過順位
	 */
	public String[] getKakuTsukaJuni() {
		return kakuTsukaJuni;
	}

	/**
	 * 引数のインスタンスと比較を行います
	 */
	@Override
	public int compareTo(RaceDataSet o) {
		if(this.raceBango > o.getRaceBango())
			return 1;
		if(this.raceBango < o.getRaceBango())
			return -1;

		return 0;
	}

	/**
	 * 競馬場コードを返します
	 * @return　競馬場コード
	 */
	public int getKeibajoCode() {
		return keibajoCode;
	}

}
