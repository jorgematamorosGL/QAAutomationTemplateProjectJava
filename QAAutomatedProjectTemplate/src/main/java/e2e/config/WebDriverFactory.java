package e2e.config;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import e2e.utils.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Returns specific driver dependign on the choice
 * @author Admin
 *
 */
public class WebDriverFactory {

	private static WebDriverFactory webdriverFactory;

	private Map<String,String> driversMapVersion;
	
	

	
	private WebDriverFactory() {
		driversMapVersion = new HashMap<String,String>();
	}

	public static WebDriverFactory getDriverFactoryIntance() {
		if (null == webdriverFactory) {
			webdriverFactory = new WebDriverFactory();
		}
		return webdriverFactory;
	}


	public WebDriver getDriver(List<String> browserOptions,BrowserType browserType) {
		WebDriver webdriver = null;
          String driverVer = this.driversMapVersion.get(browserType.getBrowserName());
		  switch(browserType) {
			case CHROME :
				
				/*
				 * options.addArguments("start-maximized"); 
		options.addArguments("enable-automation"); 
		options.addArguments("--no-sandbox"); 
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation"); 
		options.addArguments("--disable-gpu");
				 * 
				 * */
			
				WebDriverManager.chromedriver().driverVersion(driverVer).setup();
				  webdriver = loadDriverWithOptions(browserOptions,webdriver,browserType);
				webdriver = webdriver!=null?webdriver: new ChromeDriver();
				break;
			case FIREFOX:
				WebDriverManager.firefoxdriver().driverVersion(driverVer).setup();
				  webdriver = loadDriverWithOptions(browserOptions,webdriver,browserType);
				  webdriver = webdriver!=null?webdriver: new FirefoxDriver();
				break;
			case EDGE:
				WebDriverManager.edgedriver().driverVersion(driverVer).setup();
				webdriver = new EdgeDriver();
			    break;
			
		 }
		  
		  //ReIniatiate driver with options in case there is any 
		
	  
		return webdriver;
	}


	private WebDriver loadDriverWithOptions(List<String> browserOptions,WebDriver driver,BrowserType browserType){
          	
		if(browserOptions != null && !browserOptions.isEmpty()) {
		  switch(browserType) {
			case CHROME:
				 ChromeOptions  chromeCapabilities = new ChromeOptions();
				   chromeCapabilities.addArguments(browserOptions);
				   driver = new ChromeDriver(chromeCapabilities);
				break;
			case FIREFOX:
				FirefoxOptions fireFoxOptions = new FirefoxOptions();
				driver = new FirefoxDriver(fireFoxOptions);
				break;
			default:
				break;
		 }
		}  
		  
		
       return driver;
	}


	public Map<String, String> getDriversMapVersion() {
		return driversMapVersion;
	}

	public void setDriversMapVersion(Map<String, Object> propertiesMap) {
		this.driversMapVersion =  (HashMap<String,String>) propertiesMap.get("webdriverVersion");
	}

}
