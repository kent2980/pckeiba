package com.pckeiba.analysis;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.pckeiba.umagoto.UmagotoDataLoad;
import com.pckeiba.umagoto.UmagotoDataSet;

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

			//countが1の場合は"連闘"を返す
			String countWeek = count <= 1 ? "連闘" : "中" + String.format("%02d", count) + "週";

			return countWeek;
		}catch(IndexOutOfBoundsException e) {
			return "-";
		}
	}

	/**
	 * 馬毎の想定脚質を判定します
	 * @param 血統登録番号
	 * @return 想定脚質
	 */
	public int getPredictionKyakushitsuHantei(String kettoTorokuBango) {
		List<Integer> hantei = umagotoData.getList().stream()
													.filter(s -> s.getKettoTorokuBango().equals(kettoTorokuBango))
													.filter(s -> s.getUmaID() > 1)
													.filter(s -> s.getKyakushitsuHantei() > 0)
													.map(s -> s.getKyakushitsuHantei())
													.collect(Collectors.toList());
		boolean fled = hantei.stream()
				 			 .anyMatch(s -> s.intValue() == 1);
		if(fled == true) {
			return 1;
		}
		//脚質判定の最頻値を求めます
		Map<Integer,Integer> modeMap = new HashMap<Integer, Integer>();
		hantei.stream()
		.forEach(x -> {
			if( modeMap.containsKey(x) ){
				modeMap.put(x, modeMap.get(x)+1);
			} else {
				modeMap.put(x, 1);
			}
		});

		int maxValue = 0;
		int maxKey = 0;

		for (Entry<Integer, Integer> entry : modeMap.entrySet()) {
			if (maxValue < entry.getValue()) {
				maxValue = entry.getValue();
				maxKey = entry.getKey();
			}
		}

		return maxKey;
	}

	/**
	 * 馬毎の想定脚質を判定します
	 * @param 馬番
	 * @return 想定脚質
	 */
	public int getPredictionKyakushitsuHantei(int umaban) {
		List<Integer> hantei = umagotoData.getList().stream()
													.filter(s -> s.getUmaGroup() == umaban)
													.filter(s -> s.getUmaID() > 1)
													.filter(s -> s.getKyakushitsuHantei() > 0)
													.map(s -> s.getKyakushitsuHantei())
													.collect(Collectors.toList());
		boolean fled = hantei.stream()
							 .anyMatch(s -> s.intValue() == 1);
		if(fled == true) {
			return 1;
		}
		//脚質判定の最頻値を求めます
		Map<Integer,Integer> modeMap = new HashMap<Integer, Integer>();
		hantei.stream()
		.forEach(x -> {
			if( modeMap.containsKey(x) ){
				modeMap.put(x, modeMap.get(x)+1);
			} else {
				modeMap.put(x, 1);
			}
		});

		int maxValue = 0;
		int maxKey = 0;

		for (Entry<Integer, Integer> entry : modeMap.entrySet()) {
			if (maxValue < entry.getValue()) {
				maxValue = entry.getValue();
				maxKey = entry.getKey();
			}
		}

		return maxKey;
	}

	/**
	 * 馬毎の想定脚質を返します
	 * @param 馬番
	 * @return 想定脚質
	 */
	public String getPredictionKyakushitsu(int umaban) {
		int hantei = getPredictionKyakushitsuHantei(umaban);

		switch(hantei) {
		case 1:
			return "逃げ";
		case 2:
			return "先行";
		case 3:
			return "差し";
		case 4:
			return "追込";
		default:
			return "不明";
		}
	}

	/**
	 * 馬毎の想定脚質を返します
	 * @param 血統登録番号
	 * @return 想定脚質
	 */
	public String getPredictionKyakushitsu(String kettoTorokuBango) {
		int hantei = getPredictionKyakushitsuHantei(kettoTorokuBango);

		switch(hantei) {
		case 1:
			return "逃げ";
		case 2:
			return "先行";
		case 3:
			return "差し";
		case 4:
			return "追込";
		default:
			return "不明";
		}
	}

	/**
	 * 指定した脚質に属する馬名を返します
	 * @param kyakushitsu　脚質	1→逃げ,2→先行,3→差し,4→追込み
	 * @return　馬名一覧
	 */
	public List<String> getKyakushitsuLabel(int kyakushitsu) {
		List<UmagotoDataSet> list = umagotoData.getList();
		List<String> kyakushitsuLabel = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			String bamei = list.get(i).getBamei();
			String kettoTorokuBango = list.get(i).getKettoTorokuBango();
			int hantei = getPredictionKyakushitsuHantei(kettoTorokuBango);
			if(hantei == kyakushitsu) {
				kyakushitsuLabel.add(bamei);
			}
		}
		return kyakushitsuLabel.stream()
							   .distinct()
							   .collect(Collectors.toList());
	}

}
