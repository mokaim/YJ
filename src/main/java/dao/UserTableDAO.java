package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import JDBC.JDBCUtil;
import Model.UserTable;
import Pattern.SingletonClass;

public class UserTableDAO {
	// DAO Singleton
	private UserTableDAO() {}
	private static UserTableDAO instance = null;
	
	public static UserTableDAO getInstance() {
		if(instance == null)
			instance = new UserTableDAO();
		return instance;
	}
	SingletonClass singleton = SingletonClass.getInstance();
	
	Connection conn = JDBCUtil.getConnection();
	
	public void insertUserTable(UserTable userTable) {
		singleton.userInsertCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into UserTable values (?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userTable.getID());
			pstmt.setString(2, userTable.getPW());
			pstmt.setString(3, userTable.getNName());
			pstmt.setString(4, userTable.getPhone());
			pstmt.setString(5, userTable.getEmail());
			
			singleton.userInsertCnt = pstmt.executeUpdate();			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("insertUserTable Error");
		}
		finally {
			try {
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("pstmtClose Error");
			}
		}
	}
	
	public void updateUserTable(UserTable userTable) {
		singleton.userUpdateCnt = 0;
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
			
			singleton.userUpdateCnt = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("updateUserTable Error");
		}
		finally {
			try {
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("pstmt Close Error");
			}
		}
	}
	public void deleteUserTable(UserTable userTable) {
		singleton.userDeleteCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from UserTable where id = ? and pw = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userTable.getID());
			pstmt.setString(2, userTable.getPW());
			
			singleton.userDeleteCnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("deleteUserTable Error");
		}
		finally {
			try {
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("pstmtClose Error");
			}
		}
	}
	
}
