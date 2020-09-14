package focusservices.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import focusservices.site.Site;

class verifyNowHiringBtnExists_Test {
	Site site;
	Boolean bResult;
	
	@BeforeEach
	void setUp() throws Exception {
		site = new Site();
		site.gotoGoogle();
		site.searchPhrase();
		site.verifyUrlExist();
		site.scrollDownToBottomPage();
	}

	@AfterEach
	void tearDown() throws Exception {
		site.closeSite();
	}

	@Test
	void test() {
		bResult = site.verifyBtnExists();
		assertTrue(bResult,"Now Hiring!");
	}
}
