package com.pckeiba.schedule;

import java.time.LocalDate;

public class KaisaiScheduleSet {
	private int dataKubun;
	private String kaisaiCode;
	private LocalDate kaisaiNengappi;
	private String keibajo;
	private int kaisaiKaiji;
	private int kaisaiNichiji;
	private String yobi;
	private JushoKyosoDataSet jusho1;
	private JushoKyosoDataSet jusho2;
	private JushoKyosoDataSet jusho3;

	public KaisaiScheduleSet(int dataKubun, String kaisaiCode, LocalDate kaisaiNengappi, String keibajo, int kaisaiKaiji,
			int kaisaiNichiji, String yobi, JushoKyosoDataSet jusho1, JushoKyosoDataSet jusho2,
			JushoKyosoDataSet jusho3) {
		super();
		this.dataKubun = dataKubun;
		this.kaisaiCode = kaisaiCode;
		this.kaisaiNengappi = kaisaiNengappi;
		this.keibajo = keibajo;
		this.kaisaiKaiji = kaisaiKaiji;
		this.kaisaiNichiji = kaisaiNichiji;
		this.yobi = yobi;
		this.jusho1 = jusho1;
		this.jusho2 = jusho2;
		this.jusho3 = jusho3;
	}

	public int getDataKubun() {
		return dataKubun;
	}

	public String getKaisaiCode() {
		return kaisaiCode;
	}

	public LocalDate getKaisaiNengappi() {
		return kaisaiNengappi;
	}

	public String getKeibajo() {
		return keibajo;
	}

	public int getKaisaiKaiji() {
		return kaisaiKaiji;
	}

	public int getKaisaiNichiji() {
		return kaisaiNichiji;
	}

	public String getYobi() {
		return yobi;
	}

	public JushoKyosoDataSet getJusho1() {
		return jusho1;
	}

	public JushoKyosoDataSet getJusho2() {
		return jusho2;
	}

	public JushoKyosoDataSet getJusho3() {
		return jusho3;
	}


}
