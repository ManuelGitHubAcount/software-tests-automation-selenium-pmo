package focusservices.site;

import focusservices.pages.FocusPage;
import focusservices.pages.GooglePage;
import focusservices.pages.HomePage;

public class Site extends SiteResources{
	public GooglePage GooglePage;
	public FocusPage FocusPage;
	public HomePage HomePage;
	
	public Site () {
		HomePage = new HomePage(sBrowserName, sURLSite);
		GooglePage = new GooglePage(sURLSite);
		FocusPage = new FocusPage(sURLSite);
	}
	
	public Boolean gotoGoogle() {
		return GooglePage.gotoGoogle();
	}

	public void searchPhrase() {
		GooglePage.searchPhrase(sPhrase);
	}

	public String getPhrase() {
		return GooglePage.getPhrase();
	}

	public Boolean verifyUrlExist() {
		return GooglePage.verifyUrlExist(sMainUrl);
	}
		
	public void scrollDownToBottomPage() {
		FocusPage.scrollDownToBottomPage();	
	}

	public String getFooterText() {
		return FocusPage.getFooterText();
	}

	public Boolean verifyBtnExists() {
		return FocusPage.verifyBtnExists(sBtnName);
	}
	
	public Boolean gotoLocationsTab() {
		return FocusPage.gotoLocationsTab();
	}
	
	public Boolean northAmericaLocation() {
		return FocusPage.northAmericaLocation(sExpectedUrl);
	}
	
	public Boolean centralAmericaLocation() {
		return FocusPage.centralAmericaLocation();
	}
	
	public Boolean validateTitleDisplayedOnPage() {
		return FocusPage.validateTitleDisplayedOnPage();
	}
	
	public Boolean asiaLocation() {
		return FocusPage.asiaLocation();
	}
	
	public Boolean verifyTextBlockExists() {
		return FocusPage.verifyTextBlockExists();
	}
			
	public void closeSite() {
		HomePage.close();
	}
}
