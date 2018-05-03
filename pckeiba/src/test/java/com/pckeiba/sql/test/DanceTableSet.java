package com.pckeiba.sql.test;

public class DanceTableSet {
	public DanceTableSet(int no, String bamei, String kyosomei) {
		No = no;
		this.bamei = bamei;
		this.kyosomei = kyosomei;
	}

	private int No;
	private String bamei;
	private String kyosomei;
	
	public int getNo() {
		return No;
	}
	public String getBamei() {
		return bamei;
	}
	public String getKyosomei() {
		return kyosomei;
	}
	
}