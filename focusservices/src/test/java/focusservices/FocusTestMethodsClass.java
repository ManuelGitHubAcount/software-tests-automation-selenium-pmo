/**
* <h1>Run functional tests automatically!</h1>
* The focusservices program implements an application that
* just run test cases automatically, browse the different 
* web elements on the page and the results of each test 
* are displayed on the screen.
*
* @author  Manuel Reyes
* @version 1.0
* @since   2020-31-08
*/
package focusservices;

//import libraries to use
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

//main class created to start, run and close tests
public class FocusTestMethodsClass {
	public WebDriver driver;
	private String baseUrl;
	private String searchPhrase;
	private String mainUrl;
	private WebElement googleSearch;
	private WebElement searchElement;
	private WebElement btn;
	private String badUrlMessage;
	private String passMessage;
	private String failedMessage;
	public String obtainedTitle;
	//Constructor method used to access the inputs to be used from the FocusRunTestMethodsClass class
	public FocusTestMethodsClass(WebDriver driver,  String baseUrl, String searchPhrase , 
			String mainUrl, String badUrlMessage, String passMessage, String failedMessage){
        this.driver = driver;
        this.baseUrl = baseUrl;
        this.searchPhrase = searchPhrase;
        this.mainUrl = mainUrl;
        this.badUrlMessage = badUrlMessage;
        this.passMessage = passMessage;
        this.failedMessage = failedMessage;
    }
	//TestCase 1 -> Go to www.google.com, 
	//goToGoogleSearch(), method that allows to verify if the current URL is the one of the google page
	public void goToGoogle() throws Exception {
		driver.get(baseUrl); //get the URL we want to go
		if("https://www.google.com/".equals(baseUrl)){ //validate if the URL is correct to proceed with the test
			if("Google".equals(this.driver.getTitle())){ //validate if the title of the current page is equal to the title of the page we are going to test
				System.out.println(passMessage + 1); //Print success message
			}else{
				System.out.println(failedMessage + 1); //Print failed message
			}
		}else{//if the URL is not valid, we cancel the test
			System.out.println(badUrlMessage + 1);
		}
    }
	//TestCase 2 -> Type in Googles search “Focus Services” and Click on “Search button”
	//method that allows to enter "Focus Services" in the input text and search on google, also, click on it
	public void searchFocusServices() throws Exception{
		driver.get(baseUrl); //get the URL we want to go
		if("https://www.google.com/".equals(baseUrl)){ //validate if the URL is correct to proceed with the test
			googleSearch = driver.findElement(By.name("q")); //Web elements to find by name
			btn = driver.findElement(By.name("btnK")); //Web elements to find
			if(googleSearch.isDisplayed()) { //Validate if web element is display
				googleSearch.sendKeys(searchPhrase); //Send phrase to search
				btn.click(); //Click on googleSearch button
			}
			if("Focus Services - Google Search".equals(this.driver.getTitle())
				|| "focus services - Buscar con Google".equals(this.driver.getTitle())
					|| "focus services - Google Search".equals(this.driver.getTitle())) { //Validate if the title of the current page is equal to the title of the page we are going to test
				System.out.println(passMessage + 2); //Print success message
			}else {
				System.out.println(failedMessage + 2); //Print failed message
			}
		}else {//if the URL is not valid, we cancel the test and print a text message
			System.out.println(badUrlMessage + 2); //Print failed message
		}
    }
	//TestCase 3 -> Verify the https://www.focusservices.com URL exists in the search and Click on that page
	//Method used to check if the URL we need exists on the current page
	public void urlExist() throws Exception {
		driver.getCurrentUrl(); //Get the URL we want to go
		if("Focus Services - Google Search".equals(this.driver.getTitle())
				|| "focus services - Buscar con Google".equals(this.driver.getTitle())
					|| "focus services - Google Search".equals(this.driver.getTitle())){ //Validate if the title of the current page is equal to the title of the page we are going to test	
			List<WebElement> allLinks = driver.findElements(By.tagName("a")); //Get a list of URLS on the current page 
			for(WebElement specificlink : allLinks ) { //Loop to parse the list of URLS
				if("https://www.focusservices.com/".equals(specificlink.getAttribute("href"))) { //Validate if current URL is expected
					specificlink.click(); //Click on the current URL
					System.out.println(passMessage + 3); //Print success message
					break; //Stop Loop
				}
				if("null".equals(specificlink.getAttribute("href"))) { //Validate if current URL is null
					System.out.println(failedMessage + 3); //Print failed message
					break; //Stop Loop
				}
			}	
		}else { //if the URL is not valid, we cancel the test and print a text message
			System.out.println(badUrlMessage + 3); //Print failed message
		}
	}
	//TestCase 4 -> Scroll down to the bottom of the page
	//Method used to locate an element and move to where it is displayed
	public void scrollIntoView() throws Exception{
		driver.getCurrentUrl(); //Get the URL we want to go
		if(mainUrl.equals(driver.getCurrentUrl())){ //Validate if the URL is correct to proceed with the test		
			JavascriptExecutor js = (JavascriptExecutor) driver; //Get JavascriptExecutor driver
			searchElement = driver.findElement(By.linkText("Now Hiring!")); //Web element to find by linkText
			js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",searchElement); //Scroll the page till the element is found
			if(searchElement.isDisplayed()) { //Validate if web element is display
				System.out.println(passMessage + 4); //Print success message
			}else {
				System.out.println(failedMessage + 4); //Print failed message
			}
		}else {//if the URL is not valid, we cancel the test and print a text message
			System.out.println(badUrlMessage + 4); //Print failed message
		}
	}
	//TestCase 5 -> Verify the “Now Hiring” button exists into this page
	//Method used to check if the Button element we need exists on the current page
	public void hiringButtonExist() throws Exception{
		driver.getCurrentUrl(); //get the URL we want to go
		if(mainUrl.equals(driver.getCurrentUrl())){//validate if the URL is correct to proceed with the test
			List<WebElement> allButtons = driver.findElements(By.tagName("a")); //Get a list of Buttons on the current page 
			for(WebElement specificbutton : allButtons ) { //Loop to parse the list of Buttons
				if("Now Hiring!".equals(specificbutton.getText())) { //Validate if current Button is expected
					System.out.println(passMessage + 5); //Print success message
					break; //Stop Loop
				}
				if("null".equals(specificbutton.getText())){ //Validate if current list button is null
					System.out.println(failedMessage + 5); //Print failed message
					break; //Stop Loop
				}
			}
		}else { //if the URL is not valid, we cancel the test and print a text message
			System.out.println(badUrlMessage + 5); //Print failed message
		}
	}
	//TestCase 6 -> Click on “Locations” Tab
	//Method used to go to Locations Page
	public void goToLocations() throws Exception{
		driver.getCurrentUrl(); //Get the URL we want to go
		if(mainUrl.equals(driver.getCurrentUrl())){//validate if the URL is correct to proceed with the test
			searchElement = driver.findElement(By.linkText("Locations")); //Web element to find by linkText
			searchElement.click(); //Click on Text Link
			if("Locations – Focus Services".equals(this.driver.getTitle())) { //Validate if the current title is expected
				System.out.println(passMessage + 6); //Print success message
			}else {
				System.out.println(failedMessage + 6); //Print failed message
			}	
		}else { //if the URL is not valid, we cancel the test and print a text message
			System.out.println(badUrlMessage + 6); //Print failed message
		}
	}
	//TestCase 7 -> Locate North America Link. Do an assert on this link
	//Method used to go to Locate North America Link. Do an assert on this link
	public void northAmericaAssert() throws Exception{
		driver.getCurrentUrl(); //get the URL we want to go
		if("https://www.focusservices.com/locations/".equals(driver.getCurrentUrl())){//validate if the URL is correct to proceed with the test
			JavascriptExecutor js = (JavascriptExecutor) driver; //Get JavascriptExecutor driver
			searchElement = driver.findElement(By.linkText("NORTH AMERICA")); //Web element to find by linkText
			js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",searchElement); //Scroll to web element on current page
			String expectedValue = "https://www.focusservices.com/locations/#north-america"; //Expected value
			String actualValue = searchElement.getAttribute("href"); //Actual value
			assertEquals(expectedValue, actualValue); //junit AassertEquals function
			
			if(expectedValue.equals(actualValue)) { //Validate if the expected value and the obtained value are equal
				System.out.println(passMessage + 7); //Print success message			
			}else {
				System.out.println(failedMessage + 7); //Print failed message	
			}
		}else { //if the URL is not valid, we cancel the test and print a text message
			System.out.println(badUrlMessage + 7); //Print failed message
		}
	}
	//TestCase 8 -> Click on Central America location
	//Method used to go to Central America location
	public void centralAmericaLocation() throws Exception {
		driver.getCurrentUrl(); //get the URL we want to go
		if("https://www.focusservices.com/locations/".equals(driver.getCurrentUrl())){ //validate if the URL is correct to proceed with the test
			searchElement = driver.findElement(By.partialLinkText("CENTRAL AMERICA")); //Web element to find by partialLinkText
			searchElement.click(); //Click on the web element link
			if(searchElement.isDisplayed()) { //Validate if web element is displayed
				System.out.println(passMessage + 8); //Print success message			
			}else {
				System.out.println(failedMessage + 8); //Print failed message
			}
		}else { //if the URL is not valid, we cancel the test and print a text message
			System.out.println(badUrlMessage + 8); //Print failed message
		}
	}
	//TestCase 9 -> Validate “El Salvador & Nicaragua” title is displayed on the page
	//Method used to Validate “El Salvador & Nicaragua” title is displayed on the page
	public void displayedOnCentralAmerica() throws Exception{
		driver.getCurrentUrl(); //get the url we want to go
		if("Locations – Focus Services".equals(this.driver.getTitle())){//validate if the URL is correct to proceed with the test			
			//variable used to determine the wait time required to find a web element
			WebDriverWait wait = new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#av-tab-section-1 > div > div.av-tab-section-inner-container.avia-section-default > div.av-layout-tab.av-animation-delay-container.avia-builder-el-84.el_after_av_tab_sub_section.el_before_av_tab_sub_section.av-active-tab-content > div > div > section > div > h2")));
			List<WebElement> h2List = driver.findElements(By.tagName("h2")); //Get h2 web element list on the current page
			for(WebElement checkForH2 : h2List ) { //Loop to parse the list of h2 web element
				if("El Salvador & Nicaragua".equals(checkForH2.getText())) { //Validate if the current title exist on the current page
					System.out.println(passMessage + 9); //Print success message
					break; //Stop Loop
				}
				if ("null".equals(checkForH2.getText())){ //Validate if current list title is null
					System.out.println(failedMessage + 9); //Print failed message
					break; //Stop Loop
				}
			} 
		}else { //if the URL is not valid, we cancel the test and print a text message
			System.out.println(badUrlMessage + 9); //Print failed message
		}
	}
	//TestCase 10 -> Click on Asia Location. 
	//Method used to go to Asia Location.
	public void asiaLocation() throws Exception{
		driver.getCurrentUrl(); //get the url we want to go
		if("https://www.focusservices.com/locations/#central-america".equals(driver.getCurrentUrl())){//validate if the URL is correct to proceed with the test
			searchElement = driver.findElement(By.linkText("ASIA")); // Web element to find by linkText
			searchElement.click(); //Click on the web element link
			if(searchElement.isDisplayed()) { // Validate if the web element is displayed
				System.out.println(passMessage + 10); //Print success message
			}else {
				System.out.println(failedMessage + 10); //Print failed message
			}	
		}else { //if the URL is not valid, we cancel the test and print a text message
			System.out.println(badUrlMessage + 10); //Print failed message
		}
	}
	//TestCase 11 -> Verify if exist the “Bacolod City, Philippines” text block
	//Method used to Verify if exist the “Bacolod City, Philippines” text block
	public void textBlockExistAsiaLocation() throws Exception{
		driver.getCurrentUrl(); //get the url we want to go
		if("https://www.focusservices.com/locations/#asia".equals(driver.getCurrentUrl())){//validate if the URL is correct to proceed with the test
			List<WebElement> blockList = driver.findElements(By.tagName("h3")); //Get text block web element on the current page
			for(WebElement checkForBlock : blockList ) { //Loop to parse the list of text block web elements
				if("Bacolod City, Philippines".equals(checkForBlock.getText())) { //Validate if the current text block expected
					System.out.println(passMessage + 11); //Print success message
					break; //Stop Loop
				}
				if ("null".equals(checkForBlock.getText())){ //Validate if current list button is null
					System.out.println(badUrlMessage + 11); //Print failed message
					break; //Stop Loop
				}
			} 
		}else { //if the URL is not valid, we cancel the test and print a text message
			System.out.println(badUrlMessage + 11); //Print failed message
		}
	}
}
