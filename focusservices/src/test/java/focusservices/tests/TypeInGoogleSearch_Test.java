package focusservices.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import focusservices.site.*;

class TypeInGoogleSearch_Test {
	Site site;
	
	@BeforeEach
	void setUp() throws Exception {
		site = new Site();
		site.gotoGoogle();
	}

	@AfterEach
	void tearDown() throws Exception {
		site.closeSite();
	}

	@Test
	void test() {
		site.searchPhrase();
		assertEquals("Focus Services", site.getPhrase());
	}
}
