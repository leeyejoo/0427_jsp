
package service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

class JunitTest {
	CovidXMLService covidService = new CovidXMLService(); //코로나
	CountryJSONService countryService = new CountryJSONService(); //국가별 최신안전소식
	
	
	@Test
	void testCovid(){
		covidService.covidParsing("20220310","20220311");
	}
	
	
	
	@Test
	void testCountry(){
		List<Map<String, String>> clist = countryService.countryParsing("HK");
		//System.out.println(clist);
	}

}