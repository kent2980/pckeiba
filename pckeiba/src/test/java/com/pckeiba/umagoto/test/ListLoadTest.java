package com.pckeiba.umagoto.test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pckeiba.umagoto.UmagotoDataLoad;
import com.pckeiba.umagoto.UmagotoDataSet;

public class ListLoadTest {

	public static void main(String[] args) {
		//馬ID毎にリストを分割する
		UmagotoDataLoad udl = new UmagotoDataLoad("2018050505020501",5);
		udl.getDrun(4);
		System.out.println(udl.getMap(1).get(4).getBamei());
	}
}
