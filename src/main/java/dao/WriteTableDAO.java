package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import JDBC.JDBCUtil;
import Model.WriteTable;
import Pattern.SingletonClass;

public class WriteTableDAO {
	private WriteTableDAO() {}
	private static WriteTableDAO instance = null;
	
	public static WriteTableDAO getinstance() {
		if(instance == null)
			instance = new WriteTableDAO();
		
		return instance;
	}
	SingletonClass singleton = SingletonClass.getInstance();
	Connection conn = JDBCUtil.getConnection();
	
	public void insertWriteTable(WriteTable writeTable) {
		singleton.writeInsertCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into WriteTable values (?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writeTable.getNName());
			pstmt.setString(2, writeTable.getHeader());
			pstmt.setString(3, writeTable.getContent());
			pstmt.setInt(4, writeTable.getLikes());
			pstmt.setInt(5, writeTable.getHate());
			pstmt.setInt(6, writeTable.getVisit());
			
			singleton.writeInsertCnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("insertWriteTable Error");
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
	
	public void deleteWriteTable(WriteTable writeTable) {
		singleton.writeDeleteCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from WriteTable where nname = ? and header = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writeTable.getNName());
			pstmt.setString(2, writeTable.getHeader());
			
			singleton.writeDeleteCnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("deleteWriteTable Error");
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
	
	public void updateLikes(WriteTable writeTable) {
		singleton.writeUpdateCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "update WriteTable set likes +=1 where nname = ? and header = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writeTable.getNName());
			pstmt.setString(2, writeTable.getHeader());
			
			singleton.writeUpdateCnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("updateLikes Error");
		}
		finally {
			try {
				pstmt.close();
			}catch(Exception e) {
				System.out.println("pstmtClose Error");
			}
		}
	}
	public void updateHates(WriteTable writeTable) {
		singleton.writeUpdateCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "update WriteTable set hates +=1 where nname = ? and header = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writeTable.getNName());
			pstmt.setString(2, writeTable.getHeader());
			
			singleton.writeUpdateCnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("updateHates Error");
		}
		finally {
			try {
				pstmt.close();
			}catch(Exception e) {
				System.out.println("pstmtClose Error");
			}
		}
	}
	public void updateVisit(WriteTable writeTable) {
		singleton.writeUpdateCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "update WriteTable set visit +=1 where nname = ? and header = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writeTable.getNName());
			pstmt.setString(2, writeTable.getHeader());
			
			singleton.writeUpdateCnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("updateVisit Error");
		}
		finally {
			try {
				pstmt.close();
			}catch(Exception e) {
				System.out.println("pstmtClose Error");
			}
		}
	}
	
}
