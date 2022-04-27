package service;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import dao.CountryDAO;

import java.io.BufferedReader;
import java.io.IOException;

public class CountryJSONService {
	public CountryDAO countryDAO = new CountryDAO();
    public List<Map<String, String>> countryParsing(String ISO)  {//static 빼기!!
    	//데이터포털 : 외교부_국가.지역별 최신안전소식(코로나관련)
    	
    	//반환값 Map
    	List<Map<String, String>> clist = new ArrayList<>();
    	
    	try {
    		//예외 : 체크예와(반드시처리)와 언체크예외(RuntimeException을 상속(실행시체크))
    		 StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1262000/CountryCovid19SafetyServiceNew/getCountrySafetyNewsListNew"); /*URL*/
    	        String servicekey="weMUFBwS%2BTRFEJtEq1kpOjhawC%2BhG8O5HpaJVsxoqLnV0%2Ftm2A%2BOUnhKXvC3eGCb0kKk2XyS%2FU%2BMavsBv4QPpA%3D%3D";
    	   
    	        
    	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + servicekey); /*Service Key*/
    	        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*XML 또는 JSON*/
    	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
    	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
    	 //       urlBuilder.append("&" + URLEncoder.encode("cond[country_nm::EQ]","UTF-8") + "=" + URLEncoder.encode("독일", "UTF-8")); /*한글 국가명*/
    	        urlBuilder.append("&" + URLEncoder.encode("cond[country_iso_alp2::EQ]","UTF-8") + "=" + URLEncoder.encode(ISO, "UTF-8")); /*ISO 2자리코드*/
    	        URL url = new URL(urlBuilder.toString());
    	        System.out.println(url);
    	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    	        conn.setRequestMethod("GET");
    	        conn.setRequestProperty("Content-type", "application/json");
    	        System.out.println("Response code: " + conn.getResponseCode());
    	        BufferedReader rd;
    	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
    	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    	        } else {
    	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
    	        }
    	        StringBuilder sb = new StringBuilder();
    	        String line;
    	        while ((line = rd.readLine()) != null) {
    	            sb.append(line);
    	        }
    	        rd.close();
    	        conn.disconnect();
    	        System.out.println(sb.toString()); 	//제이슨 형태의 문자열 데이터
    	        
    	        
    	        //JSON파싱
    	        //파싱라이브러리 : json-simple-1.1.1.jar
    	        JSONParser parser  = new JSONParser();
    	        JSONObject object = (JSONObject)parser.parse(sb.toString());  // 문자열을 JSON의 객체형태로 변경 (다운캐스팅)
    	        JSONArray array = (JSONArray)object.get("data"); //반환해주는 데이터가 []로 싸여 있으니까 json의 array
    	        
    	        System.out.println(array); //배열이기 때문에 반복문을 돌릴 수가 있다.
    	        System.out.println("---------------------");
    	        
    	        for(int i=0; i<array.size(); i++) { //object에서 get할땐 key, array에서 get할땐 index
//    	        	System.out.println(array.get(i)); 
    	        	System.out.println(i +"--------------------");
    	        	Map<String,String> map =new HashMap<>(); //한건을 넣을 맵
    	        	
    	        	
    	        	object = (JSONObject) array.get(i);
    	        	
    	        	//직접 key를 하드코딩 => 키이름이 바뀌면 다시 수정해줘야한다.
//    	        	String country_nm =(String) object.get("country_nm");
//    	        	String wrt_dt =(String) object.get("wrt_dt");
//    	        	
//    	        	System.out.println(country_nm);
//    	        	System.out.println(wrt_dt);
    	        	
    	        	
    	        	//key의 목록을 가져와서 반복문 
    	        	//Set특징 : 중복데이터 안됨
    	        	Set<String> kset = object.keySet();
    	        	for(String key : kset) {
    	        		//                  키 : 키값 
    	 //       		System.out.println(key+":"+ object.get(key)) ;
    	        		
    	        		map.put(key, (String)object.get(key));
    	        				//key안에 key 이름이 들어가있다
    	        	}
//    	       	System.out.println(map);
    	        	clist.add(map);
    	        }
    		
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	
//        System.out.println("===================");
//        System.out.println(clist);
        
        return clist;
    }

	public List<Map<String, String>> selectList_iso() {
		//iso조회
		
		return countryDAO.selectList_iso();
	}
}
