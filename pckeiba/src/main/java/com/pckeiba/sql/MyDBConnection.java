package com.pckeiba.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

public enum MyDBConnection implements AutoCloseable{
	INSTANCE;
	public static MyDBConnection getInstance() {
		return INSTANCE;
	}
	
	private static Connection connection;

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
	
	public PreparedStatement getPreparedStatement(String sql) throws Exception {
		return getConnection().prepareStatement(sql);
	}
	
	public void commit() throws SQLException {
		try(Connection connection = MyDBConnection.connection){
			MyDBConnection.connection.commit();
		}
	}
	
	public void rollback() throws SQLException {
		try (Connection connection = MyDBConnection.connection){
			MyDBConnection.connection.rollback();
		}
	}
	@Override
	public void close() throws Exception {
		try(Connection connection = MyDBConnection.connection){
			MyDBConnection.connection.close();
		}
	}

	
}
