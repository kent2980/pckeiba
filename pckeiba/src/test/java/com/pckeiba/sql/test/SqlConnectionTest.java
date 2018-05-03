package com.pckeiba.sql.test;

import java.time.LocalDate;

import com.pckeiba.racecode.RaceCodeSet;
import com.pckeiba.sql.MyDBConnection;
import com.pckeiba.umagoto.UmagotoDataLoad;
import com.pckeiba.umagoto.UmagotoDataSet;

/**
 * レースコード取得テストの為のクラス
 * 結果がtrueなら成功です
 * @author kent
 *
 */
public class SqlConnectionTest {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2018, 04, 29);
		RaceCodeSet rs = new RaceCodeSet(date,"京都",11);
		UmagotoDataLoad rds = new UmagotoDataLoad(rs.getRaceCode(),5);
		for(UmagotoDataSet set : rds.getList()) {
			System.out.println(set);
		}
		
		MyDBConnection.getInstanse().close();
	}

}
