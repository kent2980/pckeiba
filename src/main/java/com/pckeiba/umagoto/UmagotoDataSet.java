package com.pckeiba.umagoto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.pckeiba.list.LapList;
import com.util.DateTimeFormat;
import com.util.TrackCodeFormat;

/**
 * 出馬表の詳細データを表すオブジェクト<br>
 * 各データについてはJRA-VAN DataLab ドキュメントを参照してください<br>
 * 参照URL：<a href="https://jra-van.jp/dlb/sdv/sdk.html">https://jra-van.jp/dlb/sdv/sdk.html</a><br>
 * このクラスから生成したインスタンスは直列化されます
 * @author KentaroYoshida
 *
 */
public class UmagotoDataSet implements Serializable {

	/**
	 * @serial 1.0
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * フィールド
	 */
	private final int UmaGroup;
	private final String DataKubun;
	private final String raceCode;
	private final String KaisaiNenGappi;
	private final String bamei;
	private final String keibajo;
	private final int kaisaiKaiji;
	private final int kaisaiNichiji;
	private final int raceBango;
	private final int wakuban;
	private final int umaban;
	private final String kettoTorokuBango;
	private final String seibetsu;
	private final int barei;
	private final String hinshu;
	private final String moshoku;
	private final String tozaiShozoku;
	private final String chokyoshi;
	private final String banushi;
	private final String fukushokuHyoji;
	private final double futanJuryo;
	private final int blinkerShiyoKubun;
	private final String kishumei;
	private final String kishumeiRyakusho;
	private final String kishuMinarai;
	private final int bataiju;
	private final String zogensa;
	private final String ijoKubun;
	private final int nyusenJuni;
	private final int kakuteiChakujun;
	private final BigDecimal sohaTime;
	private final int corner1Juni;
	private final int corner2Juni;
	private final int corner3Juni;
	private final int corner4Juni;
	private final double tanshoOdds;
	private final int tanshoNinkijun;
	private final BigDecimal kohan4F;
	private final BigDecimal kohan3F;
	private final String timeSa;
	private final String yobi;
	private final String grade;
	private final String kyosoShubetsu;
	private final String kyosoKigo;
	private final String juryoShubetsu;
	private final String kyosoJoken;
	private final String trackCode;
	private final String tenko;
	private final String shibaBabaJotai;
	private final String dirtBabaJotai;
	private final String kyosomeiHondai;
	private final String kyosomeiRyakusho10;
	private final String kyosomeiRyakusho6;
	private final int kyosomeiKubun;
	private final int jushoKaiji;
	private final int kyori;
	private final String hassoJikoku;
	private final BigDecimal srun;
	private final int umaID;
	private final int srunCount;
	private final String aiteBamei1;
	private final String aiteBamei2;
	private final String father;
	private final String mother;
	private final String grandfather;
	private final String baba;
	private final int torokuTosu;
	private final int shussoTosu;
	private final BigDecimal raceZenhan3f;
	private final BigDecimal raceZenhan4f;
	private final BigDecimal raceKohan3f;
	private final BigDecimal raceKohan4f;
	private final BigDecimal RPCI;
	private final BigDecimal fPCI;
	private final String kyakushitsu;
	private final BigDecimal ave3f;
	private final BigDecimal raceSrun;
	private final BigDecimal srun55;
	private final int kyakushitsuHantei;
	private final LapList lap;

