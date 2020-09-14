package focusservices.site;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class SiteResources {
	public String sBrowserName;
	public String sURLSite;
	public String sMainUrl;
	public String sPhrase;
	public String sBtnName;
	public String sExpectedUrl;
	public Properties prop;
	
	public SiteResources() {
		try {
			prop = new Properties();
			FileInputStream fis = new  FileInputStream("./src/main/java/focusservices/config/config.properties");
			prop.load(fis);
			sBrowserName = prop.getProperty("browser");
			sURLSite = prop.getProperty("url");
			sPhrase = prop.getProperty("phrase");
			sMainUrl = prop.getProperty("mainurl");
			sBtnName = prop.getProperty("btname");
			sExpectedUrl = prop.getProperty("expectedurl");
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String getBrowserName() {
		return sBrowserName;
	}
	
	public String getURLSite() {
		return sURLSite;
	}
	
	public String getPhrase() {
		return sPhrase;
	}
	
	public String getMainUrl() {
		return sMainUrl;
	}
	
	public String getBtname() {
		return sBtnName;
	}
	
	public String getExpectedUrl() {
		return sExpectedUrl;
	}
}
