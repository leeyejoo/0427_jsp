package service;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
public class CulturalEventService {
	//http://data.seoul.go.kr/dataList/OA-15486/S/1/datasetView.do#AXexec
	//서울문화정보
	
	public List<Map<String, String>> culturalParsing(String codename) {
	
		String servicekey ="4642634b45636f6f3530544c424372" ; //서비스키
		
		
		StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088");
		List<Map<String, String>> cultureList = new ArrayList<>();
		
		
		try {
			// URL만들기
			urlBuilder.append("/"+URLEncoder.encode(servicekey,"utf-8")); /*인증키 */
			urlBuilder.append("/" + URLEncoder.encode("xml","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
			urlBuilder.append("/" + URLEncoder.encode("culturalEventInfo","UTF-8")); /*서비스명*/
			urlBuilder.append("/" + URLEncoder.encode("1","UTF-8")); /*요청시작위치 */
			urlBuilder.append("/" + URLEncoder.encode("30","UTF-8")); /*요청종료위치 */
			urlBuilder.append("/" + URLEncoder.encode(codename,"UTF-8")); /*분류 (선택) */
			//urlBuilder.append("/" + URLEncoder.encode("5","UTF-8")); /*공연ㆍ행사명(선택)*/
			System.out.println(urlBuilder.toString());
			
			//url 접속
			
			URL url = new URL(urlBuilder.toString());
		    
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/xml");
			  
			//서비스코드가 정상일 시 ,200번대 숫자 출력
			System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;
			  
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {//데이터가 존재하면
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
			//System.out.println(sb.toString());
			
			
			//xml파싱
			
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(urlBuilder.toString()); 
	        NodeList nlist = doc.getElementsByTagName("row");
	        System.out.println("데이터 갯수:"+nlist.getLength()); //데이터의 수
	        
	        //반복문을 이용하여 nlist 안의 자식노드들을 생성 => 자식노드의 이름과 내용을 맵에 넣기
	        for(int i=0; i<nlist.getLength(); i++) {
	        	NodeList clist =  nlist.item(i).getChildNodes();	//자식노드 생성
	        	
	        	Map<String, String> cmap = new HashMap<>();
	        	for( int j=0; j<clist.getLength(); j++) {
	        		Node node = clist.item(j);
	        		//System.out.println(node.getNodeName() +":" +node.getTextContent());
	        		
	        		cmap.put(node.getNodeName(), node.getTextContent());
	        	}
	        	cultureList.add(cmap); // 노드가 들어있는 map의 리스트
	        	 
	        }	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(cultureList);
		return cultureList;
	}
}


