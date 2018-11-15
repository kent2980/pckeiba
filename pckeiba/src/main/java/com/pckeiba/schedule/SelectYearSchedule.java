package com.pckeiba.schedule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 指定された年号の開催スケジュールをダウンロードします
 * @author kent2
 *
 */
public class SelectYearSchedule {
	private final String sql = "CALL KYOSO_SCHEDULE(?)";
	private List<KaisaiScheduleSet> scheduleList;
	private int year;

	/**
	 * コンストラクタ
	 */
	public SelectYearSchedule() {}
	/**
	 * コンストラクタ<br>
	 * 引数に西暦で年号を指定してください
	 * @param year 年号
	 */
	public SelectYearSchedule(int year) {
		setYear(year);
	}

	/**
	 * 開催スケジュールの一覧をリストで返します
	 * @return 開催スケジュール一覧
	 */
	public List<KaisaiScheduleSet> getScheduleList() {
		return scheduleList;
	}

	/**
	 * 開催スケジュールの一覧をリストで返します<br>
	 * 引数に指定した日付より前の開催スケジュールが返されます
	 * @param before 日付
	 * @return 開催スケジュール一覧
	 */
	public List<KaisaiScheduleSet> getScheduleList(LocalDate before){
		return scheduleList.stream()
						   .filter(s -> s.getKaisaiNengappi().isBefore(before))
						   .collect(Collectors.toList());
	}

	/**
	 * 選択中の年号を返します
	 * @return　年号
	 */
	public int getYear() {
		return year;
	}

	/**
	 * 引数に年号を指定して開催スケジュールをダウンロードします
	 * @param year 年号
	 */
	public void setYear(int year) {
		this.year = year;
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
				JushoKyosoDataSet kyosoData1 = new JushoKyosoDataSet(rs.getInt(i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getInt(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getInt(++i),rs.getString(++i), rs.getString(44));
				//重賞02
				i = 20;
				JushoKyosoDataSet kyosoData2 = new JushoKyosoDataSet(rs.getInt(i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getInt(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getInt(++i),rs.getString(++i), rs.getString(45));
				//重賞03
				i = 32;
				JushoKyosoDataSet kyosoData3 = new JushoKyosoDataSet(rs.getInt(i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getInt(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getInt(++i),rs.getString(++i), rs.getString(46));
				//メイン競争
				i = 50;
				JushoKyosoDataSet mainKyosoData = new JushoKyosoDataSet(0,rs.getString(i),rs.getString(++i),rs.getString(++i),rs.getString(++i),0,rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getString(++i),rs.getInt(++i),rs.getString(++i), rs.getString(++i));

				i = 1;
				KaisaiScheduleSet scheduleSet = new KaisaiScheduleSet(rs.getInt(i),rs.getString(++i),rs.getDate(++i).toLocalDate(),rs.getString(++i),rs.getInt(++i),rs.getInt(++i),rs.getString(++i), kyosoData1, kyosoData2, kyosoData3, mainKyosoData);

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
}