	/**
	 * コンストラクタ finalなプロパティを設定します。
	 * @param umaGroup 馬番
	 * @param dataKubun データ区分
	 * @param raceCode レースコード
	 * @param kaisaiNenGappi 開催年月日
	 * @param bamei 馬名
	 * @param keibajo 競馬場
	 * @param kaisaiKaiji 開催回次
	 * @param kaisaiNichiji 開催日次
	 * @param raceBango レース番号
	 * @param wakuban 枠番
	 * @param umaban 馬番
	 * @param kettoTorokuBango 血統登録番号
	 * @param seibetsu 性別
	 * @param barei 馬齢
	 * @param hinshu 品種
	 * @param moshoku 毛色
	 * @param tozaiShozoku 東西所属
	 * @param chokyoshi 調教師
	 * @param banushi 馬主
	 * @param fukushokuHyoji 勝負服の表示色
	 * @param futanJuryo 斤量
	 * @param blinkerShiyoKubun ブリンカー使用区分
	 * @param kishumei 騎手名
	 * @param kishumeiRyakusho 騎手名略称
	 * @param kishuMinarai 騎手見習い表示
	 * @param bataiju 馬体重
	 * @param zogensa 増減差
	 * @param ijoKubun 異常区分
	 * @param nyusenJuni 入選順位
	 * @param kakuteiChakujun 確定着順
	 * @param sohaTime 走破タイム
	 * @param corner1Juni コーナー1順位
	 * @param corner2Juni コーナー2順位
	 * @param corner3Juni コーナー3順位
	 * @param corner4Juni コーナー4順位
	 * @param tanshoOdds 単勝オッズ
	 * @param tanshoNinkijun 単勝人気順
	 * @param kohan4f 後半4fタイム
	 * @param kohan3f 後半3fタイム
	 * @param timeSa タイム差
	 * @param yobi 曜日
	 * @param grade 競走グレード
	 * @param kyosoShubetsu 競争種別
	 * @param kyosoKigo 競争記号
	 * @param juryoShubetsu 重量種別
	 * @param kyosoJoken 競争条件
	 * @param trackCode トラックコード
	 * @param tenko 天候
	 * @param shibaBabaJotai 芝馬場状態
	 * @param dirtBabaJotai ダート馬場状態
	 * @param kyosomeiHondai 競争名本題
	 * @param kyosomeiRyakusho10 競争名略称10文字
	 * @param kyosomeiRyakusho6 競争名略称6文字
	 * @param kyosomeiKubun 競争名区分
	 * @param jushoKaiji 重賞回次
	 * @param kyori 距離
	 * @param hassoJikoku 発送時刻
	 * @param srun Srun
	 * @param aiteBamei1 相手馬名1
	 * @param aiteBamei2 相手馬名2
	 * @param father 父
	 * @param mother 母
	 * @param grandFather 母父
	 * @param torokuTosu 登録頭数
	 * @param shussoTosu 出走頭数
	 * @param umaID　前走を１としたレース指定ID
	 * @param srunCount Srunの有効個数
	 * @param raceZenhan3f レースの前半3fタイム
	 * @param raceZenhan4f レースの前半4fタイム
	 * @param raceKohan3f レースの後半3fタイム
	 * @param raceKohan4f レースの後半4fタイム
	 * @param RPCI レースのペースチェンジ指数
	 * @param fPCI 馬毎の上がり3Fの標準偏差
	 * @param kyakushitsu 脚質
	 * @param ave3f 平均3F
	 * @param raceSrun レースのSRUN
	 * @param srun55 斤量55kgにおけるSRUN
	 * @param kyakushitsuHantei 脚質判定
	 * @param lap ラップ
	 */
	public UmagotoDataSet(int umaGroup, String dataKubun, String raceCode, String kaisaiNenGappi, String bamei,
			String keibajo, int kaisaiKaiji, int kaisaiNichiji, int raceBango, int wakuban, int umaban,
			String kettoTorokuBango, String seibetsu, int barei, String hinshu, String moshoku, String tozaiShozoku,
			String chokyoshi, String banushi, String fukushokuHyoji, double futanJuryo, int blinkerShiyoKubun,
			String kishumei, String kishumeiRyakusho, String kishuMinarai, int bataiju, String zogensa, String ijoKubun,
			int nyusenJuni, int kakuteiChakujun, BigDecimal sohaTime, int corner1Juni, int corner2Juni, int corner3Juni,
			int corner4Juni, double tanshoOdds, int tanshoNinkijun, BigDecimal kohan4f, BigDecimal kohan3f,
			double timeSa, String yobi, String grade, String kyosoShubetsu, String kyosoKigo, String juryoShubetsu,
			String kyosoJoken, String trackCode, String tenko, String shibaBabaJotai, String dirtBabaJotai,
			String kyosomeiHondai, String kyosomeiRyakusho10, String kyosomeiRyakusho6, int kyosomeiKubun,
			int jushoKaiji, int kyori, String hassoJikoku, BigDecimal srun,  String aiteBamei1, String aiteBamei2,
			String father, String mother, String grandFather, int torokuTosu, int shussoTosu, int umaID, int srunCount,
			BigDecimal raceZenhan3f, BigDecimal raceZenhan4f, BigDecimal raceKohan3f, BigDecimal raceKohan4f, BigDecimal RPCI,
			BigDecimal fPCI, String kyakushitsu, BigDecimal ave3f, BigDecimal raceSrun, BigDecimal srun55, int kyakushitsuHantei,
			LapList lap) {
		this.UmaGroup = umaGroup;
		this.DataKubun = dataKubun;
		this.raceCode = raceCode;
		this.KaisaiNenGappi = DateTimeFormat.dateFormat(kaisaiNenGappi, 1);
		this.bamei = bamei;
		this.keibajo = keibajo;
		this.kaisaiKaiji = kaisaiKaiji;
		this.kaisaiNichiji = kaisaiNichiji;
		this.raceBango = raceBango;
		this.wakuban = wakuban;
		this.umaban = umaban;
		this.kettoTorokuBango = kettoTorokuBango;
		this.seibetsu = seibetsu;
		this.barei = barei;
		this.hinshu = hinshu;
		this.moshoku = moshoku;
		this.tozaiShozoku = tozaiShozoku;
		this.chokyoshi = chokyoshi;
		this.banushi = banushi;
		this.fukushokuHyoji = fukushokuHyoji;
		this.futanJuryo = futanJuryo;
		this.blinkerShiyoKubun = blinkerShiyoKubun;
		this.kishumei = kishumei;
		this.kishumeiRyakusho = kishumeiRyakusho;
		this.kishuMinarai = kishuMinarai;
		this.bataiju = bataiju;
		this.zogensa = zogensa;
		this.ijoKubun = ijoKubun;
		this.nyusenJuni = nyusenJuni;
		this.kakuteiChakujun = kakuteiChakujun;
		this.sohaTime = sohaTime;
		this.corner1Juni = corner1Juni;
		this.corner2Juni = corner2Juni;
		this.corner3Juni = corner3Juni;
		this.corner4Juni = corner4Juni;
		this.tanshoOdds = tanshoOdds;
		this.tanshoNinkijun = tanshoNinkijun;
		kohan4F = kohan4f;
		kohan3F = kohan3f;
		this.timeSa = timeSa>0?"+" + timeSa:String.valueOf(timeSa);
		this.yobi = yobi;
		this.grade = grade;
		this.kyosoShubetsu = kyosoShubetsu;
		this.kyosoKigo = kyosoKigo;
		this.juryoShubetsu = juryoShubetsu;
		this.kyosoJoken = kyosoJoken;
		this.trackCode = trackCode;
		this.tenko = tenko;
		this.shibaBabaJotai = shibaBabaJotai;
		this.dirtBabaJotai = dirtBabaJotai;
		this.kyosomeiHondai = kyosomeiHondai;
		this.kyosomeiRyakusho10 = kyosomeiRyakusho10;
		this.kyosomeiRyakusho6 = kyosomeiRyakusho6;
		this.kyosomeiKubun = kyosomeiKubun;
		this.jushoKaiji = jushoKaiji;
		this.kyori = kyori;
		this.hassoJikoku = DateTimeFormat.dateFormat(hassoJikoku, 2);
		this.srun = srun;
		this.umaID = umaID;
		this.srunCount = srunCount;
		this.aiteBamei1 = aiteBamei1;
		this.aiteBamei2 = aiteBamei2;
		this.father = father;
		this.mother = mother;
		this.grandfather = grandFather;
		this.baba = TrackCodeFormat.getBaba(trackCode);
		this.torokuTosu = torokuTosu;
		this.shussoTosu = shussoTosu;
		this.raceZenhan3f = raceZenhan3f;
		this.raceZenhan4f = raceZenhan4f;
		this.raceKohan3f = raceKohan3f;
		this.raceKohan4f = raceKohan4f;
		this.RPCI = RPCI;
		this.fPCI = fPCI;
		this.kyakushitsu = kyakushitsu;
		this.ave3f = ave3f;
		this.raceSrun = raceSrun;
		this.srun55 = srun55;
		this.kyakushitsuHantei = kyakushitsuHantei;
		this.lap = lap;
	}

