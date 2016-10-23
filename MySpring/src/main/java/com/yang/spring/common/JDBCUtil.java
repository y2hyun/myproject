package com.yang.spring.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://192.168.59.129/yang";
	static final String DB_USER = "y2hyun";
	static final String DB_PASS = "diddlgus";
	
	/**
	 * get JDBC Connection
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void close(Connection conn, PreparedStatement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) stmt.close();
			if(conn != null && !conn.isClosed()) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			stmt = null;
			conn = null;
		}
	}
	
	public static void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) rs.close();
			close(conn, stmt);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
		}
	}
}
