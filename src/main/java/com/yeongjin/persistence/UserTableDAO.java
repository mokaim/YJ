package com.yeongjin.persistence;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yeongjin.domain.UserTable;

public class UserTableDAO {
	// DAO Singleton
	private UserTableDAO() {}
	private static UserTableDAO instance = null;
	
	public static UserTableDAO getInstance() {
		if(instance == null)
			instance = new UserTableDAO();
		return instance;
	}
	
	public Connection conn;
	
	// 회원가입
	public synchronized int insertUserTable(UserTable userTable) {
		conn = JDBCUtil.getInstance().getConnection();
		int Cnt = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into UserTable values (?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userTable.getID());
			pstmt.setString(2, userTable.getPW());
			pstmt.setString(3, userTable.getNName());
			pstmt.setString(4, userTable.getPhone());
			pstmt.setString(5, userTable.getEmail());			
			Cnt = pstmt.executeUpdate();		
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("insertUserTable Error");
		}
		finally {
			try {
				JDBCUtil.getInstance().pstmtClose(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return Cnt;
	}
	
	// 회원정보 수정
	public synchronized int updateUserTable(UserTable userTable) {
		conn = JDBCUtil.getInstance().getConnection();
		int Cnt = 0;
		PreparedStatement pstmt = null;
		String sql = "update UserTable"+
					"set pw = ? , phone = ? , email = ?" +
					"where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userTable.getPW());
			pstmt.setString(2, userTable.getPhone());
			pstmt.setString(3, userTable.getEmail());
			pstmt.setString(4, userTable.getID());
			
			Cnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("updateUserTable Error");
		}
		finally {
			try {
				JDBCUtil.getInstance().pstmtClose(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return Cnt;
	}
	// 회원탈퇴
	public synchronized int deleteUserTable(String id, String pw) {
		conn = JDBCUtil.getInstance().getConnection();
		int Cnt = 0;	
		PreparedStatement pstmt = null;
		String sql = "delete from UserTable where id = ? and pw = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			Cnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("deleteUserTable Error");
		}
		finally {
			try {
				JDBCUtil.getInstance().pstmtClose(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return Cnt;
	}
	// 아이디로 닉네임 찾기
	public synchronized String selectUserNName(String id) {
		conn = JDBCUtil.getInstance().getConnection();
		String selectID = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select nname from UserTable where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				 selectID = rs.getString("nname");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("selectUserNName Error");
		}
		finally {
			try {				
				JDBCUtil.getInstance().rsClose(rs);
				JDBCUtil.getInstance().pstmtClose(pstmt);
				JDBCUtil.getInstance().ConnClose(conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return selectID;
	}
	// 로그인
	public synchronized boolean LoginUser(String id, String pw) {
		conn = JDBCUtil.getInstance().getConnection();
		boolean result = false;
		String DBpw;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql ="select PW from UserTable where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				DBpw = rs.getString("PW");
				if(DBpw.equals(pw))
					result = true;
			}				
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("LoginUser Error");
		}
		finally {
			try {								
				JDBCUtil.getInstance().rsClose(rs);
				JDBCUtil.getInstance().pstmtClose(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
