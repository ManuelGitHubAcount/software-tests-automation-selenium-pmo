package focusservices.pages;

import focusservices.tools.Automationtools;

public class HomePage extends Page{

	public HomePage (String sBrowserName, String sURLSite) {
		base = new Automationtools();
		base.openBrowser(sBrowserName);
	}
	@Override
	public Boolean openPage() {
		base.gotoPage(sUrlPage);
		return true;
	}
	//Close the Browser
	public Boolean close() {
		base.closeBrowser();
		return true;
	}
}
