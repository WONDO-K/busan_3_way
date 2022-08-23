package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConn;
import vo.GongiVo;

public class GongiDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public int getListCount() {
		
		String sql = "select count(*) from tnotice";
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

	public ArrayList<GongiVo> getGongiList(int page, int limit) {
		
		String sql = "select * from";
		sql		  += " (select rownum rnum, n_idx, n_title, n_cont, mem_id, n_readcount, regdate ";
		sql		  += " from (select * from tnotice order by n_idx desc, n_readcount asc))";
		sql		  += " where rnum >= ? and rnum <= ?";
		int startRow = (page - 1) * 10 + 1;
		int endRow = startRow + limit - 1;
		
		ArrayList<GongiVo> gongiList = new ArrayList<>();
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs           = pstmt.executeQuery();
			
			while(rs.next()) {
				GongiVo gongiVo = new GongiVo();
				gongiVo.setNotice_idx(rs.getInt("n_idx"));
				gongiVo.setNotice_title(rs.getString("n_title"));
				gongiVo.setNotice_cont(rs.getString("n_cont"));
				gongiVo.setNotice_member_id(rs.getString("mem_id"));
				gongiVo.setNotice_readcount(rs.getInt("n_readcount"));
				gongiVo.setNotice_regdate(rs.getString("regdate"));
				gongiList.add(gongiVo);
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
		
		return gongiList;
	}

	public GongiVo getGongiDetail(int notice_idx) {
		
		GongiVo gongiVo = null;

		String sql = "select * from tnotice where n_idx = ? ";
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			pstmt.setInt(1, notice_idx);
			
			rs           = pstmt.executeQuery();
			
			if(rs.next()) {
				gongiVo = new GongiVo();
				gongiVo.setNotice_idx(rs.getInt("n_idx"));
				gongiVo.setNotice_title(rs.getString("n_title"));
				gongiVo.setNotice_cont(rs.getString("n_cont"));
				gongiVo.setNotice_member_id(rs.getString("mem_id"));
				gongiVo.setNotice_readcount(rs.getInt("n_readcount"));
				gongiVo.setNotice_regdate(rs.getString("regdate"));
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
		
		return gongiVo;
	}

	public void readCount(int notice_idx) {
		
		String sql = "update tnotice set n_readcount =";
		sql		  += " n_readcount + 1";
		sql		  += " where n_idx = ?";
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			pstmt.setInt(1, notice_idx);
			
			pstmt.executeUpdate();
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
		
	}

	public int getGongiInsert(GongiVo gongiVo) {

		int gongi_num = 0;
		int readcount = 0;
		int result = 0;
		
		String sql = "select max(n_idx) from tnotice ";
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			rs           = pstmt.executeQuery();
			
			if(rs.next()) {
				gongi_num  = rs.getInt(1);
				gongi_num += 1;
			} else {
				gongi_num = 1;
			}
			
			sql  = "insert into tnotice (n_idx, n_title, n_cont, n_readcount, mem_id)";
			sql += " values (?, ?, ?, ?, ?) ";
			pstmt        = conn.prepareStatement(sql);
			pstmt.setInt(1, gongi_num);
			pstmt.setString(2, gongiVo.getNotice_title());
			pstmt.setString(3, gongiVo.getNotice_cont());
			pstmt.setInt(4, readcount);
			pstmt.setString(5, gongiVo.getNotice_member_id());
			
			
			
			result = pstmt.executeUpdate();

			
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

	public int boardUpdate(GongiVo gongivo) {

		int result = 0;
		
		String sql = "update tnotice set n_title = ?, ";
		sql		  += " n_cont = ? where n_idx = ? ";
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			pstmt.setString(1, gongivo.getNotice_title());
			pstmt.setString(2, gongivo.getNotice_cont());
			pstmt.setInt(3, gongivo.getNotice_idx());
			
			result       = pstmt.executeUpdate();  
			
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

	public boolean inGongiWriter(int notice_idx, String member_id) {

        boolean result = false;
		
		String sql = "select * from tnotice where n_idx = ?";
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			pstmt.setInt(1, notice_idx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(member_id.equals(rs.getString("mem_id"))) {
					result = true;
			    }
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
		return result;
	}
}