package api.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import api.db.DBConn;
import api.util.ApiUtil;
import api.vo.AttractionVo;


public class AttractionDao {
	private Connection conn = null;
	private CallableStatement cstmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	//MERGE INTO 테이블을 비교하여 값이 있으면 업데이트 값이 없으면 INSERT하는 구문 ()
			public void mergeAttraction(AttractionVo attractionVo) {
				try {
					DBConn db = new DBConn();
					conn = db.getConnection();
					
					 // UPDATE 또는 INSERT 명령으로 DB 에 공간 확보
	
					String   sql = "{CALL  PKG_PROJECT.PROC_ATTRACTION_MERGE( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
					cstmt = conn.prepareCall(sql);
					cstmt.setString(1,   attractionVo.getAttraction_id());
					cstmt.setString(2,   attractionVo.getAttraction_name());
					cstmt.setString(3,   attractionVo.getAttraction_gugun());
					cstmt.setString(4,   attractionVo.getAttraction_place());
					cstmt.setString(5,   attractionVo.getAttraction_title());
					cstmt.setString(6,   attractionVo.getAttraction_subtitle());
					cstmt.setString(7,   attractionVo.getAttraction_addr1());
					cstmt.setString(8,   attractionVo.getAttraction_tel());
					cstmt.setString(9,   attractionVo.getAttraction_site());
					cstmt.setString(10,  attractionVo.getAttraction_trfc_info());
					cstmt.setString(11,  attractionVo.getAttraction_usageday());
					cstmt.setString(12,  attractionVo.getAttraction_hldy_info());
					cstmt.setString(13,  attractionVo.getAttraction_time());
					cstmt.setString(14,  attractionVo.getAttraction_usage_amount());
					cstmt.setString(15,  attractionVo.getAttraction_convenient());
					cstmt.setString(16,  attractionVo.getAttraction_img());
					cstmt.setString(17,  attractionVo.getAttraction_thumb());	
					String cont = attractionVo.getAttraction_cont();
					String cont1 = "";
					String cont2 = "";
					String cont3 = "";
					String cont4 = "";
	
					/*
					if(cont.length()<1300) {
						cont1 = cont.substring(0,cont.length()-1);						
						
					} else if(cont.length()<2600) {
						cont1 = cont.substring(0,1300);
						cont2 = cont.substring(1301,cont.length()-1);	
					} else if(cont.length()<3900) {
						cont1 = cont.substring(0,1300);
						cont2 = cont.substring(1301,2600);
						cont3 = cont.substring(2601,cont.length()-1);
					} else if(cont.length()<5200) {
						cont1 = cont.substring(0,1300);
						cont2 = cont.substring(1301,2600);
						cont3 = cont.substring(2601,3900);
						cont4 = cont.substring(3901,cont.length()-1);
					}*/
					int bytelength = ApiUtil.getByteLen(cont);
					
					if(bytelength<3000) {
						cont1 = ApiUtil.substringByBytes(cont, 0, bytelength-1); //-1은 0부터 시작했기때문
								
					} else if(bytelength<6000) {
						cont1 = ApiUtil.substringByBytes(cont, 0, 3000);
	
						int n = ApiUtil.getByteLen(cont1);	
						
						cont2 = ApiUtil.substringByBytes(cont, n+1, bytelength-1);	
						
					} else if(bytelength<9000) {
						
						cont1 = ApiUtil.substringByBytes(cont, 0, 3000);
						
						int n = ApiUtil.getByteLen(cont1);
						
						cont2 = ApiUtil.substringByBytes(cont, n+1, 6000);	
						
						n = ApiUtil.getByteLen(cont1)+ApiUtil.getByteLen(cont2);
						
						cont3 = ApiUtil.substringByBytes(cont, n+1, bytelength-1);
					
					} else if(bytelength<12000) {
						cont1 = ApiUtil.substringByBytes(cont, 0, 3000);
						
						int n = ApiUtil.getByteLen(cont1);
						
						cont2 = ApiUtil.substringByBytes(cont, n+1, 6000);	
						
						n = ApiUtil.getByteLen(cont1)+ApiUtil.getByteLen(cont2);
						
						cont3 = ApiUtil.substringByBytes(cont, n+1, 9000);
						
						n = ApiUtil.getByteLen(cont1)+ApiUtil.getByteLen(cont2)+ApiUtil.getByteLen(cont3);
						
						cont4 = ApiUtil.substringByBytes(cont, n+1, bytelength-1);
					}
					
					System.out.println("cont1:" + cont1);					
					System.out.println("cont2:" + cont2);					
					System.out.println("cont3:" + cont3);					
					System.out.println("cont4:" + cont4);
					
					cstmt.setString(18, cont1);
					cstmt.setString(19, cont2);
					cstmt.setString(20, cont3);
					cstmt.setString(21, cont4);
					cstmt.executeUpdate();
					
					System.out.println("명소정보 업데이트 완료");
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
			public int getAttractionCount() {
			
				String sql = "select count(*) from TATTRACTION";
				int listAttractionCount = 0;
				
				try {
					DBConn   db  = new DBConn();
					conn         = db.getConnection();
					pstmt        = conn.prepareStatement(sql);
					
					rs           = pstmt.executeQuery();
					if(rs.next()) {
						listAttractionCount = rs.getInt(1);
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
				return listAttractionCount;
			}
			
			public ArrayList<AttractionVo> getAttractionList(int page, int limit) {
				String sql = "select * from";
				sql		  += " (select rownum rnum, ATTRACTION_ID, ATTRACTION_PLACE, ATTRACTION_THUMB, ATTRACTION_ADDR1 ";
				sql		  += " from TATTRACTION)";
				sql		  += " where rnum >= ? and rnum <= ?";
				int startRow = (page - 1) * 10 + 1;
				int endRow = startRow + limit - 1;
				
				ArrayList<AttractionVo> attractionList = new ArrayList<>();
				
				try {
					DBConn   db  = new DBConn();
					conn         = db.getConnection();
					pstmt        = conn.prepareStatement(sql);
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					
					rs           = pstmt.executeQuery();

					while(rs.next()) {
						AttractionVo attractionVo = new AttractionVo();
						attractionVo.setAttraction_id(rs.getString("attraction_id"));
						attractionVo.setAttraction_place(rs.getString("attraction_place"));
						attractionVo.setAttraction_thumb(rs.getString("attraction_thumb"));
						attractionVo.setAttraction_addr1(rs.getString("attraction_addr1"));

						attractionList.add(attractionVo);
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
				
				return attractionList;
			}
			
		public AttractionVo getDetailAttraction(String attraction_id) {
			AttractionVo attractionVo = new AttractionVo();
			
			String sql = "SELECT * FROM TATTRACTION WHERE ATTRACTION_ID=?";
			try {
				
				DBConn db 	= new DBConn();
				conn 		= db.getConnection();
				pstmt		= conn.prepareStatement(sql);
				pstmt.setString(1, attraction_id);
				rs= pstmt.executeQuery();
				
				if(rs.next()) {
					attractionVo = new AttractionVo();
					attractionVo.setAttraction_id(rs.getString("attraction_id"));
					attractionVo.setAttraction_name(rs.getString("attraction_name"));
					attractionVo.setAttraction_gugun(rs.getString("attraction_gugun"));
					attractionVo.setAttraction_place(rs.getString("attraction_place"));
					attractionVo.setAttraction_title(rs.getString("attraction_title"));
					attractionVo.setAttraction_subtitle(rs.getString("attraction_subtitle"));
					attractionVo.setAttraction_addr1(rs.getString("attraction_addr1"));
					attractionVo.setAttraction_tel(rs.getString("attraction_tel"));
					attractionVo.setAttraction_site(rs.getString("attraction_site"));
					attractionVo.setAttraction_trfc_info(rs.getString("attraction_trfc_info"));
					attractionVo.setAttraction_usageday(rs.getString("attraction_usageday"));
					attractionVo.setAttraction_hldy_info(rs.getString("attraction_hldy_info"));
					attractionVo.setAttraction_time(rs.getString("attraction_time"));
					attractionVo.setAttraction_usage_amount(rs.getString("attraction_usage_amount"));
					attractionVo.setAttraction_convenient(rs.getString("attraction_convenient"));
					attractionVo.setAttraction_img(rs.getString("attraction_img"));
					attractionVo.setAttraction_thumb(rs.getString("attraction_thumb"));
					attractionVo.setAttraction_cont1(rs.getString("attraction_cont1"));
					attractionVo.setAttraction_cont2(rs.getString("attraction_cont2"));
					attractionVo.setAttraction_cont3(rs.getString("attraction_cont3"));
					attractionVo.setAttraction_cont4(rs.getString("attraction_cont4"));
					attractionVo.setAttraction_good(rs.getString("attraction_good"));
					attractionVo.setAttraction_bad(rs.getString("attraction_bad"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
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
			return attractionVo;
		}
		public ArrayList<AttractionVo> getSearchAttractionNameList(int page, int limit, String keyword) {
			AttractionVo attractionVo = new AttractionVo();
			String sql = "select * from";
			sql		  += " (select rownum rnum, ATTRACTION_ID, ATTRACTION_PLACE, ATTRACTION_TEL, ATTRACTION_ADDR1, ATTRACTION_GUGUN ";
			sql		  += " from TATTRACTION)";
			sql		  += " where rnum >= ? and rnum <= ?";
			sql		  += " and ATTRACTION_PLACE LIKE ?";
			int startRow = (page - 1) * 10 + 1;
			int endRow = startRow + limit - 1;
			
			ArrayList<AttractionVo> searchAttractionNameList = new ArrayList<>();
			try {
				DBConn   db  = new DBConn();
				conn         = db.getConnection();
				pstmt        = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				pstmt.setString(3, "%" + keyword + "%");
				rs           = pstmt.executeQuery();
				
				while(rs.next()) {
					attractionVo = new AttractionVo();
					attractionVo.setAttraction_id(rs.getString("attraction_id"));
					attractionVo.setAttraction_place(rs.getString("attraction_place"));
					attractionVo.setAttraction_tel(rs.getString("attraction_tel"));
					attractionVo.setAttraction_addr1(rs.getString("attraction_addr1"));
					attractionVo.setAttraction_gugun(rs.getString("attraction_gugun"));

					searchAttractionNameList.add(attractionVo);
					System.out.println("야호");
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
		
		return searchAttractionNameList;

		}
		public ArrayList<AttractionVo> getSearchAttractionGugunList(int page, int limit, String keyword) {
			AttractionVo attractionVo = new AttractionVo();
			String sql = "select * from";
			sql		  += " (select rownum rnum, ATTRACTION_ID, ATTRACTION_PLACE, ATTRACTION_TEL, ATTRACTION_ADDR1, ATTRACTION_GUGUN ";
			sql		  += " from TATTRACTION)";
			sql		  += " where rnum >= ? and rnum <= ?";
			sql		  += " and Attraction_gugun like ?";
			int startRow = (page - 1) * 10 + 1;
			int endRow = startRow + limit - 1;
			
			ArrayList<AttractionVo> searchAttractionGugunList = new ArrayList<>();
			try {
				DBConn   db  = new DBConn();
				conn         = db.getConnection();
				pstmt        = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				pstmt.setString(3, "%" + keyword + "%");
				rs           = pstmt.executeQuery();
				
				while(rs.next()) {
					attractionVo = new AttractionVo();
					attractionVo.setAttraction_id(rs.getString("attraction_id"));
					attractionVo.setAttraction_place(rs.getString("attraction_place"));
					attractionVo.setAttraction_tel(rs.getString("attraction_tel"));
					attractionVo.setAttraction_addr1(rs.getString("attraction_addr1"));
					attractionVo.setAttraction_gugun(rs.getString("attraction_gugun"));

					searchAttractionGugunList.add(attractionVo);
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
		
		return searchAttractionGugunList;

		}
		public int getAttractionNameCount(String keyword) {
			
			String sql = "select count(ATTRACTION_PLACE) from TATTRACTION";
				   sql+= " WHERE ATTRACTION_PLACE LIKE ?";
			int listAttractionNameCount = 0;
			
			try {
				DBConn   db  = new DBConn();
				conn         = db.getConnection();
				pstmt        = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + keyword + "%");
				
				rs           = pstmt.executeQuery();
				
				if(rs.next()) {
					listAttractionNameCount = rs.getInt(1);
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
			return listAttractionNameCount;
		}
public int getAttractionGugunCount(String keyword) {
			
			String sql = "select count(ATTRACTION_GUGUN) from TATTRACTION";
				   sql+= " WHERE ATTRACTION_PLACE LIKE ?";
			int listAttractionGugunCount = 0;
			
			try {
				DBConn   db  = new DBConn();
				conn         = db.getConnection();
				pstmt        = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + keyword + "%");
				
				rs           = pstmt.executeQuery();
				
				if(rs.next()) {
					listAttractionGugunCount = rs.getInt(1);
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
			return listAttractionGugunCount;
		}
}