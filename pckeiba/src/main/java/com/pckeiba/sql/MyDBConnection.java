package com.pckeiba.sql;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDBConnection implements Closeable{
	private static final MyDBConnection sc = new MyDBConnection();
	
	private MyDBConnection() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://192.168.10.60:3306/srun_project?autoReconnect=true&useSSL=false", "root", "kent6839");
		} catch (SQLException e) {
			System.out.println("データベース接続に失敗しました。エラーコードを確認してください。");
			System.out.println(e.getStackTrace());
		}
	}
	
	public static MyDBConnection getInstanse() {
		return sc;		
	}
	
	public  Connection getConnection () {
		return sc.con;
	}
	
	public  void close() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("データベース接続を終了できませんでした。");
			System.out.println(e.getStackTrace());
		}
	}
	
	private Connection con;
}
