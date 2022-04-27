package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import dto.Covid;

class JunitTest {

	CovidDAO covidDAO = new CovidDAO();
	
	@Test
	void test() {
		Map<String, String> map = new HashMap<>();
		map.put("startDt","20220401");
		map.put("endDt", "20220405");

		List<Covid> covidList = covidDAO.selectList(map);
		System.out.println(covidList);
		
	}

}
