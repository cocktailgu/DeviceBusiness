package com.msdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtil {
	public static String DBDRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String DBURL="jdbc:sqlserver://172.16.10.184:1433;databaseName=nf_dev";
	public static String DBUSER="sa";
	public static String DBPASS="123456";
	
	private static ResourceBundle rb = ResourceBundle.getBundle("com.msdatabase.db-config");
	
	private DBUtil(){}
	static{
		DBURL = rb.getString("jdbc.url");
		DBUSER = rb.getString("jdbc.username");
		DBPASS = rb.getString("jdbc.password");
		DBDRIVER = rb.getString("jdbc.driver");
		//System.out.println(DBURL);
		try {
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection(ResultSet rs,Statement stat,Connection conn){
		try{
			if (rs!=null)rs.close();
			if (stat!=null)stat.close();
			if (conn!=null)conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}
