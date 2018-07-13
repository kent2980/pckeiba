package com.pckeiba.analysis;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.pckeiba.umagoto.UmagotoDataLoad;

/**
 * 馬毎データから様々な分析を行うクラス
 * @author kent2
 *
 */
public class UmagotoAnalysis {
	private UmagotoDataLoad umagotoData;

	/**
	 * コンストラクタ<br>
	 * 初期化を行います
	 * @param umagotoData 馬毎データ
	 */
	public UmagotoAnalysis(UmagotoDataLoad umagotoData) {
		//各UmagotoDataの初期化を行う
		this.umagotoData = umagotoData;
	}

	/**
	 * 競争実績から距離適性の評価を行います<br>
	 * 引数に馬番を指定してください
	 * @param umaban 馬番
	 * @return 距離適性の評価印
	 */
	public String getDistanceAnalisis(int umaban) {
		//指定された馬番の距離をリストに纏めます
		List<Integer> DistanceList = umagotoData.getList().stream()
														  .filter(s -> s.getUmaGroup() == umaban)
														  .map(s -> s.getKyori())
														  .collect(Collectors.toList());
		//距離の比較を行い評価を分類します
		int reference = DistanceList.get(0); //基準の距離
		//基準の距離をリストから削除します
		DistanceList.remove(0);
		//基準の距離との比較を行います
		int i = 0;
		for(int Distance : DistanceList) {
			if(reference <= Distance) {
				i++;
			}
		}
		//評価を行います
		String evaluation = null;
		switch(i) {
		case 0:
			evaluation = "×";
			break;
		case 1:
			evaluation = "△";
			break;
		case 2:
			evaluation = "▲";
			break;
		case 3:
			evaluation = "〇";
			break;
		case 4:
			evaluation = "◎";
			break;
		}
		return evaluation;
	}

	/**
	 * 前走からのレース間隔を返します<br>
	 * 引数に馬番を指定してください
	 * @param umaban 馬番
	 * @return レース間隔（週）
	 */
	public String getRaceInterval(int umaban) {
		//指定された馬番の距離をリストに纏めます
		List<String> dateList = umagotoData.getList().stream()
														  .filter(s -> s.getUmaGroup() == umaban)
														  .map(s -> s.getKaisaiNenGappi())
														  .collect(Collectors.toList());

		try {
			//LocalDateに変換します
			LocalDateTime nowRace = LocalDate.parse(dateList.get(0), DateTimeFormatter.ofPattern("yyyy年MM月dd日")).atStartOfDay();	//今走の開催年月日
			LocalDateTime beforRace = LocalDate.parse(dateList.get(1), DateTimeFormatter.ofPattern("yyyy年MM月dd日")).atStartOfDay();	//前走の開催年月日

			//レース間隔を計算します
			Duration duration = Duration.between(beforRace, nowRace);
			long count = duration.toDays() / 7;
			String countWeek = "中" + String.format("%02d", count) + "週";

			return countWeek;
		}catch(IndexOutOfBoundsException e) {
			return "-";
		}
	}
}
