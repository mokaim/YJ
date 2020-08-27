package com.yeongjin.persistence;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yeongjin.domain.WriteDTO;
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
	
	public PreparedStatement pstmt = null;
	public Connection conn = null;
	public ResultSet rs = null;
	
	
	
	public synchronized List<WriteDTO> getList(int count){
		
		String query = "select top 10 u.user_number," + 
				"	   w.post_number," + 
				"	   u.email as writer," + 
				"	   w.title," + 
				"	   w.content," + 
				"	   w.likes," + 
				"	   w.hate," + 
				"	   w.visit," + 
				"	   w.posted_date" + 
				"	   from UserTable u inner join WriteTable w on u.user_number = w.user_number where w.post_number < ? order by w.post_number desc";

		List<WriteDTO> list = new ArrayList<WriteDTO>();
		conn = JDBCUtil.getInstance().getConnection();
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, count);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new WriteDTO(rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getString(9).substring(0,10)));
				
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.getInstance().pstmtClose(pstmt);
			JDBCUtil.getInstance().ConnClose(conn);			
			conn = null;
			pstmt = null;
		}
		
		
		return list;
		
	}
	
	
	
	public synchronized List<WriteDTO> getViewList(int viewId) {
		
		String query = "select write.post_number,\r\n" + 
				"	   write.title,\r\n" + 
				"	   write.content,\r\n" + 
				"	   write.likes,\r\n" + 
				"	   write.hate,\r\n" + 
				"	   write.visit,\r\n" + 
				"	   img.imageLocation from WriteTable write left join ImageTable img on write.post_number = img.post_number where write.post_number = ?";
		
	
		WriteDTO writeDTO = new WriteDTO();
		conn = JDBCUtil.getInstance().getConnection();
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, viewId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {

			}
			
			
		}catch (SQLException e) {
			// TODO: handle exception
			
		}
		
		
		
		return writeDTO;
	}
	
	
	
	
	
	public synchronized int insertWriteTable(WriteDTO writeDTO) {
		
		int Cnt = 0;
		conn = JDBCUtil.getInstance().getConnection();
		pstmt = null;
		String sql = "insert into WriteTable values (?,?,?,?,?,?,?,?)";
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, writeDTO.getPostNumber());
			pstmt.setInt(2, writeDTO.getUserNumber());
			pstmt.setString(3, writeDTO.getTitle());
			pstmt.setString(4, writeDTO.getContent());
			pstmt.setInt(5, writeDTO.getLikes());
			pstmt.setInt(6, writeDTO.getHate());
			pstmt.setInt(7, writeDTO.getVisit());
			pstmt.setString(8, writeDTO.getPosted_date());
			
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
	
	public synchronized int deleteWriteTable(WriteTable writeTable) {
		int Cnt = 0;
		conn = JDBCUtil.getInstance().getConnection();
		pstmt = null;
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

	public synchronized int updateLikes(WriteTable writeTable) {
		int Cnt = 0;
		conn = JDBCUtil.getInstance().getConnection();
		pstmt = null;
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

	public synchronized int updateHates(WriteTable writeTable) {
		int Cnt = 0;
		conn = JDBCUtil.getInstance().getConnection();
		pstmt = null;
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

	public synchronized int updateVisit(WriteTable writeTable) {
		int Cnt = 0;
		conn = JDBCUtil.getInstance().getConnection();
		pstmt = null;
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
	
	public String getDate() {
		conn = JDBCUtil.getInstance().getConnection();
		String date = null;
		try {
			
			pstmt = conn.prepareStatement("SELECT GETDATE()");			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				date = rs.getString(1).substring(0,16);

			}
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			JDBCUtil.getInstance().ConnClose(conn);			
			pstmt = null;
			conn = null;
			rs = null;
		}
		
		return date;
	}
	
	
	public int getUserNumber(String email) {
		
		String query = "SELECT user_number FROM UserTable WHERE email = ?";
		int userNumber = 0;
		conn = JDBCUtil.getInstance().getConnection();
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userNumber = rs.getInt(1);
				return userNumber;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return 0;
	}
	
	public int getCountPost() {
		
		String query = "SELECT COUNT(*) FROM WriteTable";
		
		conn = JDBCUtil.getInstance().getConnection();
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1) + 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return 0;
	}
	

	
	
	
}
