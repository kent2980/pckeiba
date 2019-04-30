/**
 *
 */
package com.pckeiba.analysis;

import java.math.BigDecimal;

import com.pckeiba.racedata.RaceDataSet;
import com.pckeiba.umagoto.UmagotoDataSet;

/**
 * @author KentaroYoshida
 *
 */
public class HomestretchAnalysis {

	/**
	 *
	 */
	private BigDecimal topForm;
	private BigDecimal beginsForm;
	private BigDecimal raceTopForm;
	private UmagotoDataSet umaData;
	private RaceDataSet raceData;
	private BigDecimal kohan3fDistanceFromTheBeginning;
	private BigDecimal raceSohaTime;
	private BigDecimal topForm_s;
	private BigDecimal beginsForm_s;
	private BigDecimal chakusa_m;
	private BigDecimal TsumeAshi;
	private BigDecimal escapeCompare;

	public HomestretchAnalysis(UmagotoDataSet umaData, RaceDataSet raceData) {
		this.umaData = umaData;
		this.raceData = raceData;
		setTopForm();
		setRaceTopForm();
		setRaceSohaTime();
		setKohan3fDistanceFromTheBeginning();
		setTopForm_s();
		setBeginsForm();
		setBeginsForm_s();
		setChakusa_m();
		setTsumeAshi();
		setEscapeCompare();
	}
	public BigDecimal getTopForm() {
		return topForm;
	}

	private void setTopForm() {
		try {
			BigDecimal umaKohan3f = umaData.getKohan3F();
			topForm = BigDecimal.valueOf(600).divide(umaKohan3f, 1, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(3.6)).setScale(1, BigDecimal.ROUND_HALF_UP);
		}catch(ArithmeticException e) {
			topForm = BigDecimal.ZERO;
		}
	}

	public UmagotoDataSet getUmaData() {
		return umaData;
	}
	public void setUmaData(UmagotoDataSet umaData) {
		this.umaData = umaData;
	}
	public RaceDataSet getRaceData() {
		return raceData;
	}
	public void setRaceData(RaceDataSet raceData) {
		this.raceData = raceData;
	}
	public BigDecimal getKohan3fDistanceFromTheBeginning() {
		return kohan3fDistanceFromTheBeginning;
	}
	private void setKohan3fDistanceFromTheBeginning() {
		try {
			BigDecimal raceKohan3fTime = raceSohaTime.subtract(raceData.getKohan3f());
			BigDecimal umaKohan3fTime = umaData.getSohaTime().subtract(umaData.getKohan3F());
			BigDecimal timeSa = umaKohan3fTime.subtract(raceKohan3fTime);
			this.kohan3fDistanceFromTheBeginning = timeSa.multiply(topForm).divide(BigDecimal.valueOf(3.6), 1, BigDecimal.ROUND_HALF_UP);
			this.kohan3fDistanceFromTheBeginning = this.kohan3fDistanceFromTheBeginning.negate();
		}catch(ArithmeticException e) {
			this.kohan3fDistanceFromTheBeginning = BigDecimal.ZERO;
		}
	}

	public BigDecimal getRaceTopForm() {
		return raceTopForm;
	}
	private void setRaceTopForm() {
		try {
			BigDecimal umaKohan3f = raceData.getKohan3f();
			raceTopForm = BigDecimal.valueOf(600).divide(umaKohan3f, 2, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(3.6)).setScale(1, BigDecimal.ROUND_HALF_UP);
		}catch(ArithmeticException e) {
			raceTopForm = BigDecimal.ZERO;
		}
	}
	public BigDecimal getRaceSohaTime() {
		return raceSohaTime;
	}
	private void setRaceSohaTime() {
		BigDecimal[] lapTime = raceData.getLapTime();
		BigDecimal sohaTime = BigDecimal.ZERO;
		for(BigDecimal lap: lapTime) {
			sohaTime = sohaTime.add(lap);
		}
		this.raceSohaTime = sohaTime;
	}
	public BigDecimal getTopForm_s() {
		return topForm_s;
	}
	private void setTopForm_s() {
		try{
			this.topForm_s = topForm.multiply(BigDecimal.valueOf(1000)).divide(BigDecimal.valueOf(3600), 2, BigDecimal.ROUND_HALF_UP);
		}catch(ArithmeticException e) {
			this.topForm_s = BigDecimal.ZERO;
		}
	}
	public BigDecimal getBeginsForm() {
		return beginsForm;
	}
	private void setBeginsForm() {
		try {
			BigDecimal beginsTime = umaData.getSohaTime().subtract(umaData.getKohan3F());
			BigDecimal beginsKyori = BigDecimal.valueOf(raceData.getKyori() - 600);
			this.beginsForm = beginsKyori.divide(beginsTime,2 , BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(3.6)).setScale(1, BigDecimal.ROUND_HALF_UP);
		}catch(ArithmeticException e) {
			this.beginsForm = BigDecimal.ZERO;
		}
	}

	public BigDecimal getBeginsForm_s() {
		return beginsForm_s;
	}
	private void setBeginsForm_s() {
		try {
			this.beginsForm_s = beginsForm.multiply(BigDecimal.valueOf(1000)).divide(BigDecimal.valueOf(3600), 2, BigDecimal.ROUND_HALF_UP);
		}catch(ArithmeticException e) {
			this.beginsForm_s = BigDecimal.ZERO;
		}
	}
	public BigDecimal getChakusa_m() {
		return chakusa_m;
	}
	private void setChakusa_m() {
		try {
			BigDecimal timeSa = umaData.getTimeSa().negate();
			this.chakusa_m = topForm.multiply(BigDecimal.valueOf(1000)).divide(BigDecimal.valueOf(3600),2,BigDecimal.ROUND_HALF_UP).multiply(timeSa).setScale(1,BigDecimal.ROUND_HALF_UP);
		}catch(ArithmeticException e) {
			this.chakusa_m = BigDecimal.ZERO;
		}
	}
	public BigDecimal getTsumeAshi() {
		return TsumeAshi;
	}
	public void setTsumeAshi() {
		TsumeAshi = chakusa_m.subtract(kohan3fDistanceFromTheBeginning);
	}
	public BigDecimal getEscapeCompare() {
		return escapeCompare;
	}
	public void setEscapeCompare() {
		try {
		BigDecimal compareLap = BigDecimal.ZERO;
		BigDecimal zenhanKyori = BigDecimal.valueOf(raceData.getKyori()-600);
		int fQty = zenhanKyori.divide(BigDecimal.valueOf(200), 0, BigDecimal.ROUND_CEILING).intValue();
		for(int i = 0;i < fQty; i++) {
			compareLap = compareLap.add(raceData.getLapTime()[i]);
		}
		BigDecimal escapeForm = zenhanKyori.divide(compareLap,2 , BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(3.6)).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.escapeCompare = (escapeForm.divide(beginsForm, 10 ,BigDecimal.ROUND_HALF_UP).subtract(BigDecimal.ONE)).multiply(BigDecimal.valueOf(3000));
		this.escapeCompare = escapeCompare.setScale(2, BigDecimal.ROUND_HALF_UP);
		}catch(ArithmeticException e) {
			this.chakusa_m = BigDecimal.ZERO;
		}
	}

}
