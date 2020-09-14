package focusservices.pages;

import org.openqa.selenium.WebElement;
import focusservices.tools.Automationtools;

public class Page {
	public static Automationtools base;
	protected String sBrowserName;
	protected String sUrlPage;
	protected WebElement driver;
	
	public Boolean openPage() {
		return true;
	}
	
	public Boolean closePage() {
		return true;
	}
}
