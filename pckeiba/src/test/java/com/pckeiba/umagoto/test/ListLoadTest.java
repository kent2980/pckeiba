package com.pckeiba.umagoto.test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pckeiba.umagoto.UmagotoDataLoad;
import com.pckeiba.umagoto.UmagotoDataSet;

public class ListLoadTest {

	public static void main(String[] args) {
		//馬ID毎にリストを分割する
		UmagotoDataLoad udl = new UmagotoDataLoad("2018042908030411",7);
		List<UmagotoDataSet> list = udl.getList();
		List<UmagotoDataSet> list1 = list.stream().filter(s -> s.getUmaID()==1).collect(Collectors.toList());
		List<UmagotoDataSet> list2 = list.stream().filter(s -> s.getUmaID()==2).collect(Collectors.toList());
		List<UmagotoDataSet> list3 = list.stream().filter(s -> s.getUmaID()==3).collect(Collectors.toList());
		List<UmagotoDataSet> list4 = list.stream().filter(s -> s.getUmaID()==4).collect(Collectors.toList());
		List<UmagotoDataSet> list5 = list.stream().filter(s -> s.getUmaID()==5).collect(Collectors.toList());
		System.out.println(list1.size());
		System.out.println(list2.size());
		System.out.println(list3.size());
		System.out.println(list4.size());
		System.out.println(list5.size());
		//リストからマップを作成する
		Map<String,UmagotoDataSet> map2 = udl.getMapFromKettoTorokuBango(2);
		Map<String,UmagotoDataSet> map3 = udl.getMapFromKettoTorokuBango(3);
		
		System.out.println(map2.size());
		System.out.println(map2.get(udl.getList().get(0).getKettoTorokuBango()).getKyosomeiHondai());
		System.out.println(map2.get(udl.getList().get(0).getKettoTorokuBango()).getKyosomeiHondai());
	}
}
