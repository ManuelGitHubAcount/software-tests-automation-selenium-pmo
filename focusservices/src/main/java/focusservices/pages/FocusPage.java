package focusservices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FocusPage extends Page{
	WebDriver driver;
	String sUrlPage;
	By bodyLocator = By.tagName("body");
	By footerLocator = By.className("copyright");
	By btnLocator = By.tagName("a");
	By tabLocator = By.linkText("Locations");
	By nAmericaLocator = By.linkText("NORTH AMERICA");
	By cAmericaLocator = By.partialLinkText("CENTRAL AMERICA");
	By h2Locator = By.cssSelector("#av-tab-section-1 > div > div.av-tab-section-inner-container.avia-section-default > div.av-layout-tab.av-animation-delay-container.avia-builder-el-84.el_after_av_tab_sub_section.el_before_av_tab_sub_section.av-active-tab-content > div > div > section > div > h2");
	By asiaLocator = By.cssSelector("#av-tab-section-1 > div > div.av-tab-section-tab-title-container.avia-tab-title-padding-small > a.av-section-tab-title.av-tab-no-icon.av-tab-with-image.noHover.av-active-tab-title > span.av-outer-tab-title > span");
	By asiaLinkLocator = By.linkText("ASIA");
	By textBlockLocator = By.tagName("h3");
	By h3Locator = By.cssSelector("#av-tab-section-1 > div > div.av-tab-section-inner-container.avia-section-default > div.av-layout-tab.av-animation-delay-container.avia-builder-el-108.el_after_av_tab_sub_section.avia-builder-el-last.av-active-tab-content > div > div > div.flex_column.av_one_half.flex_column_div.av-zero-column-padding.first.avia-builder-el-111.el_after_av_hr.el_before_av_one_half > section > div > p");
	
	public FocusPage(String sURL) {
		sUrlPage = sURL;
	}
	//Scroll down to the bottom of the page
	public void scrollDownToBottomPage(){
		base.scrollDown(bodyLocator);
		base.sWait(3);
	}
	//Verification Test
	public String getFooterText() {
		return base.getText(footerLocator);
	}
	//Verify the Now Hiring button exists into this page
	public Boolean verifyBtnExists(String sBtnName) {
		for(WebElement NowHiringBtn : base.findElements(btnLocator)) {
			if(sBtnName.equals(NowHiringBtn.getText())) {
				base.sWait(3);
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
			base.scrollIntoViewIfNeeded(base.findElement(nAmericaLocator));
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
			base.sWait(10);
			return true;
		}
		return false;
	}
	//Validate “El Salvador & Nicaragua” title is displayed on the page
	public boolean validateTitleDisplayedOnPage() {
		if(base.isDisplayed(h2Locator)) {
			base.scrollIntoViewIfNeeded(base.findElement(h2Locator));
			base.sWait(5);
			return true;
		}
		return false;
	}
	//Click on Asia Location
	public Boolean asiaLocation() {
		if (base.isDisplayed(asiaLocator)) {
			base.scrollIntoViewIfNeeded(base.findElement(asiaLocator));
			base.findElement(asiaLinkLocator);
			base.click(asiaLinkLocator);
			base.sWait(5);
			return true;
		}
		return false;
	}
	//Verify if exist the “Bacolod City, Philippines” text block
	public Boolean verifyTextBlockExists() {
		for(WebElement textBlock : base.findElements(textBlockLocator)) {
			if("Bacolod City, Philippines".equals(textBlock.getText())) {
				base.scrollIntoViewIfNeeded(base.findElement(h3Locator));
				base.sWait(10);
				return true;
			}
		}
		return false;
	}
}
