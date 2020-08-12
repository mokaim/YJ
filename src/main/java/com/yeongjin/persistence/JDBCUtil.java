package com.yeongjin.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	
	private JDBCUtil() {}
	private static JDBCUtil instance = null;
	
	public static JDBCUtil getInstance() {
		if(instance == null)
			instance = new JDBCUtil();
		return instance;
	}

	public Connection getConnection() {		
		Connection conn = null;
		try {
			String jdbcDriver = "jdbc:sqlserver://localhost:10161;databaseName=YJ;";
			String dbUser = "sa";
			String dbPass = "1234";
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			conn.setAutoCommit(false);
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 오류");
		}
		return conn;
	}
	
	// Close
	public void ConnClose(Connection conn) {
		try {
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("ConnClose Error");
		}
	}
	
	public void rsClose(ResultSet rs) {
		try {
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("rsClose Error");
		}
	}
	
	public void pstmtClose(PreparedStatement pstmt) {
		try {
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("pstmtClose Error");
		}
	}
	//DCL
	public void commit(Connection conn) {
		try {
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Commit Error");
		}
	}
	public void Rollback(Connection conn) {
		try {
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Rollback Error");
		}
	}	
}