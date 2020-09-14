package focusservices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GooglePage extends Page{
	String sUrlPage;
	By inputLocator = By.name("q");
	By listLocator = By.tagName("a");
	By titleLocator = By.tagName("title");
	
	public GooglePage(String sURL) {
		sUrlPage = sURL;
	}
	//Go to google page method
	public Boolean gotoGoogle() {
		return base.gotoPage(sUrlPage);
	}
	//Search phrase on google page method
	public void searchPhrase(String sPhrase) {
		if(base.isDisplayed(inputLocator)) {
			base.sendKey(sPhrase, inputLocator);
			base.sWait(5);
		}else {
			System.out.println("Error: the element was not located");
		}
	}
	//Verification Test
	public String getPhrase() {
		return base.getValueAttribute(inputLocator);
	}
	//Find Focus Services URL on google search end verification Test
	public Boolean verifyUrlExist(String sMainUrl) {
		for(WebElement link : base.findElements(listLocator)) {
			if(sMainUrl.equals(link.getAttribute("href"))) {
				link.click();
				return true;
			}
		}
		return false;
	}
}
