package api.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import api.db.DBConn;
import api.vo.FestivalVo;

public class FestivalDao {
	private Connection conn = null;
	private CallableStatement cstmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//MERGE INTO 테이블을 비교하여 값이 있으면 업데이트 값이 없으면 INSERT하는 구문 ()
		public void mergeFestival(FestivalVo festivalVo) {
			try {
				DBConn db = new DBConn();
				conn = db.getConnection();
				String   sql = "{CALL  PKG_PROJECT.PROC_FESTIVAL_MERGE( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
				cstmt = conn.prepareCall(sql);
				cstmt.setString(1,  festivalVo.getFestival_id());
				cstmt.setString(2,  festivalVo.getFestival_name());
				cstmt.setString(3,  festivalVo.getFestival_gugun());
				cstmt.setString(4,  festivalVo.getFestival_place());
				cstmt.setString(5,  festivalVo.getFestival_title());
				cstmt.setString(6,  festivalVo.getFestival_subtitle());
				cstmt.setString(7,  festivalVo.getFestival_main_place());
				cstmt.setString(8,  festivalVo.getFestival_addr1());
				cstmt.setString(9,  festivalVo.getFestival_addr2());
				cstmt.setString(10, festivalVo.getFestival_tel());
				cstmt.setString(11, festivalVo.getFestival_site());
				cstmt.setString(12, festivalVo.getFestival_trfc_info());
				cstmt.setString(13, festivalVo.getFestival_usageday());
				cstmt.setString(14, festivalVo.getFestival_time());
				cstmt.setString(15, festivalVo.getFestival_usage_amount());
				cstmt.setString(16, festivalVo.getFestival_img());
				cstmt.setString(17, festivalVo.getFestival_thumb());
				cstmt.setString(18, festivalVo.getFestival_cont());
				cstmt.setString(19, festivalVo.getFestival_convenient());

				cstmt.executeUpdate();
				System.out.println("축제정보 업데이트 완료");
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
		public int getFestivalCount() {
			
			String sql = "select count(*) from tfestival";
			int listFestivalCount = 0;
			
			try {
				DBConn   db  = new DBConn();
				conn         = db.getConnection();
				pstmt        = conn.prepareStatement(sql);
				
				rs           = pstmt.executeQuery();
				if(rs.next()) {
					listFestivalCount = rs.getInt(1);
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
			return listFestivalCount;
		}
		
		public ArrayList<FestivalVo> getFestivalList(int page, int limit) {
			
			String sql = "select * from";
			sql		  += " (select rownum rnum, FESTIVAL_ID,FESTIVAL_PLACE,FESTIVAL_THUMB,FESTIVAL_ADDR1,FESTIVAL_ADDR2 ";
			sql		  += " from TFESTIVAL)";
			sql		  += " where rnum >= ? and rnum <= ?";
			int startRow = (page - 1) * 10 + 1;
			int endRow = startRow + limit - 1;
			
			ArrayList<FestivalVo> fetstivalList = new ArrayList<>();
			
			try {
				DBConn   db  = new DBConn();
				conn         = db.getConnection();
				pstmt        = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rs           = pstmt.executeQuery();

				while(rs.next()) {
					FestivalVo festivalVo = new FestivalVo();
					festivalVo.setFestival_id(rs.getString("festival_id"));
					festivalVo.setFestival_place(rs.getString("festival_place"));
					festivalVo.setFestival_thumb(rs.getString("festival_thumb"));
					festivalVo.setFestival_addr1(rs.getString("festival_addr1"));
					festivalVo.setFestival_addr2(rs.getString("festival_addr2"));
					

					fetstivalList.add(festivalVo);
					System.out.println(rs.getString("festival_id"));
					System.out.println(rs.getString("festival_place"));
					System.out.println(rs.getString("festival_thumb"));
					System.out.println(rs.getString("festival_addr1"));
					System.out.println(rs.getString("festival_addr2"));
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
			
			return fetstivalList;
		}
		
		public FestivalVo getDetailFestival(String festival_id){
			FestivalVo festivalVo = null;
			
			String sql = "SELECT * FROM TFESTIVAL WHERE FESTIVAL_ID=?";
			try {
				DBConn   db  = new DBConn();
				conn         = db.getConnection();
				pstmt        = conn.prepareStatement(sql);
				pstmt.setString(1, festival_id);
				rs = pstmt.executeQuery();
               
				
				if(rs.next()) {
					festivalVo = new FestivalVo();
					festivalVo.setFestival_id(rs.getString("festival_id"));
					festivalVo.setFestival_name(rs.getString("festival_name"));
					festivalVo.setFestival_gugun(rs.getString("festival_gugun"));
					festivalVo.setFestival_place(rs.getString("festival_place"));
					festivalVo.setFestival_title(rs.getString("festival_title"));
					festivalVo.setFestival_subtitle(rs.getString("festival_subtitle"));
					festivalVo.setFestival_main_place(rs.getString("festival_main_place"));
					festivalVo.setFestival_addr1(rs.getString("festival_addr1"));
					festivalVo.setFestival_addr2(rs.getString("festival_addr2"));
					festivalVo.setFestival_tel(rs.getString("festival_tel"));
					festivalVo.setFestival_site(rs.getString("festival_site"));
					festivalVo.setFestival_trfc_info(rs.getString("festival_trfc_info"));
					festivalVo.setFestival_usageday(rs.getString("festival_usageday"));
					festivalVo.setFestival_time(rs.getString("festival_time"));
					festivalVo.setFestival_usage_amount(rs.getString("festival_usage_amount"));
					festivalVo.setFestival_img(rs.getString("festival_img"));
					festivalVo.setFestival_thumb(rs.getString("festival_thumb"));
					festivalVo.setFestival_cont(rs.getString("festival_cont"));
					festivalVo.setFestival_convenient(rs.getString("festival_convenient"));
					festivalVo.setFestival_good(rs.getString("festival_good"));
					festivalVo.setFestival_bad(rs.getString("festival_bad"));
				}
				
			} catch(SQLException e) {
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
			return festivalVo;
		}
}
