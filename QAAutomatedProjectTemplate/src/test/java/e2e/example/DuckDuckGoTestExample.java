package e2e.example;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
/*
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;*/
//import org.junit.Test;
import org.testng.annotations.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;


import e2e.config.SetUp;
import e2e.config.WebDriverFactory;
import e2e.pageobject.example.DuckDuckGo;
import e2e.pageobject.example.DuckDuckGoResultPage;
import e2e.testdata.TestDataProvider;
import e2e.utils.BrowserType;
import e2e.utils.ExceptionHandler;
import e2e.utils.Helper;
import e2e.utils.WebElementsFactory;

public class DuckDuckGoTestExample {

	private  DuckDuckGo pageObject;
	private DuckDuckGoResultPage pageObjectResult;
	
	private  WebElementsFactory webElementFactory;
	
	@BeforeTest
	 public  void beforeTest(ITestContext testContext) throws FileNotFoundException {
		String dataEnviroment =testContext.getCurrentXmlTest().getParameter("dataEnviroment");
		String browserType =testContext.getCurrentXmlTest().getParameter("browser"); 
		
		dataEnviroment = dataEnviroment!=null?dataEnviroment:"QA";
		browserType = browserType!=null?browserType:"Chrome";
		
	 BrowserType bType =	BrowserType.valueOf(browserType.toUpperCase());
	 
	
	    ExceptionHandler.getInstanceHandler().logInfo("browser for test"+ bType.getBrowserName());
		SetUp.getSetUpInstance().loadTestData(dataEnviroment);
		
		pageObject = new DuckDuckGo();
		pageObjectResult = new DuckDuckGoResultPage();
		pageObject.SetDuckDuckGoData(SetUp.duckDuckGoData);
		pageObjectResult.setDuckDuckGoResultPageData(SetUp.duckDuckGoResultData);
		List<String> browserOptions = new ArrayList<String>();
		browserOptions.add("--start-maximized");
		System.out.print("Version del driver en la clase "+WebDriverFactory.getDriverFactoryIntance().getDriversMapVersion().get(BrowserType.EDGE.getBrowserName()));
	//	webElementFactory = new WebElementsFactory(WebDriverFactory.getDriverFactoryIntance().getCrhomeDriver(browserOptions) );
		webElementFactory =  new WebElementsFactory(WebDriverFactory.getDriverFactoryIntance().getDriver(null,bType));
		pageObject.setWebElementsFactory(webElementFactory);
		pageObjectResult.setWebElementFactory(webElementFactory);
	}
	

	@Test(/*dependsOnMethods= {"browserIsAvaiable"},*/dataProvider = "DuckDuckGoSearchCriteria", dataProviderClass = TestDataProvider.class)
	public void browser_Should_Display_SearchCriteria_Description_Box(String searchCriteria) {
		
		//Arrange
		String queryData = searchCriteria;
		Assert.assertTrue(pageObject.loadPage());
		pageObject.setQueryCriteria(queryData);
		
		//Action
		pageObject.searchCriteria();
		
		//Assert
		String resultBoxResult =  pageObject.validateSearchCriteriaBarIsVisible();
		
		Assert.assertEquals(resultBoxResult.toUpperCase(), queryData.toUpperCase());
	}
	
	
	@Test(dependsOnMethods= {"browser_Should_Display_SearchCriteria_Description_Box"})
	public void all_Tab_Is_selected_By_Default() {
		//Arrange
		boolean allTabIsSelectedByDefault=false;
		
		//Action
		allTabIsSelectedByDefault =pageObjectResult.isAllTabSelected();
		
		//Assert 
		Assert.assertTrue(allTabIsSelectedByDefault);
	}
	
	@Test(dependsOnMethods={"all_Tab_Is_selected_By_Default"})
	public void  all_Tab_Is_Not_Selected_When_User_Clicks_On_Other_Tabs() {
		//Arrange
				boolean allTabIsSelectedByDefault=true;
				//Action
				pageObjectResult.selectDefinitionTab();
				allTabIsSelectedByDefault =pageObjectResult.isAllTabSelected();
				
				//Assert 
				Assert.assertFalse(allTabIsSelectedByDefault);	
	}
	
	@Test(dependsOnMethods={"all_Tab_Is_selected_By_Default"},dataProvider = "DuckDuckGoSearchCriteria", dataProviderClass = TestDataProvider.class)
	public void  definiton_tab_displays_criteria_search_definition(String searchCriteria) {
		//Arrange
				String definitionTitle = "";
				String definitionText = "";
				
				
				//Action
				pageObjectResult.selectDefinitionTab();
				
				//Verify
			     Helper.softAssertInstance().assertTrue(pageObjectResult.isDefinitionTabSelected()," Definiton tab is not selected");
				//Assert.assertTrue(pageObjectResult.isDefinitionTabSelected());
				definitionTitle = pageObjectResult.getDefinitionTitle();
				definitionText =pageObjectResult.getDefinitionTitle();
				
				//Assert 
			
				Assert.assertEquals(definitionTitle.toUpperCase(), searchCriteria.toUpperCase());
				Assert.assertNotNull(definitionText);
				
	}
	
 
	
	@AfterTest
	 public void afterTest() {
		webElementFactory.finish();
	}
}
