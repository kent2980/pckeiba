/**
 *
 */
package com.pckeiba.list;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author kent2
 *
 */
public class LapList extends ArrayList<BigDecimal> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private int kyori;
	private int hiSpeedPoint;
	private int slowSpeedPoint;
	private int pace;
	private int speedUpperPoint;
	private int speedLowerPoint;
	private BigDecimal raceKohan3f;
	private String lapType;
	private String advantage;
	private BigDecimal zenhan1000mAverageLap;
	private BigDecimal cornerAverageLap;
	private BigDecimal kohan3fAverageLap;
	private String racePace;
	private String raceType;

	/**
	 *
	 */
	public LapList(){}

	/* (非 Javadoc)
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	@Override
	public boolean add(BigDecimal e) {
		if(e.compareTo(BigDecimal.ZERO) > 0) {
			boolean flag = super.add(e);
			this.setKyori();
			this.setSlowSpeedPoint();
			this.setHiSpeedPoint();
			this.setSpeedLowerPoint();
			this.setSpeedUpperPoint();
			this.setRaceKohan3f();
			this.setLapType();
			this.setKohan3fAverageLap();
			this.setCornerAverageLap();
			this.setZenhan1000mAverageLap();
			this.setRacePace();
			this.setRaceType();
			return flag;
		}
		return false;
	}

	/* (非 Javadoc)
	 * @see java.util.ArrayList#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, BigDecimal element) {
		if(element.compareTo(BigDecimal.ZERO) > 0) {
			super.add(index, element);
			this.setKyori();
			this.setSlowSpeedPoint();
			this.setHiSpeedPoint();
			this.setSpeedLowerPoint();
			this.setSpeedUpperPoint();
			this.setRaceKohan3f();
			this.setLapType();
			this.setKohan3fAverageLap();
			this.setCornerAverageLap();
			this.setZenhan1000mAverageLap();
			this.setRacePace();
			this.setRaceType();
		}
	}

	/**
	 * @return hiSpeedPoint
	 */
	public int getHiSpeedPoint() {
		return hiSpeedPoint;
	}

	/**
	 * @return kyori
	 */
	public int getKyori() {
		return kyori;
	}

	/**
	 * @return pace
	 */
	public int getPace() {
		return pace;
	}

	/**
	 * @return slowSpeedPoint
	 */
	public int getSlowSpeedPoint() {
		return slowSpeedPoint;
	}

	/**
	 * @return speedLevel
	 */
	public int getSpeedLevel(int point) {
		BigDecimal time = this.get(point);
		if(time.compareTo(BigDecimal.valueOf(11.1)) < 0) {
			return 0;
		}else if(time.compareTo(BigDecimal.valueOf(11.6)) < 0) {
			return 1;
		}else if(time.compareTo(BigDecimal.valueOf(12.1)) < 0) {
			return 2;
		}else if(time.compareTo(BigDecimal.valueOf(12.6)) < 0) {
			return 3;
		}else if(time.compareTo(BigDecimal.valueOf(13.1)) < 0) {
			return 4;
		}else {
			return 5;
		}
	}

	/**
	 * @return speedLowerPoint
	 */
	public int getSpeedLowerPoint() {
		return speedLowerPoint;
	}

	/**
	 * @return speedUpperPoint
	 */
	public int getSpeedUpperPoint() {
		return speedUpperPoint;
	}

	/**
	 * @param hiSpeedPoint セットする hiSpeedPoint
	 */
	public void setHiSpeedPoint() {
		double time = this.get(0).doubleValue();
		int point = 0;
		for(int i = 1; i < this.size(); i++) {
			if(this.get(i).doubleValue() < time) {
				time = this.get(i).doubleValue();
				point = i;
			}
		}
		this.hiSpeedPoint = point;
	}

	/**
	 * @param kyori セットする kyori
	 */
	private void setKyori() {
		long half = this.stream()
					    .filter(s -> s.compareTo(BigDecimal.valueOf(9.0)) < 0)
				   	    .count() * 100;
		long furlong = this.stream()
						   .filter(s -> s.compareTo(BigDecimal.valueOf(9.0)) > 0)
						   .count() * 200;
		kyori = (int) (half + furlong);
	}

	/**
	 * @param pace セットする pace
	 */
	private void setPace() {

		this.pace = pace;
	}

	/**
	 * @param slowSpeedPoint セットする slowSpeedPoint
	 */
	private void setSlowSpeedPoint() {
		double time = this.get(0).doubleValue();
		int point = 0;
		for(int i = 1; i < this.size(); i++) {
			if(this.get(i).doubleValue() > time) {
				time = this.get(i).doubleValue();
				point = i;
			}
		}
		this.slowSpeedPoint = point;
	}

	/**
	 * @param speedLowerPoint セットする speedLowerPoint
	 */
	private void setSpeedLowerPoint() {
		if(this.size() > 3) {
			double time = this.get(1).doubleValue();
			double timeLag = 0.0;
			int point = 0;
			for(int i = 2; i < this.size(); i++) {
				double lag = this.get(i).doubleValue() - this.get(i-1).doubleValue();
				if(lag > timeLag ) {
					timeLag = this.get(i).doubleValue() - this.get(i-1).doubleValue();
					point = i;
				}
			}
			this.speedLowerPoint = point;
		}
	}

	/**
	 * @param speedUpperPoint セットする speedUpperPoint
	 */
	private void setSpeedUpperPoint() {
		if(this.size() > 3) {
			double time = this.get(1).doubleValue();
			double timeLag = 0.0;
			int point = 0;
			for(int i = 2; i < this.size(); i++) {
				double lag = this.get(i-1).doubleValue() - this.get(i).doubleValue();
				if(lag > timeLag ) {
					timeLag = this.get(i-1).doubleValue() - this.get(i).doubleValue();
					point = i;
				}
			}
			this.speedUpperPoint = point;
		}
	}
	/**
	 * @return raceKohan3f
	 */
	public BigDecimal getRaceKohan3f() {
		return raceKohan3f;
	}
	/**
	 * @param raceKohan3f セットする raceKohan3f
	 */
	private void setRaceKohan3f() {
		this.raceKohan3f = BigDecimal.ZERO;
		if(this.size() > 2) {
			ArrayList<BigDecimal> rk3f = new ArrayList<>();
			for(BigDecimal time: this) {
				rk3f.add(time);
			}
			Collections.reverse(rk3f);
			for(int x = 0; x < rk3f.size(); x++){
				if(rk3f.get(x).equals(BigDecimal.valueOf(0.0))){
					rk3f.remove(x--);
				}
			}
			for(int x = 0; x < 3; x++){
				this.raceKohan3f = rk3f.get(x).add(this.raceKohan3f);
			}
		}
	}
	/**
	 * @return lapType
	 */
	public String getLapType() {
		return lapType;
	}
	/**
	 * @param lapType セットする lapType
	 */
	private void setLapType() {
		int listSize = this.size();
		if(listSize > 3) {
			BigDecimal first = this.get(listSize - 3);
			BigDecimal second = this.get(listSize - 2);
			BigDecimal third = this.get(listSize - 1);

			if(first.compareTo(second) > 0 & second.compareTo(third) > 0) {
				this.lapType = "加速ラップ";
			}else if(second.compareTo(third) < 0) {
				this.lapType = "減速ラップ";
			}
		}else {
			this.lapType = null;
		}
	}

	public String getAdvantage() {
		return advantage;
	}
	private void setAdvantage() {}

	public BigDecimal getZenhan1000mAverageLap() {
		return zenhan1000mAverageLap;
	}

	private void setZenhan1000mAverageLap() {
		BigDecimal lap = BigDecimal.ZERO;
		if(this.size() >= 5) {
			BigDecimal drive = BigDecimal.valueOf(5);
			if(this.get(0).compareTo(BigDecimal.TEN) < 0) {
				drive = BigDecimal.valueOf(4.5);
			}
			for(int i = 0; i < 5; i++) {
				lap = lap.add(this.get(i));
			}
			lap = lap.divide(drive, 1, BigDecimal.ROUND_HALF_UP);
		}
		this.zenhan1000mAverageLap = lap;
	}

	public BigDecimal getCornerAverageLap() {
		return cornerAverageLap;
	}

	private void setCornerAverageLap() {
		if(this.size() >= 4) {
			this.cornerAverageLap = this.get(this.size()-4);
		}
	}

	public BigDecimal getKohan3fAverageLap() {
		return kohan3fAverageLap;
	}

	private void setKohan3fAverageLap() {
		if(this.size() >= 3) {
			BigDecimal lap = this.getRaceKohan3f().divide(BigDecimal.valueOf(3), 1, BigDecimal.ROUND_HALF_UP);
			this.kohan3fAverageLap = lap;
		}
	}

	/**
	 * @return racePace
	 */
	public String getRacePace() {
		return racePace;
	}

	/**
	 * @param racePace セットする racePace
	 */
	private void setRacePace() {
		if(this.size() > 5) {
			BigDecimal lapSum1 = BigDecimal.ZERO;
			int i = 0;
			for(; i < this.size(); i++) {
				BigDecimal lap = this.get(i);
				if(lap.compareTo(BigDecimal.TEN) < 0) {
					lap = lap.multiply(BigDecimal.valueOf(2));
				}
				lapSum1 = lapSum1.add(lap);
				if(i + 1 >= this.size() / 2) {
					i++;
					break;
				}
			}
			BigDecimal lapSum2 = BigDecimal.ZERO;
			if((this.kyori/200)%2 != 0) {
				i++;
			}
			for(; i < this.size(); i++) {
				lapSum2 = lapSum2.add(this.get(i));
			}
			if(lapSum1.add(BigDecimal.ONE).compareTo(lapSum2) < 0) {
				this.racePace = "Hi";
			}else if(lapSum2.add(BigDecimal.ONE).compareTo(lapSum1) < 0) {
				this.racePace = "Slow";
			}else {
				this.racePace = "Middle";
			}
		}
	}

	/**
	 * @return raceType
	 */
	public String getRaceType() {
		return raceType;
	}

	/**
	 * @param raceType セットする raceType
	 */
	private void setRaceType() {
		if(this.size() > 5) {
			switch(this.getRacePace()) {
			case "Slow":
				if(this.zenhan1000mAverageLap.compareTo(this.cornerAverageLap) <= 0 & this.cornerAverageLap.compareTo(this.kohan3fAverageLap) > 0) {
					raceType = "ヨーイドン型";
				}else {
					raceType = "右肩上がり型";
				}
				break;
			case "Hi":
				if(this.zenhan1000mAverageLap.compareTo(this.cornerAverageLap.subtract(BigDecimal.valueOf(0.5))) < 0) {
					raceType = "直線手前スロー型";
				}else {
					raceType = "一本調子型";
				}
				break;
			case "Middle":
				if(this.get(this.getHiSpeedPoint()).add(BigDecimal.ONE).compareTo(this.get(this.getSlowSpeedPoint())) > 0) {
					raceType = "緩急型";
				}else {
					raceType = "一定型";
				}
			}
		}
	}
}
