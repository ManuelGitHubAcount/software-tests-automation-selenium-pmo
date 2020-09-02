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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class FocusRunTestMethodsClass {
	private WebDriver driver; //Webdriver object
	private String baseUrl = "https://www.google.com/"; //Variable that stores the URL that will be loaded in the first instance
	private String searchPhrase = "Focus Services"; //Variable used to enter the keywords to search in google
	private String mainUrl = "https://www.focusservices.com/"; //Variable that stores the main URL of the web system to test
	private String badUrlMessage = "Status 'FAILED', description: The current url is not the expected one to run the 'Test Case' "; //Variable that stores a message that indicates whether the URL to be loaded in the first instance is correct
	private String passMessage = " Status 'PASS', description: Test Case "; //Variable that stores a message that indicates whether the test case was executed successfully
	private String failedMessage = " Status 'FAILED', description: Test Case "; //Variable that stores a message that indicates if the executed test case failed
	FocusTestMethodsClass TestMethod; //Constructor instance of the FocusTestMethodsClass class

	@Before //Junit annotation
	//Main method used to configure and start google driver
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chrome-driver/chromedriver.exe"); //Place where the google chrome driver is hosted and is executed by the WebDriver
		driver = new ChromeDriver(); //start chrome driver
		driver.manage().window().maximize(); //maximize browser	  
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Wait 10 seconds every google driver starts
		TestMethod = new FocusTestMethodsClass(driver, baseUrl, searchPhrase, mainUrl, badUrlMessage, passMessage, failedMessage); //Variable of Constructor instance of the FocusTestMethodsClass class
	}
	@Test //Junit annotation
	//Main method used to run the test cases
	public void FunctionalTestRunner() throws Exception{
		TestMethod.goToGoogle(); //Test case method, description: Go to www.google.com
		TestMethod.searchFocusServices(); //Test case method, description: Type in Google’s search “Focus Services” and Click on “Search button”
		TestMethod.urlExist(); //Test case method, description: Verify the https://www.focusservices.com URL exists in the search and Click on that page
		TestMethod.scrollIntoView(); //Test case method, description: Scroll down to the bottom of the page
		TestMethod.hiringButtonExist(); //Test case method, description: Verify the “Now Hiring” button exists into this page
		TestMethod.goToLocations(); //Test case method, description: Click on “Locations” Tab
		TestMethod.northAmericaAssert(); //Test case method, description: Locate North America Link. Do an assert on this link
		TestMethod.centralAmericaLocation(); //Test case method, description: Click on Central America location
		TestMethod.displayedOnCentralAmerica(); //Test case method, description: Validate “El Salvador & Nicaragua” title is displayed on the page
		TestMethod.asiaLocation(); //Test case method, description: Click on Asia Location.
		TestMethod.textBlockExistAsiaLocation(); //Test case method, description: Verify if exist the “Bacolod City, Philippines” text block
	}
	@After //Method used to stop the execution of the tests, close the session of google driver and close the browser
	public void stopTestRunner() throws Exception{
		driver.quit();
	}
}
