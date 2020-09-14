package focusservices.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import focusservices.site.*;

class GoToGoogle_Test {
	Site site;
	
	@BeforeEach
	void setUp() throws Exception {
		site = new Site();
	}

	@AfterEach
	void tearDown() throws Exception {
		site.closeSite();
	}

	@Test
	void test() {
		site.gotoGoogle();
		assertEquals("https://www.google.com/",site.getURLSite());
	}
}
