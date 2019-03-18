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
	public static void main(String[] args) {
		BigDecimal one = BigDecimal.ONE;
		BigDecimal two = BigDecimal.valueOf(2);
		BigDecimal ten = BigDecimal.TEN;
		LapList list = new LapList();
		list.add(BigDecimal.valueOf(12.1));
		list.add(BigDecimal.valueOf(5.7));
		list.add(BigDecimal.valueOf(7.7));
		list.add(BigDecimal.valueOf(12.1));
		list.add(BigDecimal.valueOf(22.8));
		list.add(BigDecimal.valueOf(14.9));
		list.add(BigDecimal.valueOf(12.8));
		list.add(BigDecimal.valueOf(12.5));
		list.add(BigDecimal.valueOf(10.8));
		list.add(BigDecimal.valueOf(11.9));
		for(BigDecimal time: list) {
			System.out.println(time);
		}
		System.out.println(list.getKyori());
		System.out.println("最も遅いポイントは" + list.getSlowSpeedPoint());
		System.out.println("最も速いポイントは" + list.getHiSpeedPoint());
		System.out.println("最も遅くなったポイントとは" + list.getSpeedLowerPoint());
		System.out.println("最も速くなったポイントとは" + list.getSpeedUpperPoint());
		System.out.println("次の地点のスピードレベルは" + list.getSpeedLevel(4));
		System.out.println("レースの上がり3Fは" + list.getRaceKohan3f());
	}
	private int kyori;
	private int hiSpeedPoint;
	private int slowSpeedPoint;
	private int pace;
	private int speedUpperPoint;
	private int speedLowerPoint;
	private BigDecimal raceKohan3f;
	private String lapType;

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
}
