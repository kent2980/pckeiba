package com.pckeiba.schedule;

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

	public JushoKyosoDataSet(int tokubetsuKyosoBango, String kyosomeiHondai, String kyosomeiRyakusho_10,
			String kyosomeiRyakusho_6, String kyosomeiRyakusho_3, int jushoKaiji, String jushoGrade,
			String kyosoShubetsu, String kyosoKigo, String juryoShubetsu, int kyori, String jushoTrack) {
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
	}

	public int getTokubetsuKyosoBango() {
		return tokubetsuKyosoBango;
	}

	public String getKyosomeiHondai() {
		return kyosomeiHondai;
	}

	public String getKyosomeiRyakusho_10() {
		return kyosomeiRyakusho_10;
	}

	public String getKyosomeiRyakusho_6() {
		return kyosomeiRyakusho_6;
	}

	public String getKyosomeiRyakusho_3() {
		return kyosomeiRyakusho_3;
	}

	public int getJushoKaiji() {
		return jushoKaiji;
	}

	public String getJushoGrade() {
		return jushoGrade;
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

	public int getKyori() {
		return kyori;
	}

	public String getJushoTrack() {
		return jushoTrack;
	}


}
