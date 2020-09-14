package focusservices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FocusPage extends Page{
	String sUrlPage;
	By bodyLocator = By.tagName("body");
	By footerLocator = By.className("copyright");
	By btnLocator = By.tagName("a");
	By tabLocator = By.linkText("Locations");
	By nAmericaLocator = By.linkText("NORTH AMERICA");
	By cAmericaLocator = By.partialLinkText("CENTRAL AMERICA");
	By h2Locator = By.tagName("h2");
	By asiaLocator = By.linkText("ASIA");
	By textBlockLocator = By.tagName("h3");
	
	public FocusPage(String sURL) {
		sUrlPage = sURL;
	}
	//Scroll down to the bottom of the page
	public void scrollDownToBottomPage(){
		base.scrollDown(bodyLocator);
		base.sWait(5);
	}
	//Verification Test
	public String getFooterText() {
		return base.getText(footerLocator);
	}
	//Verify the Now Hiring button exists into this page
	public Boolean verifyBtnExists(String sBtnName) {
		for(WebElement NowHiringBtn : base.findElements(btnLocator)) {
			if(sBtnName.equals(NowHiringBtn.getText())) {
				return true;
			}
		}
		return false;
	}
	//Click on America Locations Tab
	public Boolean gotoLocationsTab() {
		if(base.isDisplayed(tabLocator)) {
			base.findElement(tabLocator);
			base.click(tabLocator);
			base.sWait(8);
			return true;
		}
		return false;
	}
	//Locate North America Link. Do an assert on this link
	public Boolean northAmericaLocation(String sExpectedUrl) {
		if(sExpectedUrl.equals(base.getHrefAttribute(nAmericaLocator))) {
			base.findElement(nAmericaLocator);
			base.sWait(8);
			return true;
		}
		return false;
	}
	//Click on Central America location
	public Boolean centralAmericaLocation() {
		if(base.isDisplayed(cAmericaLocator)) {
			base.findElement(cAmericaLocator);
			base.click(cAmericaLocator);
			base.sWait(8);
			return true;
		}
		return false;
	}
	//Validate “El Salvador & Nicaragua” title is displayed on the page
	public boolean validateTitleDisplayedOnPage() {
		if(base.isDisplayed(h2Locator)) {
			base.getText(h2Locator);
			return true;
		}
		return false;
	}
	//Click on Asia Location
	public Boolean asiaLocation() {
		if (base.isDisplayed(asiaLocator)) {
			base.findElement(asiaLocator);
			base.click(asiaLocator);
			base.sWait(8);
			return true;
		}
		return false;
	}
	//Verify if exist the “Bacolod City, Philippines” text block
	public Boolean verifyTextBlockExists() {
		for(WebElement textBlock : base.findElements(textBlockLocator)) {
			if("Bacolod City, Philippines".equals(textBlock.getText())) {
				return true;
			}
		}
		return false;
	}
}
