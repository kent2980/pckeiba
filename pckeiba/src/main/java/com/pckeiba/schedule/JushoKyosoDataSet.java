package com.pckeiba.schedule;

/**
 * 重賞競走のデータセットクラスです<br>
 * @author kent2
 *
 */
public class JushoKyosoDataSet {
	private int tokubetsuKyosoBango;
	private String kyosomeiHondai;
	private String kyosomeiRyakusho_10;
	private String kyosomeiRyakusho_6;
	private String kyosomeiRyakusho_3;
	private int jushoKaiji;
	private String jushoGrade;
	private String kyosoShubetsu;
	private String kyosoKigo;
	private String juryoShubetsu;
	private int kyori;
	private String jushoTrack;
	private String raceCode;

	/**
	 * コンストラクタ<br>
	 * フィールドにデータを格納してください
	 * @param tokubetsuKyosoBango 特別競走番号
	 * @param kyosomeiHondai 競争名本題
	 * @param kyosomeiRyakusho_10　競争名略称10文字
	 * @param kyosomeiRyakusho_6　競争名略称6文字
	 * @param kyosomeiRyakusho_3　競争名略称3文字
	 * @param jushoKaiji　重賞回次
	 * @param jushoGrade　重賞グレード
	 * @param kyosoShubetsu　競争種別
	 * @param kyosoKigo　競争記号
	 * @param juryoShubetsu　重賞種別
	 * @param kyori　距離
	 * @param jushoTrack　重賞トラック
	 * @param raceCode レースコード
	 */
	public JushoKyosoDataSet(int tokubetsuKyosoBango, String kyosomeiHondai, String kyosomeiRyakusho_10,
			String kyosomeiRyakusho_6, String kyosomeiRyakusho_3, int jushoKaiji, String jushoGrade,
			String kyosoShubetsu, String kyosoKigo, String juryoShubetsu, int kyori, String jushoTrack, String raceCode) {
		super();
		this.tokubetsuKyosoBango = tokubetsuKyosoBango;
		this.kyosomeiHondai = kyosomeiHondai;
		this.kyosomeiRyakusho_10 = kyosomeiRyakusho_10;
		this.kyosomeiRyakusho_6 = kyosomeiRyakusho_6;
		this.kyosomeiRyakusho_3 = kyosomeiRyakusho_3;
		this.jushoKaiji = jushoKaiji;
		this.jushoGrade = jushoGrade;
		this.kyosoShubetsu = kyosoShubetsu;
		this.kyosoKigo = kyosoKigo;
		this.juryoShubetsu = juryoShubetsu;
		this.kyori = kyori;
		this.jushoTrack = jushoTrack;
		this.raceCode = raceCode;
	}

	/**
	 * 特別競走番号を返します
	 * @return　特別競走番号
	 */
	public int getTokubetsuKyosoBango() {
		return tokubetsuKyosoBango;
	}

	/**
	 * 競争名本題を返します
	 * @return　競争名本題
	 */
	public String getKyosomeiHondai() {
		return kyosomeiHondai;
	}

	/**
	 * 競争名略称10文字を返します
	 * @return　競争名略称10文字
	 */
	public String getKyosomeiRyakusho_10() {
		return kyosomeiRyakusho_10;
	}

	/**
	 * 競争名略称6文字を返します
	 * @return　競争名略称6文字
	 */
	public String getKyosomeiRyakusho_6() {
		return kyosomeiRyakusho_6;
	}

	/**
	 * 競争名略称3文字を返します
	 * @return　競争名略称3文字
	 */
	public String getKyosomeiRyakusho_3() {
		return kyosomeiRyakusho_3;
	}

	/**
	 * 重賞回次を返します
	 * @return　重賞回次
	 */
	public int getJushoKaiji() {
		return jushoKaiji;
	}

	/**
	 * 重賞グレードを返します
	 * @return 重賞グレード
	 */
	public String getJushoGrade() {
		return jushoGrade;
	}

	/**
	 * 競争種別を返します
	 * @return　競争種別
	 */
	public String getKyosoShubetsu() {
		return kyosoShubetsu;
	}

	/**
	 * 競争記号を返します
	 * @return　競争記号
	 */
	public String getKyosoKigo() {
		return kyosoKigo;
	}

	/**
	 * 重量種別を返します
	 * @return　重量種別
	 */
	public String getJuryoShubetsu() {
		return juryoShubetsu;
	}

	/**
	 * 競争距離を返します
	 * @return 距離
	 */
	public int getKyori() {
		return kyori;
	}

	/**
	 * 重賞トラックを返します
	 * @return　トラック条件
	 */
	public String getJushoTrack() {
		return jushoTrack;
	}

	/**
	 * 重賞レースのレースコードを返します
	 * @return　レースコード
	 */
	public String getRaceCode() {
		return raceCode;
	}


}
