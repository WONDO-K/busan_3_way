package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConn;
import vo.MemberVo;


public class MemberDao {
	
	public MemberDao() {
	}

	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}

	/*
	 * public Connection getConnection() throws Exception { Connection conn = null;
	 * Context initContext = new InitialContext(); Context envContent = (Context)
	 * initContext.lookup("java:/comp/env"); DataSource ds = (DataSource)
	 * envContent.lookup("/myoracle"); conn = ds.getConnection(); return conn; }
	 */
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public int idCheck(String member_id, String member_pwd) {
		
		int result = -1;
		
		String sql = "select mem_id, mem_pwd from tjoin where mem_id = ? " ;
		
		try {
			DBConn db = new DBConn();
			conn   = db.getConnection();
			pstmt  = conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			
			rs     = pstmt.executeQuery();
			
			if (rs.next()) {
				String member_pwd_db = rs.getString("mem_pwd");
				if (member_pwd_db != null && member_pwd.equals(member_pwd_db)) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
				result = -1;
			}
		} catch (Exception e) {
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

	public MemberVo getMember(String member_id) {
		
		MemberVo memberVo = null;
		
		String sql        = "select * from tjoin where mem_id = ? ";
		
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				memberVo = new MemberVo();
				memberVo.setMember_id(rs.getString("mem_id"));
				memberVo.setMember_pwd(rs.getString("mem_pwd"));
				memberVo.setMember_name(rs.getString("mem_name"));
				memberVo.setMember_nick_name(rs.getString("nick_name"));
				memberVo.setMember_birth(rs.getString("birth"));
				memberVo.setMember_email(rs.getString("email"));
				memberVo.setMember_addr(rs.getString("addr"));
				memberVo.setMember_tel(rs.getString("tel"));
				memberVo.setMember_joindate(rs.getString("joindate"));
				memberVo.setMember_member_level(rs.getInt("member_level"));
			}
		} catch (Exception e) {
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
		
		return memberVo;
	}

	public int confirmID(String member_id) {
		
		int result = -1;
		
		String sql = "select mem_pwd from tjoin where mem_id=? ";
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			pstmt      = conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 조회 결과가 있으면 userid가 존재한다는 의미
				result = 1;
			} else {
				// 조회한 결과가 값이 없으므로 userid가 존재하지 않음.
				result = -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	public int confirmNickname(String member_nick_name) {

		int result = -1;
		
		String sql = "select mem_pwd from tjoin where nick_name=? ";
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			pstmt      = conn.prepareStatement(sql);
			pstmt.setString(1, member_nick_name);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 조회 결과가 있으면 userid가 존재한다는 의미
				result = 1;
			} else {
				// 조회한 결과가 값이 없으므로 userid가 존재하지 않음.
				result = -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	public int confirmEmail(String member_email) {

		int result = -1;
		
		String sql = "select mem_pwd from tjoin where email=? ";
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			pstmt      = conn.prepareStatement(sql);
			pstmt.setString(1, member_email);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 조회 결과가 있으면 userid가 존재한다는 의미
				result = 1;
			} else {
				// 조회한 결과가 값이 없으므로 userid가 존재하지 않음.
				result = -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	public int insertMember(MemberVo memberVo) {

		int result = 0;

		String sql = "insert into tjoin (mem_id, mem_pwd, mem_name, nick_name, birth, email, tel, addr) ";
		sql		  += " values(?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVo.getMember_id());
			pstmt.setString(2, memberVo.getMember_pwd());
			pstmt.setString(3, memberVo.getMember_name());
			pstmt.setString(4, memberVo.getMember_nick_name());
			pstmt.setString(5, memberVo.getMember_birth());
			pstmt.setString(6, memberVo.getMember_email());
			pstmt.setString(7, memberVo.getMember_tel());
			pstmt.setString(8, memberVo.getMember_addr());

			result = pstmt.executeUpdate(); // 성공하면 insert가 성공한 행의 수를 반환, 싪패하면 0
		} catch (Exception e) {
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

	public int getListCount() {
		
		String sql = "select count(*) from tjoin";
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

	public ArrayList<MemberVo> getMemberList(int page, int limit) {
		
		String sql = "select * from";
		sql		  += " (select rownum rnum, mem_id, mem_pwd, mem_name, nick_name, birth, email, addr, tel, joindate, member_level ";
		sql		  += " from (select * from tjoin order by member_level asc))";
		sql		  += " where rnum >= ? and rnum <= ?";
		int startRow = (page - 1) * 10 + 1;
		int endRow = startRow + limit - 1;
		
		ArrayList<MemberVo> memberList = new ArrayList<>();
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs           = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVo memberVo = new MemberVo();
				memberVo.setMember_id(rs.getString("mem_id"));
				memberVo.setMember_pwd(rs.getString("mem_pwd"));
				memberVo.setMember_name(rs.getString("mem_name"));
				memberVo.setMember_nick_name(rs.getString("nick_name"));
				memberVo.setMember_birth(rs.getString("birth"));
				memberVo.setMember_email(rs.getString("email"));
				memberVo.setMember_addr(rs.getString("addr"));
				memberVo.setMember_tel(rs.getString("tel"));
				memberVo.setMember_joindate(rs.getString("joindate"));
				memberVo.setMember_member_level(rs.getInt("member_level"));
				memberList.add(memberVo);
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
		
		return memberList;
	}
}
