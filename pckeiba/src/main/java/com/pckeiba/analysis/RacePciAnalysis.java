package com.pckeiba.analysis;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.pckeiba.umagoto.UmagotoDataLoad;

public class RacePciAnalysis {
	//フィールドを定義する
	private UmagotoDataLoad umagotoData;
	private BigDecimal racePci;

	/*
	 * コンストラクタ
	 */
	public RacePciAnalysis(UmagotoDataLoad umagotoData) {
		super();
		this.umagotoData = umagotoData;
	}

	public BigDecimal getRacePci() {
		return racePci;
	}

	public void setRacePci(int umaban) {
		List<BigDecimal> raceZenhan3f;
		List<BigDecimal> kohan3f;
		raceZenhan3f = this.umagotoData.getList().stream()
								  .filter(s -> s.getUmaban() == umaban)
								  .map(s -> s.getRaceZenhan3f())
								  .collect(Collectors.toList());
		kohan3f = this.umagotoData.getList().stream()
								  .filter(s -> s.getUmaban() == umaban)
								  .map(s -> s.getKohan3F())
								  .collect(Collectors.toList());
	}


}
