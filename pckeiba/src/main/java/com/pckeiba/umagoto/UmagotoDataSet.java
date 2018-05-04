package com.pckeiba.umagoto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.util.DateTimeFormat;
import com.util.TrackCodeFormat;

/**
 * 出馬表に使用するためのデータセットクラスです。
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

	/**
	 * コンストラクタ finalなプロパティを設定します。
	 * @param umaGroup
	 * @param dataKubun
	 * @param raceCode
	 * @param kaisaiNenGappi
	 * @param bamei
	 * @param keibajo
	 * @param kaisaiKaiji
	 * @param kaisaiNichiji
	 * @param raceBango
	 * @param wakuban
	 * @param umaban
	 * @param kettoTorokuBango
	 * @param seibetsu
	 * @param barei
	 * @param hinshu
	 * @param moshoku
	 * @param tozaiShozoku
	 * @param chokyoshi
	 * @param banushi
	 * @param fukushokuHyoji
	 * @param futanJuryo
	 * @param blinkerShiyoKubun
	 * @param kishumei
	 * @param kishumeiRyakusho
	 * @param kishuMinarai
	 * @param bataiju
	 * @param zogensa
	 * @param ijoKubun
	 * @param nyusenJuni
	 * @param kakuteiChakujun
	 * @param sohaTime
	 * @param corner1Juni
	 * @param corner2Juni
	 * @param corner3Juni
	 * @param corner4Juni
	 * @param tanshoOdds
	 * @param tanshoNinkijun
	 * @param kohan4f
	 * @param kohan3f
	 * @param timeSa
	 * @param yobi
	 * @param grade
	 * @param kyosoShubetsu
	 * @param kyosoKigo
	 * @param juryoShubetsu
	 * @param kyosoJoken
	 * @param trackCode
	 * @param tenko
	 * @param shibaBabaJotai
	 * @param dirtBabaJotai
	 * @param kyosomeiHondai
	 * @param kyosomeiRyakusho10
	 * @param kyosomeiRyakusho6
	 * @param kyosomeiKubun
	 * @param jushoKaiji
	 * @param kyori
	 * @param hassoJikoku
	 * @param srun
	 * @param umaID
	 * @param srunCount
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
			String father, String mother, String grandFather, int torokuTosu, int shussoTosu, int umaID, int srunCount) {
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
	 * 開催年月日を返します。
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

	public String getAiteBamei1() {
		return aiteBamei1;
	}

	public String getAiteBamei2() {
		return aiteBamei2;
	}

	public String getFather() {
		return father;
	}

	public String getMother() {
		return mother;
	}

	public String getGrandfather() {
		return grandfather;
	}

	public int getTorokuTosu() {
		return torokuTosu;
	}

	public int getShussoTosu() {
		return shussoTosu;
	}
}
