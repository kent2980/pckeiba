package com.pckeiba.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

/**
 * データベース接続のインスタンスを提供します<br>
 * このクラスはシングルトンです。データベースへの接続を常に保証します。
 * @author kent2
 *
 */
public enum MyDBConnection implements AutoCloseable{
	INSTANCE;

	/**
	 * データベース接続のインスタンスを返します
	 * @return データベース接続のインスタンス
	 */
	public static MyDBConnection getInstance() {
		return INSTANCE;
	}

	private static Connection connection;

	/**
	 * データベースへの接続がない場合に、データベースへの再接続を行います
	 * @return データベースConnection
	 * @throws SQLException SQL接続時の例外
	 * @throws NamingException 例外
	 */
	public synchronized static Connection getConnection() throws SQLException,NamingException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ドライバをロードできません");
			e.printStackTrace();
		}
		try(Connection connection = MyDBConnection.connection){
			if(MyDBConnection.connection == null || MyDBConnection.connection.isClosed())
				MyDBConnection.connection = DriverManager.getConnection("jdbc:mysql://192.168.10.60:3306/srun_project?autoReconnect=true&useSSL=false", "root", "kent6839");
		}
		return connection;
	}

	/**
	 * SQLの命令を実行するクラス
	 * @param sql SQLの命令文
	 * @return 結果オブジェクト
	 * @throws Exception 発生するすべての例外
	 */
	public PreparedStatement getPreparedStatement(String sql) throws Exception {
		return getConnection().prepareStatement(sql);
	}

	/**
	 * SQLの命令をコミットします
	 * @throws SQLException SQL接続時の例外
	 */
	public void commit() throws SQLException {
		try(Connection connection = MyDBConnection.connection){
			MyDBConnection.connection.commit();
		}
	}

	/**
	 * SQLの命令をロールバックします
	 * @throws SQLException SQL接続時の例外
	 */
	public void rollback() throws SQLException {
		try (Connection connection = MyDBConnection.connection){
			MyDBConnection.connection.rollback();
		}
	}

	/**
	 * データベースの安全なクローズを提供します
	 */
	@Override
	public void close() throws Exception {
		try(Connection connection = MyDBConnection.connection){
			MyDBConnection.connection.close();
		}
	}


}
