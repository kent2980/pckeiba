package com.pckeiba.schedule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 指定された年号の開催スケジュールをダウンロードします
 * @author kent2
 *
 */
public class SelectYearSchedule {
	private final String sql = "CALL KYOSO_SCHEDULE(?)";
	private List<KaisaiScheduleSet> scheduleList;

	/**
	 * コンストラクタ<br>
	 * 引数に西暦で年号を指定してください
	 * @param year 年号
	 */
	public SelectYearSchedule(int year) {
		scheduleList = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("MySQLのドライバが見つかりません");
			e1.printStackTrace();
		}
		try(Connection con = DriverManager.getConnection("jdbc:mysql://192.168.10.60:3306/srun_project?autoReconnect=true&useSSL=false", "root", "kent6839");
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, year);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				//重賞01
				int i = 8;
				JushoKyosoDataSet kyosoData1 = new JushoKyosoDataSet(rs.getInt(i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getInt(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getInt(++i),rs.getString(++i));
				//重賞02
				i = 20;
				JushoKyosoDataSet kyosoData2 = new JushoKyosoDataSet(rs.getInt(i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getInt(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getInt(++i),rs.getString(++i));
				//重賞03
				i = 32;
				JushoKyosoDataSet kyosoData3 = new JushoKyosoDataSet(rs.getInt(i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getInt(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getInt(++i),rs.getString(++i));

				i = 1;
				KaisaiScheduleSet scheduleSet = new KaisaiScheduleSet(rs.getInt(i),rs.getString(++i),rs.getDate(++i).toLocalDate(),rs.getString(++i),rs.getInt(++i),rs.getInt(++i),rs.getString(++i), kyosoData1, kyosoData2, kyosoData3);

				scheduleList.add(scheduleSet);
			}
		}catch(SQLException e) {
			System.out.println("データベースへの接続が確立できませんでした");
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		List<KaisaiScheduleSet> list = new SelectYearSchedule(2015).scheduleList;
		for(KaisaiScheduleSet set: list) {
			System.out.println(set.getKaisaiNengappi());
			System.out.println(set.getJusho1().getKyosomeiHondai());
		}

	}

	/**
	 * 開催スケジュールの一覧をリストで返します
	 * @return
	 */
	public List<KaisaiScheduleSet> getScheduleList() {
		return scheduleList;
	}
}
