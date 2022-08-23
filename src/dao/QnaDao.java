package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConn;
import vo.GongiVo;
import vo.QnaVo;

public class QnaDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public int getListCount() {
		
		String sql = "select count(*) from tqa";
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

	public ArrayList<QnaVo> getQnaList(int page, int limit) {
		
		String sql = "select * from";
		sql		  += " (select rownum rnum, q_idx, q_title, q_cont, mem_id, q_readcount, regdate ";
		sql		  += " from (select * from tqa order by q_idx desc, q_readcount asc))";
		sql		  += " where rnum >= ? and rnum <= ?";
		int startRow = (page - 1) * 10 + 1;
		int endRow = startRow + limit - 1;
		
		ArrayList<QnaVo> qnaList = new ArrayList<>();
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs           = pstmt.executeQuery();
			
			while(rs.next()) {
				QnaVo qnaiVo = new QnaVo();
				qnaiVo.setQna_idx(rs.getInt("q_idx"));
				qnaiVo.setQna_title(rs.getString("q_title"));
				qnaiVo.setQna_cont(rs.getString("q_cont"));
				qnaiVo.setQna_member_id(rs.getString("mem_id"));
				qnaiVo.setQna_readcount(rs.getInt("q_readcount"));
				qnaiVo.setQna_regdate(rs.getString("regdate"));
				qnaList.add(qnaiVo);
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
		
		return qnaList;
	}

	public QnaVo getQnaDetail(int qna_idx) {

		QnaVo qnaVo = null;

		String sql = "select * from tqa where q_idx = ? ";
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			pstmt.setInt(1, qna_idx);
			
			rs           = pstmt.executeQuery();
			
			if(rs.next()) {
				qnaVo = new QnaVo();
				qnaVo.setQna_idx(rs.getInt("q_idx"));
				qnaVo.setQna_title(rs.getString("q_title"));
				qnaVo.setQna_cont(rs.getString("q_cont"));
				qnaVo.setQna_member_id(rs.getString("mem_id"));
				qnaVo.setQna_readcount(rs.getInt("q_readcount"));
				qnaVo.setQna_regdate(rs.getString("regdate"));
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
		
		return qnaVo;
	}

	public void readCount(int qna_idx) {
		
		String sql = "update tqa set q_readcount =";
		sql		  += " q_readcount + 1";
		sql		  += " where q_idx = ?";
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			pstmt.setInt(1, qna_idx);
			
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

	public int getQnaInsert(QnaVo qnaVo) {
		
		int qna_num = 0;
		int readcount = 0;
		int result = 0;
		
		String sql = "select max(q_idx) from tqa ";
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			rs           = pstmt.executeQuery();
			
			if(rs.next()) {
				qna_num  = rs.getInt(1);
				qna_num += 1;
			} else {
				qna_num = 1;
			}
			
			sql  = "insert into tqa (q_idx, q_title, q_cont, q_readcount, mem_id)";
			sql += " values (?, ?, ?, ?, ?) ";
			pstmt        = conn.prepareStatement(sql);
			pstmt.setInt(1, qna_num);
			pstmt.setString(2, qnaVo.getQna_title());
			pstmt.setString(3, qnaVo.getQna_cont());
			pstmt.setInt(4, readcount);
			pstmt.setString(5, qnaVo.getQna_member_id());
			
			
			
			result = pstmt.executeUpdate();
			System.out.println(qna_num);
			System.out.println(qnaVo.getQna_title());
			System.out.println(qnaVo.getQna_cont());
			System.out.println(readcount);
			System.out.println(qnaVo.getQna_member_id());

			
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

	public boolean inQnaWriter(int qna_idx, String member_id) {
		
		boolean result = false;
		
		String sql = "select * from tqa where q_idx = ?";
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			pstmt.setInt(1, qna_idx);
			
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

	public int boardUpdate(QnaVo qnaVo) {
		
		int result = 0;
		
		String sql = "update tqa set q_title = ?, ";
		sql		  += " q_cont = ? where q_idx = ? ";
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			pstmt.setString(1, qnaVo.getQna_title());
			pstmt.setString(2, qnaVo.getQna_cont());
			pstmt.setInt(3, qnaVo.getQna_idx());
			
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

	public int boardDelete(int qna_idx) {

		int succ = 0;
		
		String sql = "delete from tqa where q_idx = ? ";
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			pstmt.setInt(1, qna_idx);
			
			succ       = pstmt.executeUpdate();
			
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
		
		return succ;
	}

	public ArrayList<QnaVo> getQList() {
		
		ArrayList<QnaVo> getQList = new ArrayList<>();
		
		String sql = "select * from tqa order by q_idx ";
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			
			rs           = pstmt.executeQuery();
			
			while(rs.next()) {
				QnaVo qnaVo = new QnaVo();
				qnaVo.setQna_idx(rs.getInt("q_idx"));
				qnaVo.setQna_title(rs.getString("q_title"));
				qnaVo.setQna_cont(rs.getString("q_cont"));
				qnaVo.setQna_member_id(rs.getString("mem_id"));
				qnaVo.setQna_readcount(rs.getInt("q_readcount"));
				qnaVo.setQna_regdate(rs.getString("regdate"));
				getQList.add(qnaVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return getQList;
	}

}
