package focusservices.tools;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automationtools {
	protected WebDriver driver;
	protected String sBrowserName;
	protected WebElement element;
	
	public Automationtools() {
		driver = null;
		sBrowserName = null;
		element = null;
	}
	
	public Boolean openBrowser(String sBrowserType) {
		if(sBrowserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","./src/test/resources/chrome/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		return true;
	}
	
	public Boolean gotoPage(String sURLSite) {
		driver.get(sURLSite);
		return true;
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	
	public String getValueAttribute(By locator) {
		return driver.findElement(locator).getAttribute("value");
	}
	
	public String getHrefAttribute(By locator) {
		return driver.findElement(locator).getAttribute("href");
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
		
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public String getTitle(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public void sendKey(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText+Keys.ENTER);
	}
	
	public void scrollDown(By locator) {
		driver.findElement(locator).sendKeys(Keys.CONTROL, Keys.END);
	}
	
	public void sWait(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void iWait() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void scrollIntoViewClick(WebElement element) { 
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", element);
        js.executeScript("arguments[0].click();", element);
    }
	
	public void scrollIntoView(WebElement element) { 
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
	
	public void scrollIntoViewIfNeeded(WebElement element) { 
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", element);
    }
}
