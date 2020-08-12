package com.yeongjin.persistence;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.yeongjin.domain.WriteTable;

public class WriteTableDAO {
	// DAO Singleton
	private WriteTableDAO() {}
	private static WriteTableDAO instance = null;
	
	public static WriteTableDAO getinstance() {
		if(instance == null)
			instance = new WriteTableDAO();
		
		return instance;
	}
	
	public Connection conn;
	
	// 글쓰기
	public synchronized int insertWriteTable(WriteTable writeTable) {
		int Cnt = 0;
		conn = JDBCUtil.getInstance().getConnection();
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
			
			Cnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("insertWriteTable Error");
		}
		finally {
			try {
				JDBCUtil.getInstance().pstmtClose(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("pstmtClose Error");
			}
		}
		return Cnt;
	}
	// 해당 글 삭제
	public synchronized int deleteWriteTable(WriteTable writeTable) {
		int Cnt = 0;
		conn = JDBCUtil.getInstance().getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from WriteTable where nname = ? and header = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writeTable.getNName());
			pstmt.setString(2, writeTable.getHeader());
			
			Cnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("deleteWriteTable Error");
		}
		finally {
			try {
				JDBCUtil.getInstance().pstmtClose(pstmt);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("pstmt Close Error");
			}
		}
		return Cnt;
	}
	// 좋아요 증가
	public synchronized int updateLikes(WriteTable writeTable) {
		int Cnt = 0;
		conn = JDBCUtil.getInstance().getConnection();
		PreparedStatement pstmt = null;
		String sql = "update WriteTable set likes +=1 where nname = ? and header = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writeTable.getNName());
			pstmt.setString(2, writeTable.getHeader());
			
			Cnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("updateLikes Error");
		}
		finally {
			try {
				JDBCUtil.getInstance().pstmtClose(pstmt);
			}catch(Exception e) {
				System.out.println("pstmtClose Error");
			}
		}
		return Cnt;
	}
	// 싫어요 증가
	public synchronized int updateHates(WriteTable writeTable) {
		int Cnt = 0;
		conn = JDBCUtil.getInstance().getConnection();
		PreparedStatement pstmt = null;
		String sql = "update WriteTable set hates +=1 where nname = ? and header = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writeTable.getNName());
			pstmt.setString(2, writeTable.getHeader());
			
			Cnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("updateHates Error");
		}
		finally {
			try {
				JDBCUtil.getInstance().pstmtClose(pstmt);
			}catch(Exception e) {
				System.out.println("pstmtClose Error");
			}
		}
		return Cnt;
	}
	// 해당 글 방문횟수 증가
	public synchronized int updateVisit(WriteTable writeTable) {
		int Cnt = 0;
		conn = JDBCUtil.getInstance().getConnection();
		PreparedStatement pstmt = null;
		String sql = "update WriteTable set visit +=1 where nname = ? and header = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writeTable.getNName());
			pstmt.setString(2, writeTable.getHeader());
			
			Cnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("updateVisit Error");
		}
		finally {
			try {
				JDBCUtil.getInstance().pstmtClose(pstmt);
			}catch(Exception e) {
				System.out.println("pstmtClose Error");
			}
		}
		return Cnt;
	}
	
}
