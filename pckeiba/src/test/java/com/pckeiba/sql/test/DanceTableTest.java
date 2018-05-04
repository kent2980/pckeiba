package com.pckeiba.sql.test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pckeiba.sql.MyDBConnection;

public class DanceTableTest {
	private List<DanceTableSet> list = new ArrayList<>();

	public static void main(String[] args) {
		List<DanceTableSet> l = new DanceTableTest("2018042908030411").getList();
		System.out.println(l.size());
	}

	public DanceTableTest(String raceCode) {
		String sql = "CALL TEST(?)";

		try(Connection con = MyDBConnection.getInstanse().getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, raceCode);
			ResultSet rs = pstmt.executeQuery();
			String bamei = "a";
			int i = 0;
			BigDecimal bd = BigDecimal.ZERO;
			while(rs.next()) {
				@SuppressWarnings("unused")
				DanceTableSet dt = null;
				if(bamei.equals("a")||!bamei.equals(rs.getString(4))) {
					i = 0;
					bd = BigDecimal.ZERO;
				}
				i++;
				if(i <= 5) {
					@SuppressWarnings("unused")
					int t = 0;
					System.out.println(rs.getString(4) + "," + rs.getString(49));
					list.add(new DanceTableSet(i,rs.getString(4),rs.getString(49)));
					if(i > 1 && !(rs.getBigDecimal(51) ==null)) {
						BigDecimal bom = rs.getBigDecimal(51);
						bd.add(bom);
						t++;
					}
				}
				bamei = rs.getString(4);
			}

		}catch(SQLException e) {

		}
	}

	public List<DanceTableSet> getList() {
		return list;
	}

}

