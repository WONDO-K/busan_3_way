package api.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import api.db.DBConn;
import api.vo.FestivalVo;
import api.vo.StoreVo;

public class StoreDao {
	private Connection conn = null;
	private CallableStatement cstmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	//단순 INSERT 구문
	public void addStore(StoreVo storeVo) {
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String   sql = "{CALL  PKG_PROJECT.PROC_STORE_ADD( ?,?,?,?,?,?,?,?,?,?,?,?,? ) }";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, storeVo.getStore_id());
			cstmt.setString(2, storeVo.getStore_name());
			cstmt.setString(3, storeVo.getStore_gugun());
			cstmt.setString(4, storeVo.getStore_ex());
			cstmt.setString(5, storeVo.getStore_addr());
			cstmt.setString(6, storeVo.getStore_addr2());
			cstmt.setString(7, storeVo.getStore_tel());
			cstmt.setString(8, storeVo.getStore_site());
			cstmt.setString(9, storeVo.getStore_time());
			cstmt.setString(10, storeVo.getStore_menu());
			cstmt.setString(11, storeVo.getStore_img());
			cstmt.setString(12, storeVo.getStore_thumb());
			cstmt.setString(13, storeVo.getStore_cont());
			cstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
			try {
				if(cstmt!=null)cstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
			}
		} 
	}
	//MERGE INTO 테이블을 비교하여 값이 있으면 업데이트 값이 없으면 INSERT하는 구문 ()
	public void mergeStore(StoreVo storeVo) {
		try {
			DBConn db = new DBConn();
			conn = db.getConnection();
			String   sql = "{CALL  PKG_PROJECT.PROC_STORE_MERGE( ?,?,?,?,?,?,?,?,?,?,?,?,? ) }";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, storeVo.getStore_id());
			cstmt.setString(2, storeVo.getStore_name());
			cstmt.setString(3, storeVo.getStore_gugun());
			cstmt.setString(4, storeVo.getStore_ex());
			cstmt.setString(5, storeVo.getStore_addr());
			cstmt.setString(6, storeVo.getStore_addr2());
			cstmt.setString(7, storeVo.getStore_tel());
			cstmt.setString(8, storeVo.getStore_site());
			cstmt.setString(9, storeVo.getStore_time());
			cstmt.setString(10, storeVo.getStore_menu());
			cstmt.setString(11, storeVo.getStore_img());
			cstmt.setString(12, storeVo.getStore_thumb());
			cstmt.setString(13, storeVo.getStore_cont());
			cstmt.executeUpdate();
			System.out.println("맛집정보 업데이트 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { 
			try {
				if(cstmt!=null)cstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
			}
		} 
	}
	public int getStoreCount() {
		
		String sql = "select count(*) from tstore";
		int listStoreCount = 0;
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			
			rs           = pstmt.executeQuery();
			if(rs.next()) {
				listStoreCount = rs.getInt(1);
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
		return listStoreCount;
	}
	public ArrayList<StoreVo> getStoreList(int page, int limit) {
		
		String sql = "select * from";
		sql		  += " (select rownum rnum, STORE_ID,STORE_NAME,STORE_THUMB,STORE_ADDR,STORE_ADDR2 ";
		sql		  += " from TSTORE)";
		sql		  += " where rnum >= ? and rnum <= ?";
		int startRow = (page - 1) * 10 + 1;
		int endRow = startRow + limit - 1;
		
		ArrayList<StoreVo> storeList = new ArrayList<>();
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs           = pstmt.executeQuery();

			while(rs.next()) {
				StoreVo storeVo = new StoreVo();
				storeVo.setStore_id(rs.getString("store_id"));
				storeVo.setStore_name(rs.getString("store_name"));
				storeVo.setStore_thumb(rs.getString("store_thumb"));
				storeVo.setStore_addr(rs.getString("store_addr"));
				storeVo.setStore_addr2(rs.getString("store_addr2"));

				storeList.add(storeVo);
				System.out.println(rs.getString("store_id"));
				System.out.println(rs.getString("store_name"));
				System.out.println(rs.getString("store_thumb"));
				System.out.println(rs.getString("store_addr"));
				System.out.println(rs.getString("store_addr2"));
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
		
		return storeList;
	}
	public StoreVo getDetailStore(String store_id) {
		
		StoreVo storeVo = null;
		
		String sql = "SELECT * FROM TSTORE WHERE STORE_ID=?";
		
		try {
			DBConn   db  = new DBConn();
			conn         = db.getConnection();
			pstmt        = conn.prepareStatement(sql);
			pstmt.setString(1, store_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				storeVo = new StoreVo();
				storeVo.setStore_id(rs.getString("store_id"));
				storeVo.setStore_name(rs.getString("store_name"));
				storeVo.setStore_gugun(rs.getString("store_gugun"));
				storeVo.setStore_ex(rs.getString("store_ex"));
				storeVo.setStore_addr(rs.getString("store_addr"));
				storeVo.setStore_addr2(rs.getString("store_addr2"));
				storeVo.setStore_tel(rs.getString("store_tel"));
				storeVo.setStore_site(rs.getString("store_site"));
				storeVo.setStore_time(rs.getString("store_time"));
				storeVo.setStore_menu(rs.getString("store_menu"));
				storeVo.setStore_img(rs.getString("store_img"));
				storeVo.setStore_thumb(rs.getString("store_thumb"));
				storeVo.setStore_cont(rs.getString("store_cont"));
				storeVo.setStore_good(rs.getString("store_good"));
				storeVo.setStore_bad(rs.getString("store_bad"));
			}
           
	}catch(SQLException e) {
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
		return storeVo;
	}
}