	/**
	 * レースで使用する馬場を返します。
	 * @return 馬場
	 */
	public String getBaba() {
		return baba;
	}

	/**
	 * 直列化クラスのシリアルバージョンを返します。
	 * @return シリアルバージョン Not Null
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * UmaGroupを返します。<br>UmaGroupは基底のレースの馬番です。出馬表未確定の場合は、０が返されます。
	 * @return UmaGroup 出馬表未確定の場合は0を返す。
	 */
	public int getUmaGroup() {
		return UmaGroup;
	}

	/**
	 * レース区分を返します。<br>成績確定後は7が返されます。
	 * @return レース区分
	 */
	public String getDataKubun() {
		return DataKubun;
	}

	/**
	 * レースコードを返します。
	 * @return レースコード Not Null
	 */
	public String getRaceCode() {
		return raceCode;
	}

	/**
	 * 開催年月日を返します。<br>
	 * 【活用例】<br>
	 * 1.LocalDateへの変換例<br>
	 * LocalDate date = LocalDate.parse(day, DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
	 * @return 開催年月日 Not Null
	 */
	public String getKaisaiNenGappi() {
		return KaisaiNenGappi;
	}

	/**
	 * 馬名を返します。
	 * @return 馬名 Not Null
	 */
	public String getBamei() {
		return bamei;
	}

