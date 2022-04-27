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

import dao.CovidDAO;
import dto.Covid;

import java.io.BufferedReader;
import java.io.IOException;

//코로나 확진자 일일현황 api
public class CovidXMLService{
	private CovidDAO covidDAO = new CovidDAO();
	
    public int covidParsing(String startDt, String endDt) {
        //맵의 리스트 생성(반환값) 
        List<Map<String, String>> covidList = new ArrayList<>(); 
        
		// startDt, endDt 문자'-' 빼기
		startDt = startDt.replace("-", "");
		endDt = endDt.replace("-", "");
        
    	try {
        	//url 만들기
        	//String serviceKey = "uMngqDWghlCUM7FKSQhTMPHD6Pw05QrJz2IoKje4tLozlhVZNfN1V6d78mbWCXI8Pixkrmhtd8vWQiMEwntxEA%3D%3D";
        	String serviceKey = "weMUFBwS%2BTRFEJtEq1kpOjhawC%2BhG8O5HpaJVsxoqLnV0%2Ftm2A%2BOUnhKXvC3eGCb0kKk2XyS%2FU%2BMavsBv4QPpA%3D%3D";
            StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("5", "UTF-8")); /*한 페이지 결과 수*/
            urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode(startDt, "UTF-8")); /*검색할 생성일 범위의 시작*/
            urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode(endDt, "UTF-8")); /*검색할 생성일 범위의 종료*/
            System.out.println(urlBuilder.toString());

            //url 접속
//            URL url = new URL(urlBuilder.toString());
            
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Content-type", "application/json");
//            
//            //결과값 : Response code가 200번대 이면 정상
//            //보조스트림을 이용해서 라인단위로 읽을수 있게 변경
//            System.out.println("Response code: " + conn.getResponseCode());
//            BufferedReader rd;
//            if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            } else {
//                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//            }
//            StringBuilder sb = new StringBuilder();
//            String line;
//            while ((line = rd.readLine()) != null) {//데이터가 존재하면
//                sb.append(line);
//            }
//            rd.close();
//            conn.disconnect();
//            System.out.println(sb.toString());
            
            //xml파싱
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(urlBuilder.toString());
            NodeList nlist = doc.getElementsByTagName("item");
            System.out.println("데이터갯수:" + nlist.getLength());
            
            for(int i=0; i < nlist.getLength(); i++) {
            	NodeList clist =  nlist.item(i).getChildNodes(); //자식노드들
            	
            	//맵생성(한건)
            	Map<String, String> cmap = new HashMap<>();
            	for(int j=0; j<clist.getLength(); j++) {
            		Node node = clist.item(j);
                	//System.out.println(node.getNodeName() + ":" + node.getTextContent());
            		
            		cmap.put(node.getNodeName(),node.getTextContent() );
            	}
            	//System.out.println("------------------------------");
            	covidList.add(cmap); //map의 리스트
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	
    	
    	//dao 호출 db저장
    	int cnt = covidDAO.insert(covidList);
    	System.out.println(cnt+"건추가");
    	
        return cnt;
 
    }
    

    
	public List<Covid> selectList(String startDt, String endDt) {
		Map<String, String> map = new HashMap<>();
		
		startDt = startDt.replace("-", "");
		endDt = endDt.replace("-", "");
		
		map.put("startDt", startDt);
		map.put("endDt", endDt);
		
		List<Covid> covidlist = covidDAO.selectList(map);
		return covidlist;
		
	}
   
    
}
