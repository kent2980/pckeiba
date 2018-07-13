package com.pckeiba.analysis;

import java.util.List;
import java.util.stream.Collectors;

import com.pckeiba.umagoto.UmagotoDataLoad;

/**
 * 距離適性の分析を行うクラス
 * @author kent2
 *
 */
public class DistanceAnalysis {
	private UmagotoDataLoad umagotoData;

	/**
	 * コンストラクタ<br>
	 * 初期化を行います
	 * @param umagotoData 馬毎データ
	 */
	public DistanceAnalysis(UmagotoDataLoad umagotoData) {
		//各UmagotoDataの初期化を行う
		this.umagotoData = umagotoData;
	}

	/**
	 * 競争実績から距離適性の評価を行います<br>
	 * 引数に馬番を指定してください
	 * @param umaban 馬番
	 * @return 距離適性の評価印
	 */
	public String getAnalisis(int umaban) {
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
}
