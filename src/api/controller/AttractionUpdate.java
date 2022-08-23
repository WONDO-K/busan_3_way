package api.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import api.dao.AttractionDao;
import api.vo.AttractionVo;

@WebServlet("/attractionUpdate")
public class AttractionUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String key = "KXN1uZAS0y4f6aniD9gHcr%2BQ1AJbWqFYX4kdKtbGbTfUhugGNvQnA6RP0P%2BhUkrEiWZF1gbo%2BnnxdaHSy27GZw%3D%3D";
	
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6260000/AttractionService/getAttractionKr");
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + key); /*공공데이터포털에서 받은 인증키*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("300", "UTF-8")); /*한 페이지 결과 수*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
		urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*JSON방식으로 호출 시 파라미터 resultType=json 입력*/
		//urlBuilder.append("&" + URLEncoder.encode("UC_SEQ","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*콘텐츠 ID*/
		
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection  conn = (HttpURLConnection) url.openConnection(); // $.ajax
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response Code:" + conn.getResponseCode());  // 200, 404, 500
		
		// 도착한 데이터 처리
		BufferedReader   br;
		if( conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300 ) {
			br = new BufferedReader(new InputStreamReader(conn.getInputStream() ));
		} else {
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream() ));			
		}
	//  data -> 문자열로 변환
			StringBuilder  sb     = new StringBuilder();
			String         line;
			while( ( line = br.readLine() ) != null ) {
				sb.append( line );
			}
			br.close();
			conn.disconnect();
			String jsonStr = sb.toString() ;
			System.out.println( sb.toString() );
			// 출력
			String json = sb.toString( );

			//-----------------------------------------------
			//JSON객채를 문자열로 변환하는 구문
			JSONParser p = new JSONParser();

			JSONObject obj;
			try {
				obj = (JSONObject) p.parse( json );
				System.out.println("obj:                         " + obj);
				
				JSONObject getAttractionKr = (JSONObject) obj.get("getAttractionKr");
				
				//System.out.println("getAttractionKr:" + getAttractionKr);
				
				JSONArray  attractionList = (JSONArray) getAttractionKr.get("item"); //getAttractionKr의 item들을 JSONArray로 캐스팅하여 storeList안에 담아준다.
				System.out.println("attractionList:" + attractionList);
				
				AttractionDao attractionDao = new AttractionDao();//DAO생성자 선언
				
				for(int i=0;i<attractionList.size();i++) {
					JSONObject attraction = (JSONObject) attractionList.get(i); // 배열을 하나하나 잘라서 store라는 JSONObject에 넣어준다.
					long attraction_id 				= (long) attraction.get("UC_SEQ"); // API상에서 UC_SEQ를 long로 받아와주기 때문에 캐스팅
					String attraction_name 			= (String)attraction.get("MAIN_TITLE");
					String attraction_gugun 		= (String)attraction.get("GUGUN_NM");
					String attraction_place 		= (String)attraction.get("PLACE");
					String attraction_title 		= (String)attraction.get("TITLE");
					String attraction_subtitle 		= (String)attraction.get("SUBTITLE");
					String attraction_addr1 		= (String)attraction.get("ADDR1");
					String attraction_tel 			= (String)attraction.get("CNTCT_TEL");
					String attraction_site 			= (String)attraction.get("HOMEPAGE_URL");
					String attraction_trfc_info 	= (String)attraction.get("TRFC_INFO");
					String attraction_usageday 		= (String)attraction.get("USAGEDAY");
					String attraction_hldy_info 	= (String)attraction.get("HLDY_INFO");
					String attraction_time 			= (String)attraction.get("USAGE_DAY_WEEK_AND_TIME");
					String attraction_usage_amount 	= (String)attraction.get("USAGE_AMOUNT");
					String attraction_convenient 	= (String)attraction.get("MIDDLE_SIZE_RM1");
					String attraction_img 			= (String)attraction.get("MAIN_IMG_NORMAL");
					String attraction_thumb 		= (String)attraction.get("MAIN_IMG_THUMB");
					String attraction_cont	 		= (String)attraction.get("ITEMCNTNTS");
					//String attraction_cont2 		= (String)attraction.get("ITEMCNTNTS");
				
					
				    
					AttractionVo attractionVo = new AttractionVo(String.valueOf(attraction_id),attraction_name,attraction_gugun,attraction_place,
																 attraction_title,attraction_subtitle,attraction_addr1,attraction_tel,attraction_site,
																 attraction_trfc_info,attraction_usageday,attraction_hldy_info,attraction_time,attraction_usage_amount,
																 attraction_convenient,attraction_img,attraction_thumb,attraction_cont); 
					
					
					attractionDao.mergeAttraction(attractionVo); //패키지 MERGER구문 (비교후 내용유무를 판단하여 있으면 업데이트 없으면 인서트하는 기능 : MERGE INTO)
				}
			}catch (ParseException e) {
				e.printStackTrace();
			}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