	/**
	 * レースが開催される競馬場を返します。
	 * @return 競馬場 Not Null
	 */
	public String getKeibajo() {
		return keibajo;
	}

	/**
	 * レースの開催回次を返します。
	 * @return　開催回次 Not Null
	 */
	public int getKaisaiKaiji() {
		return kaisaiKaiji;
	}

	/**
	 * レースの開催日次を返します。
	 * @return 開催日次 Not Null
	 */
	public int getKaisaiNichiji() {
		return kaisaiNichiji;
	}

	/**
	 * レース番号を返します。
	 * @return レース番号 Not Null
	 */
	public int getRaceBango() {
		return raceBango;
	}

	/**
	 * 枠番を返します。<br>出馬表確定前は0を返します。
	 * @return 枠番 出馬表確定前は0を返す Not Null
	 */
	public int getWakuban() {
		return wakuban;
	}

	/**
	 * 馬番を返します。<br>出馬表確定前は0を返します。
	 * @return 馬番 出馬表確定前は0を返す Not Null
	 */
	public int getUmaban() {
		return umaban;
	}

	/**
	 * 血統登録番号を返します。<br>馬固有の識別番号です。
	 * @return 血統登録番号 Not Null
	 */
	public String getKettoTorokuBango() {
		return kettoTorokuBango;
	}

	/**
	 * 性別を返します。
	 * @return 性別 Not Null
	 */
	public String getSeibetsu() {
		return seibetsu;
	}

	/**
	 * 馬齢を返します。
	 * @return 馬齢 Not Null
	 */
	public int getBarei() {
		return barei;
	}

	/**
	 * 品種コードを返します。
	 * @return 品種コード
	 */
	public String getHinshu() {
		return hinshu;
	}

	/**
	 * 毛色を返します。
	 * @return 毛色
	 */
	public String getMoshoku() {
		return moshoku;
	}

	/**
	 * 東西所属を返します。
	 * @return 東西所属
	 */
	public String getTozaiShozoku() {
		return tozaiShozoku;
	}

	/**
	 * 調教師の名前を返します。
	 * @return 調教師名
	 */
	public String getChokyoshi() {
		return chokyoshi;
	}

	/**
	 * 馬主の名前を返します。
	 * @return 馬主名
	 */
	public String getBanushi() {
		return banushi;
	}

	/**
	 * 勝負服の表示色を返します。
	 * @return 勝負服
	 */
	public String getFukushokuHyoji() {
		return fukushokuHyoji;
	}

	/**
	 * 斤量を返します。
	 * @return 斤量
	 */
	public double getFutanJuryo() {
		return futanJuryo;
	}

	/**
	 * ブリンカーの使用区分を返します
	 * @return ブリンカー使用区分 0=使用しない,1=使用する
	 */
	public int getBlinkerShiyoKubun() {
		return blinkerShiyoKubun;
	}

	/**
	 * 騎手の名前を返します。
	 * @return 騎手名
	 */
	public String getKishumei() {
		return kishumei;
	}

	/**
	 * 騎手名の略称を返します。
	 * @return 騎手名略称
	 */
	public String getKishumeiRyakusho() {
		return kishumeiRyakusho;
	}

