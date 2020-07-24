package e2e.utils;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.windows.WindowsDriver;

/**
 * @author Jorge Ivan Matamoros
 * Class that contains the required functions to find web elements  
 */
public class WebElementsFactory {







	private WebDriver driver;
	private WebDriverWait driverWait;


	public WebElementsFactory(WebDriver driverP) {
		this.driver = driverP;
		this.driverWait = new WebDriverWait(driver, 30);
	}

	/**
	 * Indicates the driver which page or site should go
	 * @param url
	 */
	public void goToUrl(String url) {
		driver.get(url);
	}
	
	/**
	 * Return any visible and singular element by waiting until this element is visible
	 * @param by the selector used, could be css, xpath, id , class etc
	 * @return the web element or any exception in case of error
	 */
	public WebElement findVisibleWebElement(By by) { 
		return driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	/**
	 * Return a interative web element
	 * @param by
	 * @return
	 */
	public WebElement findElement(By by) {
		return driver.findElement(by);
	}
	
	/**
	 * Returns all elements by waiting until each one  is visible
	 * @param by the selector used, could be css, xpath, id , class etc
	 * @return the list of web elements or any exception in case of error
	 */
	public List<WebElement> findVisibleWebElements(By by) { 
		
		return driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

	}
	
	/**
	 * Return any visible and singular element by waiting until this element can be clickable 
	 * @param by the selector used, could be css, xpath, id , class etc
	 * @return 
	 */
	public WebElement findClickleableWebElement(By by) { 
		return driverWait.until(ExpectedConditions.elementToBeClickable(by));

	}

	/**
	 * Switch to frame using frame locator
	 * @param by  the selector used, could be css, xpath, id , class etc
	 */
	public void switchToVisibleFrame(By by) {
		 this.driver = driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
	}
	
	
	/**
	 * Switch to frame using frame position
	 * @param frame position
	 */
	public void switchToVisibleFrame(int pos) {
		 this.driver = driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(pos));
	}
	
	
	/**--------------------------------Alert event handling -------------------------------------------------**/
	
	
	public void aceptAlert() {
		this.driver.switchTo().alert().accept();
	}
	
	public void dismisAlert() {
		this.driver.switchTo().alert().dismiss();
	}
	
	public void setAlertText(String alertText) {
		this.driver.switchTo().alert().sendKeys(alertText);
	}
	
	
	public String getAlertText() {
		return this.driver.switchTo().alert().getText();
	}
	
	/**
	 * Wait until the expected page is loaded
	 * @param pageUrl to 
	 * @return true if the page was loaded, false otherwise or any expection
	 */
	public Boolean waitForPageIsLoaded(String pageUrl) {
		return driverWait.until(ExpectedConditions.urlToBe(pageUrl));
	}
	
	
	/**
	 * Gets any select to interact with it 
	 * @param selectorValue:  selector in which the element should be located (id , class, tag name etc)
	 * @param selectorType  : Type of selector to be used to located the element: CSS,XPAHT,EXC
	 * @return: Select Element or any exception in case of failure that must be handled on higher layers
	 */
	public Select getSelectDropDownElement( String selectorValue, String selectorType){
		
		return  new Select(driverWait.until(ExpectedConditions.elementToBeClickable((getSelector(selectorValue, selectorType)))));

	}
	
	/**
	 * @param selector
	 * @param selectorValue
	 * @return
	 */
	public By getSelector(String selector,String selectorValue) {
		By BySelector = null;

		switch(selector.toUpperCase()) {
			case "CSS":
			  BySelector =  By.cssSelector(selectorValue);
			break;

			case "XPATH":
				 BySelector =  By.xpath(selectorValue);
				break;
			case "ID":
				BySelector =  By.id(selectorValue);
			break;	
			case  "NAME":
				BySelector =  By.name(selectorValue);
				break;
			case "CLASS":
				BySelector =  By.className(selectorValue);
				break;
			default:
				BySelector =  By.id(selectorValue);
			break;	
		}


		return BySelector;
	}
	
	
	public void finish() {
		driverWait = null;
		driver.quit();
		driver = null;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((driver == null) ? 0 : driver.hashCode());
		result = prime * result + ((driverWait == null) ? 0 : driverWait.hashCode());
		return result;
	}
	
	

}
