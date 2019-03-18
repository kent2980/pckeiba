package com.pckeiba.schedule;

import java.time.LocalDate;

/**
 * 開催スケジュール詳細を格納するデータセットクラスです
 * @author kent2
 *
 */
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
	private JushoKyosoDataSet mainKyoso;

	/**
	 * コンストラクタ<br>
	 * フィールドに開催詳細データを格納します
	 * @param dataKubun　データ区分
	 * @param kaisaiCode　開催コード
	 * @param kaisaiNengappi　開催年月日
	 * @param keibajo　競馬場
	 * @param kaisaiKaiji　開催回次
	 * @param kaisaiNichiji　開催日次
	 * @param yobi　曜日
	 * @param jusho1　開催重賞１
	 * @param jusho2　開催重賞2
	 * @param jusho3　開催重賞3
	 * @param mainKyoso メイン競争
	 */
	public KaisaiScheduleSet(int dataKubun, String kaisaiCode, LocalDate kaisaiNengappi, String keibajo, int kaisaiKaiji,
			int kaisaiNichiji, String yobi, JushoKyosoDataSet jusho1, JushoKyosoDataSet jusho2,
			JushoKyosoDataSet jusho3, JushoKyosoDataSet mainKyoso) {
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
		this.mainKyoso = mainKyoso;
	}

	/**
	 * データ区分を返します
	 * @return　データ区分
	 */
	public int getDataKubun() {
		return dataKubun;
	}

	/**
	 * 開催コードを返します
	 * @return　開催コード
	 */
	public String getKaisaiCode() {
		return kaisaiCode;
	}

	/**
	 * 開催年月日を返します
	 * @return　開催年月日
	 */
	public LocalDate getKaisaiNengappi() {
		return kaisaiNengappi;
	}

	/**
	 * 開催競馬場を返します
	 * @return　競馬場
	 */
	public String getKeibajo() {
		return keibajo;
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
	 * @return　開催日次
	 */
	public int getKaisaiNichiji() {
		return kaisaiNichiji;
	}

	/**
	 * 開催曜日を返します
	 * @return　開催曜日
	 */
	public String getYobi() {
		return yobi;
	}

	/**
	 * 開催重賞1のデータセットクラスを返します
	 * @return 開催重賞1
	 */
	public JushoKyosoDataSet getJusho1() {
		return jusho1;
	}

	/**
	 * 開催重賞2のデータセットクラスを返します
	 * @return 開催重賞2
	 */
	public JushoKyosoDataSet getJusho2() {
		return jusho2;
	}

	/**
	 * 開催重賞3のデータセットクラスを返します
	 * @return 開催重賞3
	 */
	public JushoKyosoDataSet getJusho3() {
		return jusho3;
	}

	/**
	 * メイン競争のデータセットクラスを返します
	 * @return メイン競争
	 */
	public JushoKyosoDataSet getMainKyoso() {
		return mainKyoso;
	}


}