	/**
	 * 騎手見習い表示を返します。
	 * @return 騎手見習い表示 Nullの場合は減量なし
	 */
	public String getKishuMinarai() {
		return kishuMinarai;
	}

	/**
	 * 馬体重を返します。
	 * @return 場体重
	 */
	public int getBataiju() {
		return bataiju;
	}

	/**
	 * 馬体重の前走からの増減差を返します。
	 * @return 増減差
	 */
	public String getZogensa() {
		return zogensa;
	}

	/**
	 * 競争中止などの情報を返します。
	 * @return 異常区分
	 */
	public String getIjoKubun() {
		return ijoKubun;
	}

	/**
	 * 入選順位を返します。<br>確定前は0を返します。
	 * @return 入選順位 確定前は0を返す
	 */
	public int getNyusenJuni() {
		return nyusenJuni;
	}

	/**
	 * 確定着順を返します。<br>確定前は0を返します。
	 * @return 確定着順
	 */
	public int getKakuteiChakujun() {
		return kakuteiChakujun;
	}

	/**
	 * 走破タイムを返します。<br>走破タイムは秒数表示です。
	 * @return 走破タイム
	 */
	public BigDecimal getSohaTime() {
		return sohaTime;
	}

	/**
	 * 走破タイムの文字列を返します。<br>走破タイムは分:秒.コンマ秒表示です。
	 * @return 走破タイム
	 */
	public String getSohaTimeValue() {
		//分を計算します
		BigDecimal minute = sohaTime.divide(BigDecimal.valueOf(60), 0, BigDecimal.ROUND_DOWN);
		//秒を計算します
		BigDecimal second = sohaTime.subtract(minute.multiply(BigDecimal.valueOf(60))).setScale(0, BigDecimal.ROUND_DOWN);
		//コンマ秒を計算します
		BigDecimal comma = sohaTime.subtract(minute.multiply(BigDecimal.valueOf(60))).subtract(second);
		//文字列の整形を行います
		String value = minute + ":" + String.format("%02d", second.intValue()) + "." + comma.multiply(BigDecimal.TEN).setScale(0);

		return value;
	}

	/**
	 * 1コーナーでの順位を返します。
	 * @return 順位
	 */
	public int getCorner1Juni() {
		return corner1Juni;
	}

	/**
	 * 2コーナーでの順位を返します。
	 * @return 順位
	 */
	public int getCorner2Juni() {
		return corner2Juni;
	}

	/**
	 * 3コーナーでの順位を返します。
	 * @return 順位
	 */
	public int getCorner3Juni() {
		return corner3Juni;
	}

	/**
	 * 4コーナーでの順位を返します。
	 * @return 順位
	 */
	public int getCorner4Juni() {
		return corner4Juni;
	}

	/**
	 * 単勝オッズを返します。
	 * @return 単勝オッズ
	 */
	public double getTanshoOdds() {
		return tanshoOdds;
	}

	/**
	 * 単勝人気を返します。
	 * @return 単勝人気
	 */
	public int getTanshoNinkijun() {
		return tanshoNinkijun;
	}

	/**
	 * 後半4Fの走破タイムを返します。
	 * @return 後半4F
	 */
	public BigDecimal getKohan4F() {
		return kohan4F;
	}

	/**
	 * 後半3Fの走破タイムを返します。
	 * @return 後半3F
	 */
	public BigDecimal getKohan3F() {
		return kohan3F;
	}

	/**
	 * 1着馬とのタイム差を返します。<br>勝ち馬の場合は、2着馬とのタイム差を返します。
	 * @return タイム差
	 */
	public String getTimeSa() {
		return timeSa;
	}

	/**
	 * レースの開催曜日を返します。
	 * @return 曜日
	 */
	public String getYobi() {
		return yobi;
	}

	/**
	 * レースのグレードを返します。
	 * @return グレード
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * 競争種別を返します。<br>出走可能な品種を表します。
	 * @return 競争種別
	 */
	public String getKyosoShubetsu() {
		return kyosoShubetsu;
	}

	/**
	 * 競争記号を返します。<br>出走可能条件を表します。
	 * @return 競争記号
	 */
	public String getKyosoKigo() {
		return kyosoKigo;
	}

