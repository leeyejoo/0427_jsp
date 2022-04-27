package service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JunitTest {

	private CulturalEventService Cservice = new CulturalEventService();
	
	@Test
	void culturalParsingTest() {
		Cservice.culturalParsing("뮤지컬");
	}

}
