package focusservices.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import focusservices.site.Site;

class LocateNorthAmericaLink_Test {
	Site site;
	Boolean bResult;
	
	@BeforeEach
	void setUp() throws Exception {
		site = new Site();
		site.gotoGoogle();
		site.searchPhrase();
		site.verifyUrlExist();
		site.scrollDownToBottomPage();
		site.verifyBtnExists();
		site.gotoLocationsTab();
	}

	@AfterEach
	void tearDown() throws Exception {
		site.closeSite();
	}

	@Test
	void test() {
		bResult = site.northAmericaLocation();
		assertTrue(bResult,"https://www.focusservices.com/locations/#north-america");
	}
}
