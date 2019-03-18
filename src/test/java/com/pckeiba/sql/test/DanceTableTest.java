package com.pckeiba.sql.test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.pckeiba.sql.MyDBConnection;

public class DanceTableTest {
	private List<DanceTableSet> list = new ArrayList<>();

	public static void main(String[] args) {
		List<DanceTableSet> l = new DanceTableTest("2018042908030411").getList();
	}

	public DanceTableTest(String raceCode) {
		String sql = "call Drun_Out(?)";

		try(MyDBConnection con = MyDBConnection.getInstance();
			PreparedStatement pstmt = con.getPreparedStatement(sql)){

			pstmt.setString(1, raceCode);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(6));
			}
			
		}catch( Exception e) {

		}
	}

	public List<DanceTableSet> getList() {
		return list;
	}

}

