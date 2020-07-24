package e2e.pageobject.example;

//import org.junit.Assert;

import org.openqa.selenium.WebElement;

import e2e.dataobjects.DuckDuckGoData;
import e2e.dataobjects.patterns.NullableElement;
import e2e.utils.ExceptionHandler;
import e2e.utils.Helper;
import e2e.utils.WebElementsFactory;


/**
 * @author Jorge Ivan Matamoros Duran
 * This is a example page object using Duckduckgo page 
 */
public class DuckDuckGo {

	
	/** Page attributes  **/
	private WebElement inputBar;
	
	
	private WebElement inputSearchButton;
	
	private WebElementsFactory webElementFactory;
	
	private DuckDuckGoData data;
	
	
	public void setWebElementsFactory(WebElementsFactory webElementFactory) {
		this.webElementFactory = webElementFactory;
	}
	
	public void SetDuckDuckGoData(DuckDuckGoData testData) {
		data = testData;
	}
	
	/** Page actions  **/
	
	
	
	public Boolean loadPage() {
		String duckWebsite = data.getUrl();
		webElementFactory.goToUrl(duckWebsite);
		boolean pageIsLoaded = webElementFactory.waitForPageIsLoaded(duckWebsite);
		
		return pageIsLoaded;
	}
	
	public void setQueryCriteria(String searchCriteria) {
		
		try {
		  inputBar = webElementFactory.findVisibleWebElement(webElementFactory.getSelector(data.getInputSelectorType(), data.getInputSelector()));
		  inputBar.sendKeys(searchCriteria);

		  if(null == inputBar.getAttribute("value") || inputBar.getAttribute("value").isEmpty()) {
				ExceptionHandler.getInstanceHandler().logUnexpectedAction("Input bar could not be filled with search criteria \n search criteria: "+searchCriteria + " \n search data "+data.getInputSelectorType()+" "+data.getInputSelector() );
		  }
		}catch(Exception e) {
			String errorId = ExceptionHandler.getInstanceHandler().logExecption(this.getClass().getSimpleName(), "setQueryCriteria", e, data.toString());
			inputBar = new NullableElement();
			inputBar.sendKeys(Helper.ERROR_ID_LABEL.concat(errorId));
		}
		
	}
	
	public void searchCriteria() {
		try {
		    inputSearchButton =  webElementFactory.findVisibleWebElement(webElementFactory.getSelector(data.getSearchButtonSelectorType(), data.getSearchButtonSelector()));
		}catch(Exception e) {
			String errorId = ExceptionHandler.getInstanceHandler().logExecption(this.getClass().getSimpleName(), "searchCriteria", e, data.toString());
			inputSearchButton = new NullableElement();
			inputSearchButton.sendKeys(errorId);
			ExceptionHandler.getInstanceHandler().logUnexpectedAction("search button could not be found, filed with an empty weblelemtn instead. Check log for error id: "+errorId);
			
		}
		
		inputSearchButton.click();
	}
	
	public String validateSearchCriteriaBarIsVisible() {
		WebElement resultBox = null;
		try {
		 resultBox =   webElementFactory.findVisibleWebElement(webElementFactory.getSelector(data.getResultBoxSelectorType(), data.getResultBoxSelector()));
		}catch(Exception e) {
			String errorId = ExceptionHandler.getInstanceHandler().logExecption(this.getClass().getSimpleName(), "validateSearchCriteriaBarIsVisible", e, data.toString());
			resultBox = new NullableElement();
			resultBox.sendKeys(Helper.ERROR_ID_LABEL.concat(errorId));
			
		}
		
		
		return resultBox.getText();
		
	}
	
}
