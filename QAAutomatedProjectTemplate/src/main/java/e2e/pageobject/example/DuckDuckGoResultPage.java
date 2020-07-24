package e2e.pageobject.example;

import e2e.dataobjects.DuckDuckGoResultPageData;
import e2e.utils.WebElementsFactory;


import org.openqa.selenium.WebElement;

import e2e.dataobjects.patterns.NullableElement;
import e2e.utils.ExceptionHandler;
import e2e.utils.Helper;

/**
 * @author Jorge Ivan Matamoros Duran
 * This is an object to represent duckduckgo result site page with all actions
 */
public class DuckDuckGoResultPage {

	/** Page attributes  **/
	private WebElementsFactory webElementFactory;
	
	private DuckDuckGoResultPageData duckDuckGoResultPageData;

	/**
	 * WebDriver loaded by dependency  injection
	 * @param webElementFactory
	 */
	public void setWebElementFactory(WebElementsFactory webElementFactory) {
		this.webElementFactory = webElementFactory;
	}

	
	/**
	 * Object data loaded thought dependency injection 
	 * @param duckDuckGoResultPageData
	 */
	public void setDuckDuckGoResultPageData(DuckDuckGoResultPageData duckDuckGoResultPageData) {
		this.duckDuckGoResultPageData = duckDuckGoResultPageData;
	}
	

	/** ------------------------------ Page Object Actions----------------------------------------***/
	
	
	/**
	 * Verify if "ALL" tab is selected 
	 * @return true if all tab has an underscore , false otherwise
	 */
	public boolean isAllTabSelected() {
		return isTabActive(duckDuckGoResultPageData.getAllLinkSelectorType(), duckDuckGoResultPageData.getAllLinkSelectorValue());
	}
	
	/**
	 * Verify if "ALL" tab is selected 
	 * @return true if all tab has an underscore , false otherwise
	 */
	public boolean isDefinitionTabSelected() {
		return isTabActive(duckDuckGoResultPageData.getDictionarySelectorType(), duckDuckGoResultPageData.getDictionarySelectorValue());
	}
	
	/**
	 * Performs a click on duck duck go browser definition tab
	 */
	public void selectDefinitionTab() {
		WebElement definitionTab = findTab(duckDuckGoResultPageData.getDictionarySelectorType(), duckDuckGoResultPageData.getDictionarySelectorValue());
		definitionTab.click();
	}
	
	/**
	 * 
	 * @return the title from text search criteria
	 */
	public String getDefinitionTitle() {
		String definitionTitle ="";
		
		try {
			WebElement definitionTitleWebElement =  webElementFactory.findVisibleWebElement(webElementFactory.getSelector(duckDuckGoResultPageData.getDefinitionTitleSelectorType(), duckDuckGoResultPageData.getDefinitionTitleSelectorValue()));
			definitionTitle = definitionTitleWebElement.getText();
			
		}catch(Exception e) {
			String errorId = ExceptionHandler.getInstanceHandler().logExecption(this.getClass().getSimpleName(), "getDefinitionTitle", e, duckDuckGoResultPageData.toString());
			definitionTitle = Helper.ERROR_ID_LABEL.concat(errorId);
		}
		
		return definitionTitle;
	}
	
	/**
	 * 
	 * @return the definition content  from  search criteria 
	 */
	public String getDefinitionContent() {
		String definitionTitle ="";
		
		try {
			WebElement definitionTitleWebElement =  webElementFactory.findVisibleWebElement(webElementFactory.getSelector(duckDuckGoResultPageData.getDefinitionResultSelectorType(), duckDuckGoResultPageData.getDefinitionResultSelectorValue()));
			definitionTitle = definitionTitleWebElement.getText();
			
		}catch(Exception e) {
			String errorId = ExceptionHandler.getInstanceHandler().logExecption(this.getClass().getSimpleName(), "getDefinitionContent", e, duckDuckGoResultPageData.toString());
			definitionTitle = Helper.ERROR_ID_LABEL.concat(errorId);
		}
		
		return definitionTitle;
	}
	
	/**
	 * Performs the action of delete the criteria text. 
	 */
	public void removeSearchCriteriaText() {
		try {
			WebElement inputClearIcon =  webElementFactory.findVisibleWebElement(webElementFactory.getSelector(duckDuckGoResultPageData.getInputClearTextSelectorType(), duckDuckGoResultPageData.getInputClearTextSelectorValue()));
			inputClearIcon.click();
			
		}catch(Exception e) {
			String errorId = ExceptionHandler.getInstanceHandler().logExecption(this.getClass().getSimpleName(), "removeSearchCriteriaText", e, duckDuckGoResultPageData.toString());
			
			ExceptionHandler.getInstanceHandler().logUnexpectedAction("Inut clear text could not be found or does not perform its action, filled with an empty weblElement instead. Check log for error id: "+errorId);
		}
	}
	
	public void clickOnMagnifyingGlassIcon() {
		try {
			WebElement inputClearIcon =  webElementFactory.findVisibleWebElement(webElementFactory.getSelector(duckDuckGoResultPageData.getInputSearchButtonSelectorType(), duckDuckGoResultPageData.getInputSearchButtonSelectorValue()));
			inputClearIcon.click();
			
		}catch(Exception e) {
			String errorId = ExceptionHandler.getInstanceHandler().logExecption(this.getClass().getSimpleName(), "clickOnMagnifyingGlassIcon", e, duckDuckGoResultPageData.toString());
			
			ExceptionHandler.getInstanceHandler().logUnexpectedAction("MagnifyingGlass icon could not be found or does not perform its action, filled with an empty weblElement instead. Check log for error id: "+errorId);
		}
	}
	/** ------------------------------ Page Object Auxiliary Actions----------------------------------------***/
	
	
	/**
	 * 
	 * @param selectoyType
	 * @param selectorValue
	 * @return
	 */
	private Boolean isTabActive(String selectoyType,String selectorValue) {
		WebElement selectedTab =findTab(selectoyType,selectorValue);
		
		if(selectedTab.getAttribute("class").contains("is-active")) {
		  return true;	
		}else {
			return false;
		}
	}
	
	
	/**
	 * Returns the current selected tab 
	 * @param selectoyType CSS,Tag,Id ,xpath etc
	 * @param selectorValue the selector to perform the element search
	 * @return
	 */
	private WebElement findTab(String selectoyType,String selectorValue) {
		
		WebElement tabtoFind = null;
		try {
			tabtoFind =  webElementFactory.findVisibleWebElement(webElementFactory.getSelector(selectoyType, selectorValue));
		}catch(Exception e) {
			String errorId = ExceptionHandler.getInstanceHandler().logExecption(this.getClass().getSimpleName(), "findTab", e, "[selector type="+ selectoyType+", selector value="+selectorValue+"]");
			tabtoFind =new NullableElement();
			tabtoFind.sendKeys(Helper.ERROR_ID_LABEL.concat(errorId));
		}
		
		return tabtoFind;
	}

	
	
}
