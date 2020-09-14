# Automatic Functional Tests ->Focus Services 
_The focusservices program implements an application that runs functional tests automatically,
Navigating through the different components of the web page, allows you to view each component found
and the action executed in it, additionally the program validates internally if the component was located successfully, 
if it exists or does not exist. For any 'success' or 'failure' result, the program prints the results for each test case
to the console_

### Starting 🚀
_These instructions will allow you to get a copy of the project running on your local machine for testing purposes._

### Pre-requisites 📋
* _Focus Services Project Version: 1.0 (https://github.com/ManuelGitHubAcount/software-test-automation/)_.
* _Eclipse IDE Version: 2020-06 (https://www.eclipse.org/downloads/)_.
* _JDK Version: 1.8.0 (https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)_.
* _Junit Version: 5.4.0 (https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter/5.4.0)_.
* _Selenium Server Version: 3.141.59 (https://www.selenium.dev/downloads/)_.
* _ChromeDriver Version: 85.0.4183.87 (https://chromedriver.chromium.org/downloads)_.
* _Google Chrome Version 85.0.4183.83 (https://www.google.com.mx/chrome/)_.

### Installation 🔧
_To begin the installation process, first download the list of tools described in the prerequisites part. Then follow each of the following steps._
* **Step 1: Install JDK**. _And create JAVA_HOME environment variable and add the file PATH._
```
JAVA_HOME: C:\Program Files\Java\jdk1.8.0_151.
PATH: C:\Program Files\Java\jdk1.8.0_151\bin.
```
* **Step 2: Install Eclipse IDE for Java Developers**.
_When the installation is complete, access the Eclipse IDE Environment and open the Focus Services Project_
```
File -> Open projects from File System or Archive -> Import Source -> Directory -> Select focusservices project -> Finish.
Go to Projects -> Clean, then select the Build Project option.

To finish the process, if your project has errors, please go to...
Click on Project -> Maven -> Update Projects, this will allow you to build the project successfully.
```
* **Step 3: Install Google Chrome**.
_It is extremely necessary to install the indicated version or a higher version, otherwise the google chrome driver will not run successfully_.

* **Step 4: Install Junit, Selenium Server and ChromeDriver**.
_For these Junit, Selenium Server and ChromeDriver tools, it is not necessary to install or configure them, because they are already attached to the project_.

### Running the tests ⚙️
_To run the project and validate the test cases, do the following._
```
Go to Eclipse IDE and,
In the project, browse the project folders until you find FocusRunTestMethodsClass.class.
Path: focusservices -> src/test/java -> focusservices.tests -> ...
Then, just Right click on the Test Case -> Run As -> Junit Test.
The application will start to execute each of the test cases. Regardless of the results, you will get a message on the console.
```
**_Tests Script:_** _The script should be having the following things._
```
  Case 1 => Open Chrome Browser
  Case 2 => Go to www.google.com
  Case 3 => Type in Google’s search “Focus Services”
  Case 4 => Click on “Search button”
  Case 5 => Verify the https://www.focusservices.com URL exists in the search
  Case 6 => Click on that page
  Case 7 => Scroll down to the bottom of the page
  Case 8 => Verify the “Now Hiring” button exists into this page
  Case 9 => Click on “Locations” Tab
  Case 10 => Locate North America Link. Do an assert on this link
  Case 11 => Click on Central America location
  Case 12 => Validate “El Salvador & Nicaragua” title is displayed on the page
  Case 13 => Click on Asia Location. Verify if exist the “Bacolod City, Philippines” text block
 ```
 **_Running the Test Cases:_** _To validate each of the cases, run the test cases in the following order.._
 ```
CASE 1 and CASE 2
TestCase name: => GoToGoogle_Test.java

CASE 3 and CASE 4
TestCase name: => TypeInGoogleSearch_Test.java

CASE 5 and CASE 6
TestCase name: => VerifyTheURLExists_Test.java

CASE 7
TestCase NAME: => ScrollDownToBottomPage_Test.java

CASE 8
TestCase name: => verifyNowHiringBtnExists_Test.java

CASE 9
TestCase name: => ClickOnLocationsTab_Test.java

CASE 10
TestCase name: => LocateNorthAmericaLink_Test.java

CASE 11
TestCase name: => ClickOnCentralAmericalocation_Test.java

CASE 12
TestCase name: => ValidateElSalNicTitleIsDisplayed_Test.java

CASE 13
TestCase name: => ClickonAsiaLocation_Test.java
TestCase name: => VerifyBacoCityPhilippinesTextBlockExist_Test.java
```
### Built with 🛠️
_Working on it..._

### Authors ✒️
* **Manuel Reyes**

### License 📄
_Working on it..._
....

_Sincerely, Manuel Reyes_.
_Good luck_.
