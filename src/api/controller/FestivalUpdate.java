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

import api.dao.FestivalDao;
import api.vo.FestivalVo;

@WebServlet("/festivalUpdate")
public class FestivalUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String key = "KXN1uZAS0y4f6aniD9gHcr%2BQ1AJbWqFYX4kdKtbGbTfUhugGNvQnA6RP0P%2BhUkrEiWZF1gbo%2BnnxdaHSy27GZw%3D%3D";
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6260000/FestivalService/getFestivalKr");
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

				JSONObject getFestivalKr = (JSONObject) obj.get("getFestivalKr"); 

				//System.out.println("getFestivalKr:" + getFestivalKr);
				
				JSONArray  festivalList = (JSONArray) getFestivalKr.get("item"); //getFoodKr의 item들을 JSONArray로 캐스팅하여 storeList안에 담아준다.
				System.out.println("festivalList:" + festivalList); 
				
				FestivalDao festivalDao = new FestivalDao(); //DAO생성자 선언
				
				for(int i=0;i<festivalList.size();i++) {
					JSONObject festival = (JSONObject) festivalList.get(i); // 배열을 하나하나 잘라서 store라는 JSONObject에 넣어준다.
					long festival_id = (long) festival.get("UC_SEQ"); // API상에서 UC_SEQ를 long로 받아와주기 때문에 캐스팅
					String festival_name = (String)festival.get("MAIN_TITLE");
					String festival_gugun= (String)festival.get("GUGUN_NM");
					String festival_place= (String)festival.get("PLACE");
					String festival_title= (String)festival.get("TITLE");
					String festival_subtitle= (String)festival.get("SUBTITLE");
					String festival_main_place= (String)festival.get("MAIN_PLACE");
					String festival_addr1= (String)festival.get("ADDR1");
					String festival_addr2= (String)festival.get("ADDR2");
					String festival_tel= (String)festival.get("CNTCT_TEL");
					String festival_site= (String)festival.get("HOMEPAGE_URL");
					String festival_trfc_info= (String)festival.get("TRFC_INFO");
					String festival_usageday= (String)festival.get("USAGEDAY");
					String festival_time= (String)festival.get("USAGE_DAY_WEEK_AND_TIME");
					String festival_usage_amount= (String)festival.get("USAGE_AMOUNT");
					String festival_img= (String)festival.get("MAIN_IMG_NORMAL");
					String festival_thumb= (String)festival.get("MAIN_IMG_THUMB");
					String festival_cont= (String)festival.get("ITEMCNTNTS");
					String fesitval_convenient= (String)festival.get("MIDDLE_SIZE_RM1");
				
					FestivalVo festivalVo = new FestivalVo(String.valueOf(festival_id),festival_name,festival_gugun,festival_place,festival_title,
															festival_subtitle,festival_main_place,festival_addr1,festival_addr2,festival_tel,
															festival_site,festival_trfc_info,festival_usageday,festival_time,festival_usage_amount,
															festival_img,festival_thumb,festival_cont,fesitval_convenient);
					System.out.println(festivalVo);
					//festivalDao.addFestival(festivalVo); //패키지 INSERT구문
					festivalDao.mergeFestival(festivalVo); //패키지 MERGER구문 (비교후 내용유무를 판단하여 있으면 업데이트 없으면 인서트하는 기능 : MERGE INTO)
				}
			}catch (ParseException e) {
				e.printStackTrace();
			}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
