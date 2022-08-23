package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConn;
import vo.QnaVo;
import vo.ReviewBVo;


public class ReviewBDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public int getListCount() {
		
		String sql = "select count(*) from treviewb";
		int listCount = 0;
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			
			rs           = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listCount;
	}

	public ArrayList<ReviewBVo> getReviewBList(int page, int limit) {
		
		String sql = "select * from";
		sql		  += " (select rownum rnum, r_idx, mem_id, r_cont, score, attraction_id ";
		sql		  += " from (select * from treviewb order by r_idx desc))";
		sql		  += " where rnum >= ? and rnum <= ?";
		int startRow = (page - 1) * 10 + 1;
		int endRow = startRow + limit - 1;
		
		ArrayList<ReviewBVo> reviewBList = new ArrayList<>();
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs           = pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewBVo reviewBVo = new ReviewBVo();
				reviewBVo.setR_idx(rs.getInt("r_idx"));
				reviewBVo.setMem_id(rs.getString("mem_id"));
				reviewBVo.setR_cont(rs.getString("r_cont"));
				reviewBVo.setScore(rs.getInt("score"));
				reviewBVo.setAttraction_id(rs.getString("attraction_id"));
				reviewBList.add(reviewBVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return reviewBList;
	}

	public int getReviewInsert(ReviewBVo reviewBVo) {
	
		int review_num = 0;
		int result = 0;
		
		String sql = "select max(r_idx) from treviewb ";
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			rs           = pstmt.executeQuery();
			
			if(rs.next()) {
				review_num  = rs.getInt(1);
				review_num += 1;
			} else {
				review_num = 1;
			}
			
			sql  = "insert into treviewb (r_idx, mem_id, r_cont, score, attraction_id)";
			sql += " values (?, ?, ?, ?, ?) ";
			pstmt        = conn.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			pstmt.setString(2, reviewBVo.getMem_id());
			pstmt.setString(3, reviewBVo.getR_cont());
			pstmt.setInt(4, reviewBVo.getScore());
			pstmt.setString(5, reviewBVo.getAttraction_id());
			
			
			
			result = pstmt.executeUpdate();
			System.out.println(reviewBVo.getMem_id());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
				
		return result;
	}

	public ArrayList<ReviewBVo> getRList() {

		ArrayList<ReviewBVo> getRList = new ArrayList<>();
		
		String sql = "select * from treviewb order by r_idx ";
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			
			rs           = pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewBVo reviewBVo = new ReviewBVo();
				reviewBVo.setR_idx(rs.getInt("r_idx"));
				reviewBVo.setMem_id(rs.getString("mem_id"));
				reviewBVo.setR_cont(rs.getString("r_cont"));
				reviewBVo.setScore(rs.getInt("score"));
				reviewBVo.setAttraction_id(rs.getString("attraction_id"));
				getRList.add(reviewBVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return getRList;
	}
}
