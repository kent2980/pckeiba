package com.pckeiba.sql;

/**
 * データベースへの共通接続設定クラス<br>
 * このクラスは継承することが出来ません
 * @author kent2
 *
 */
public final class Constants {
	private Constants() {}

	/**
	 * データベース接続の為にstaticインスタンスを提供します
	 * @author kent2
	 *
	 */
	public static class FilePath{
		public static final String DATASOURCE_NAME = "jdbc:mysql://localhost:3306/srun_project?autoReconnect=true&useSSL=false";
	}

}
