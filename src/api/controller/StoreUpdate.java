package api.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

import api.dao.StoreDao;
import api.vo.StoreVo;

@WebServlet("/storeUpdate")
public class StoreUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 넘어온 파라미터 준비
		request.setCharacterEncoding("UTF-8");
		//String  areaCode = request.getParameter("areaCode");
		String  key      = "KXN1uZAS0y4f6aniD9gHcr%2BQ1AJbWqFYX4kdKtbGbTfUhugGNvQnA6RP0P%2BhUkrEiWZF1gbo%2BnnxdaHSy27GZw%3D%3D";

		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6260000/FoodService/getFoodKr"); /*URL*/
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

			JSONObject getFoodKr = (JSONObject) obj.get("getFoodKr"); 

			//System.out.println("getFoodKr:" + getFoodKr);
			
			JSONArray  storeList = (JSONArray) getFoodKr.get("item"); //getFoodKr의 item들을 JSONArray로 캐스팅하여 storeList안에 담아준다.
			System.out.println("storeList:" + storeList); 
			
			StoreDao storeDao = new StoreDao(); //DAO생성자 선언
			
			for(int i=0;i<storeList.size();i++) {
				JSONObject store = (JSONObject) storeList.get(i); // 배열을 하나하나 잘라서 store라는 JSONObject에 넣어준다.
				long store_id = (long) store.get("UC_SEQ"); // API상에서 UC_SEQ를 long로 받아와주기 때문에 캐스팅
				String store_name = (String)store.get("MAIN_TITLE");
				String store_gugun = (String)store.get("GUGUN_NM");
				String store_ex = (String)store.get("TITLE");	
				String store_addr = (String)store.get("ADDR1");
				String store_addr2 = (String)store.get("ADDR2");
				String store_tel = (String)store.get("CNTCT_TEL");
				String store_site = (String)store.get("HOMEPAGE_URL");
				String store_time = (String)store.get("USAGE_DAY_WEEK_AND_TIME");
				String store_menu = (String)store.get("RPRSNTV_MENU");
				String store_img = (String)store.get("MAIN_IMG_NORMAL");
				String store_thumb = (String)store.get("MAIN_IMG_THUMB");
				String store_cont = (String)store.get("ITEMCNTNTS");
				
				
				StoreVo storeVo = new StoreVo(String.valueOf(store_id), store_name, store_gugun, store_ex, store_addr,
							store_addr2, store_tel, store_site, store_time, store_menu,
							store_img, store_thumb, store_cont);
				System.out.println(storeVo);
				//storeDao.addStore(storeVo); //패키지 INSERT구문
				storeDao.mergeStore(storeVo); //패키지 MERGER구문 (비교후 내용유무를 판단하여 있으면 업데이트 없으면 인서트하는 기능 : MERGE INTO)
			}
			
			//System.out.println(obj.get("title"));			
		//	System.out.println(obj.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//response.setContentType("application/json;charset=UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter  out = response.getWriter();
		out.print(json);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
