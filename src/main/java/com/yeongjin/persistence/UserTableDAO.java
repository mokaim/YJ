package com.yeongjin.persistence;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yeongjin.domain.UserDTO;
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
	
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	
	
	
	public synchronized int getUserNumber() {
		
		conn = JDBCUtil.getInstance().getConnection();
		int userNumber = 1;
		
		try {
			pstmt = conn.prepareStatement("SELECT count(*) FROM UserTable");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return userNumber += rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		
		
		return -1;
	
	}
	
	
	
	// �쉶�썝媛��엯
	public synchronized int insertUserTable(UserDTO userDTO) {
		conn = JDBCUtil.getInstance().getConnection();
		int Cnt = 0;
		int userNumber = getUserNumber();
		String sql = "insert into UserTable values (?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNumber);
			pstmt.setString(2, userDTO.getUserName());
			pstmt.setString(3, userDTO.getEmail());
			pstmt.setString(4, userDTO.getPw());
			
			Cnt = pstmt.executeUpdate();	
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("insertUserTable Error");
		}
		finally {
			try {
				JDBCUtil.getInstance().rsClose(rs);
				JDBCUtil.getInstance().pstmtClose(pstmt);
				
				pstmt = null;
				rs = null;
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return Cnt;
	}
	
	// �쉶�썝�젙蹂� �닔�젙
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
	// �쉶�썝�깉�눜
	public synchronized int deleteUserTable(String id, String pw) {
		conn = JDBCUtil.getInstance().getConnection();
		int Cnt = 0;	
		pstmt = null;
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
	// �븘�씠�뵒濡� �땳�꽕�엫 李얘린
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
	// 濡쒓렇�씤
	public synchronized boolean LoginUser(String email, String pw) {
		conn = JDBCUtil.getInstance().getConnection();
		boolean result = false;
		String DBpw;
		rs = null;
		pstmt = null;
		
		String sql ="SELECT pw FROM UserTable WHERE email = ?";
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
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
				JDBCUtil.getInstance().ConnClose(conn);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	

	
}
