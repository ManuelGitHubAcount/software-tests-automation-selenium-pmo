package focusservices.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import focusservices.site.*;

class ScrollDownToBottomPage_Test {
	Site site;
	@BeforeEach
	void setUp() throws Exception {
		site = new Site();
		site.gotoGoogle();
		site.searchPhrase();
		site.verifyUrlExist();
	}

	@AfterEach
	void tearDown() throws Exception {
		site.closeSite();
	}

	@Test
	void test() throws Exception {
		site.scrollDownToBottomPage();				
		assertEquals("© Copyright 2019 - Focus Services", site.getFooterText());
	}
}
