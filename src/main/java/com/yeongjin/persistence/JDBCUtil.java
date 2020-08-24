package com.yeongjin.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
			
			String jdbcDriver = "jdbc:sqlserver://localhost:1433;databaseName=YJ";
			String dbUser = "sa";
			String dbPass = "anstn132";
			
			try {
				
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			conn.setAutoCommit(false);
			
		}catch(SQLException e) {		
			
			log.warn("DB 연결에 문제발생!");
			e.printStackTrace();			
		}
		return conn;
	}
	
	// Close
	public void ConnClose(Connection conn) {
		try {
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			log.warn("ConnClose Error");
		}
	}
	
	public void rsClose(ResultSet rs) {
		try {
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
			log.warn("rsClose Error");
		}
	}
	
	public void pstmtClose(PreparedStatement pstmt) {
		try {
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
			log.warn("pstmtClose Error");
		}
	}
	//DCL
	public void commit(Connection conn) {
		try {
			conn.commit();
		}catch(Exception e) {
			e.printStackTrace();
			log.warn("Commit Error");
		}
	}
	public void Rollback(Connection conn) {
		try {
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			log.warn("Rollback Error");
		}
	}	
}