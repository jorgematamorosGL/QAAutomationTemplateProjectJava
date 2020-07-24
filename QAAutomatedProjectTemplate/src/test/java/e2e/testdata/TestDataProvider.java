package e2e.testdata;

import org.testng.annotations.DataProvider;



/**
 * @author Jorge Ivan Matamoros Duran
 * Include all functions to fill test cases with the necesary test data
 */
public class TestDataProvider {

	@DataProvider(name = "DuckDuckGoSearchCriteria")
	public  Object [][] searchCriteriaData(){
		return new Object[][] { /*{ "MGTOW" },*/{ "dark" } };
	}
	
}