	/**
	 * 重量種別を返します。<br>レースの斤量に関する条件を表します。
	 * @return 重量種別
	 */
	public String getJuryoShubetsu() {
		return juryoShubetsu;
	}

	/**
	 * 競争条件を返します。<br>獲得賞金毎の出走区分です。
	 * @return 競争条件
	 */
	public String getKyosoJoken() {
		return kyosoJoken;
	}

	/**
	 * トラックコードを返します。
	 * @return トラックコード
	 */
	public String getTrackCode() {
		return trackCode;
	}

	/**
	 * レース開催時の天候を返します。
	 * @return 天候
	 */
	public String getTenko() {
		return tenko;
	}

	/**
	 * レース開催時の芝馬場状態を返します。<br>0の場合はレースは開催されません。
	 * @return 芝馬場状態
	 */
	public String getShibaBabaJotai() {
		return shibaBabaJotai;
	}

	/**
	 * レース開催時のダート馬場状態を返します。<br>0の場合はレースは開催されません。
	 * @return ダート馬場状態
	 */
	public String getDirtBabaJotai() {
		return dirtBabaJotai;
	}

	/**
	 * 競争名本題を返します。
	 * @return 競争名本題
	 */
	public String getKyosomeiHondai() {
		return kyosomeiHondai;
	}

	/**
	 * 競争名略称を10文字以内で返します。
	 * @return 競争名略称
	 */
	public String getKyosomeiRyakusho10() {
		return kyosomeiRyakusho10;
	}

	/**
	 * 競争名略称を6文字以内で返します。
	 * @return 競争名略称
	 */
	public String getKyosomeiRyakusho6() {
		return kyosomeiRyakusho6;
	}

	/**
	 * 重賞回次[第N回]を本題･副題･カッコ内のうちどれに設定すべきかを示す<br>（0:初期値 1:本題 2:副題 3:カッコ内）重賞のみ設定
	 * @return 競争名区分
	 */
	public int getKyosomeiKubun() {
		return kyosomeiKubun;
	}

	/**
	 * 重賞回次を返します。
	 * @return 重賞回次
	 */
	public int getJushoKaiji() {
		return jushoKaiji;
	}

	/**
	 * レースの距離を返します。
	 * @return 距離
	 */
	public int getKyori() {
		return kyori;
	}

	/**
	 * レースの発送時刻を返します。
	 * @return 発送時刻
	 */
	public String getHassoJikoku() {
		return hassoJikoku;
	}

	/**
	 * SRUNを返します。<br>基準タイムを基底としたタイム差です。
	 * @return SRUN
	 */
	public BigDecimal getSrun() {
		return srun;
	}

	/**
	 * UmaIDを返します。<br>馬毎に前走を１として割り振ります。
	 * @return UmaID
	 */
	public int getUmaID() {
		return umaID;
	}

	/**
	 * SRUNが存在する場合は１、存在しない場合は0を返します。
	 * @return SrunCount
	 */
	public int getSrunCount() {
		return srunCount;
	}

