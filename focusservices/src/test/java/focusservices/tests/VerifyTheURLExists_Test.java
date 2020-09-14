package focusservices.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import focusservices.site.*;

class VerifyTheURLExists_Test {
	Site site;
	Boolean bResult;
	
	@BeforeEach
	void setUp() throws Exception {
		site = new Site();
		site.gotoGoogle();
		site.searchPhrase();
	}

	@AfterEach
	void tearDown() throws Exception {
		site.closeSite();
	}

	@Test
	void test() {
		bResult = site.verifyUrlExist();
		assertTrue(bResult,"https://www.focusservices.com/");
	}
}
