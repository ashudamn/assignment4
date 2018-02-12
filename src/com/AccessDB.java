package com;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class AccessDB {
	private static ResultSet rs;
	private static Connection conn;
	private static Statement st;
	public static boolean connect2DB(String driver,String url,String username,String password,String query) 
	{
		
		if(ErrorFinder.validateRequired(driver, url, username, password, query))
		{
			try {
				 Class.forName(driver);
				 conn=(Connection) DriverManager.getConnection(url,username,password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ErrorFinder.findError(e);
				return false;
			}
			try {
				st=(Statement) conn.createStatement();
				 rs=st.executeQuery(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				ErrorFinder.findError(e);
				e.printStackTrace();
				return false;
			}
			
			setRs(rs);
			return true;
		}
		return false;
	}
	public static ResultSet getRs() {
		return rs;
	}
	public static void setRs(ResultSet rs) {
		AccessDB.rs = rs;
	}
	public static Connection getConn() {
		return conn;
	}
	public static void setConn(Connection conn) {
		AccessDB.conn = conn;
	}
	public static Statement getSt() {
		return st;
	}
	public static void setSt(Statement st) {
		AccessDB.st = st;
	}
	public static void closeAllConnections()
	{
		if(AccessDB.rs!=null){
			try {
				AccessDB.rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(AccessDB.conn!=null&&AccessDB.st!=null){
				try {
					AccessDB.st.close();
					AccessDB.conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		
	}
}