	@Override
	public String toString() {
		return "UmagotoDataSet [UmaGroup=" + UmaGroup + ", DataKubun=" + DataKubun + ", raceCode=" + raceCode
				+ ", KaisaiNenGappi=" + KaisaiNenGappi + ", bamei=" + bamei + ", keibajo=" + keibajo + ", kaisaiKaiji="
				+ kaisaiKaiji + ", kaisaiNichiji=" + kaisaiNichiji + ", raceBango=" + raceBango + ", wakuban=" + wakuban
				+ ", umaban=" + umaban + ", kettoTorokuBango=" + kettoTorokuBango + ", seibetsu=" + seibetsu
				+ ", barei=" + barei + ", hinshu=" + hinshu + ", moshoku=" + moshoku + ", tozaiShozoku=" + tozaiShozoku
				+ ", chokyoshi=" + chokyoshi + ", banushi=" + banushi + ", fukushokuHyoji=" + fukushokuHyoji
				+ ", futanJuryo=" + futanJuryo + ", blinkerShiyoKubun=" + blinkerShiyoKubun + ", kishumei=" + kishumei
				+ ", kishumeiRyakusho=" + kishumeiRyakusho + ", kishuMinarai=" + kishuMinarai + ", bataiju=" + bataiju
				+ ", zogensa=" + zogensa + ", ijoKubun=" + ijoKubun + ", nyusenJuni=" + nyusenJuni
				+ ", kakuteiChakujun=" + kakuteiChakujun + ", sohaTime=" + sohaTime + ", corner1Juni=" + corner1Juni
				+ ", corner2Juni=" + corner2Juni + ", corner3Juni=" + corner3Juni + ", corner4Juni=" + corner4Juni
				+ ", tanshoOdds=" + tanshoOdds + ", tanshoNinkijun=" + tanshoNinkijun + ", kohan4F=" + kohan4F
				+ ", kohan3F=" + kohan3F + ", timeSa=" + timeSa + ", yobi=" + yobi + ", grade=" + grade
				+ ", kyosoShubetsu=" + kyosoShubetsu + ", kyosoKigo=" + kyosoKigo + ", juryoShubetsu=" + juryoShubetsu
				+ ", kyosoJoken=" + kyosoJoken + ", trackCode=" + trackCode + ", tenko=" + tenko + ", shibaBabaJotai="
				+ shibaBabaJotai + ", dirtBabaJotai=" + dirtBabaJotai + ", kyosomeiHondai=" + kyosomeiHondai
				+ ", kyosomeiRyakusho10=" + kyosomeiRyakusho10 + ", kyosomeiRyakusho6=" + kyosomeiRyakusho6
				+ ", kyosomeiKubun=" + kyosomeiKubun + ", jushoKaiji=" + jushoKaiji + ", kyori=" + kyori
				+ ", hassoJikoku=" + hassoJikoku + ", srun=" + srun + ", umaID=" + umaID + ", srunCount=" + srunCount
				+ "]";
	}

	/**
	 * 相手馬名1を返します
	 * @return 相手馬名1
	 */
	public String getAiteBamei1() {
		return aiteBamei1;
	}

	/**
	 * 相手馬名2を返します
	 * @return 相手馬名2
	 */
	public String getAiteBamei2() {
		return aiteBamei2;
	}

	/**
	 * 父の馬名を返します
	 * @return 父
	 */
	public String getFather() {
		return father;
	}

	/**
	 * 母の馬名を返します
	 * @return 母
	 */
	public String getMother() {
		return mother;
	}

	/**
	 * 母父の馬名を返します
	 * @return 母父
	 */
	public String getGrandfather() {
		return grandfather;
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
	 * レースの前半3Fの走破タイムを返します。
	 * @return 前半3F
	 */
	public BigDecimal getRaceZenhan3f() {
		return raceZenhan3f;
	}

	/**
	 * レースの前半4Fの走破タイムを返します。
	 * @return 前半4F
	 */
	public BigDecimal getRaceZenhan4f() {
		return raceZenhan4f;
	}

	/**
	 * レースの後半3Fの走破タイムを返します。
	 * @return 後半3F
	 */
	public BigDecimal getRaceKohan3f() {
		return raceKohan3f;
	}


	/**
	 * レースの後半4Fの走破タイムを返します。
	 * @return 後半4F
	 */
	public BigDecimal getRaceKohan4f() {
		return raceKohan4f;
	}

	/**
	 * レースのRPCI(ペースチェンジ指数）を返します。
	 * @return RPCI
	 */
	public BigDecimal getRPCI() {
		return RPCI;
	}

	/**
	 * 馬毎の上がり3Fの標準偏差を返します。
	 * @return 上がり3Fの標準偏差
	 */
	public BigDecimal getfPCI() {
		return fPCI;
	}

	/**
	 * 馬毎の脚質を返します。
	 * @return 脚質
	 */
	public String getKyakushitsu() {
		return kyakushitsu;
	}

	/**
	 * 馬毎の平均3Fタイムを返します。
	 * @return 平均3Fタイム
	 */
	public BigDecimal getAve3f() {
		return ave3f;
	}

	/**
	 * レースのSRUNを返します
	 * @return レースのSRUN
	 */
	public BigDecimal getRaceSrun() {
		return raceSrun;
	}

	/**
	 * 馬毎の斤量55kgにおけるSRUNを返します
	 * @return SRUN
	 */
	public BigDecimal getSrun55() {
		return srun55;
	}

	/** 脚質判定を返します
	 * @return 脚質判定
	 */
	public int getKyakushitsuHantei() {
		return kyakushitsuHantei;
	}

	public LapList getLap() {
		return lap;
	}

}
