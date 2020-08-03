package e2e.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

import org.testng.ISuiteListener;
import org.yaml.snakeyaml.Yaml;

import e2e.dataobjects.DuckDuckGoData;
import e2e.dataobjects.DuckDuckGoEnv;
import e2e.dataobjects.DuckDuckGoResultPageData;
import e2e.dataobjects.DuckDuckGoResultPageEnv;

/**
 * @author Admin
 * Prepares the necesary configuration for the tests
 */
public class SetUp {

	public static DuckDuckGoEnv duckDuckGoObjEnviroment;
	public static DuckDuckGoData duckDuckGoData;
	
	public static DuckDuckGoResultPageEnv duckDuckGoObjResultEnviroment;
	public static DuckDuckGoResultPageData duckDuckGoResultData;
	private static SetUp setup;
	
	private SetUp() {
		
	}
	
	public static SetUp getSetUpInstance() {
		if (null == setup) {
			setup = new SetUp();
		}
		
		return setup;
	}
	public  void loadTestData(String op) throws FileNotFoundException {
		Map<String,Object> propertiesMap = null;
		Yaml yaml = null;
		Reader reader = null;
		File resourceFile = null;
		
		if(duckDuckGoObjEnviroment == null) {
			 yaml = new Yaml();
		     duckDuckGoObjEnviroment = new DuckDuckGoEnv();
				String filePath = new File("src/main/resources/pageobject/").getAbsolutePath();
			    resourceFile = new File(filePath.concat("/duckduckgo.yaml"));
				reader = new FileReader(resourceFile);
				duckDuckGoObjEnviroment = yaml.loadAs(reader, DuckDuckGoEnv.class);
				
				 resourceFile = new File(filePath.concat("/DuckDuckgoResultPage.yaml"));
				 reader = new FileReader(resourceFile);
				 duckDuckGoObjResultEnviroment =   yaml.loadAs(reader, DuckDuckGoResultPageEnv.class);
				 
				
		//	enviroment = yaml.loadAs(in, DuckDuckGoEnv.class);
			
			switch(op.toUpperCase()) {
				case "QA":
					duckDuckGoData = duckDuckGoObjEnviroment.getQA();
					duckDuckGoResultData = duckDuckGoObjResultEnviroment.getQA();
					break;
				case "DEV":
					duckDuckGoData = duckDuckGoObjEnviroment.getDEV();
					duckDuckGoResultData = duckDuckGoObjResultEnviroment.getDEV();
				default:
					duckDuckGoData = duckDuckGoObjEnviroment.getQA();
					duckDuckGoResultData = duckDuckGoObjResultEnviroment.getQA();
					break;
			}	
		}
		
	}
	
	
	public void setUpTestConfigurations() throws FileNotFoundException {
		String filePath = new File("src/main/resources/pageobject/").getAbsolutePath();
		Reader reader = null;
		File resourceFile = null;
		Yaml yaml = null;
		Map<String,Object> propertiesMap = null;
		
		//Load properties 
		filePath = new File("src/main/resources/projectproperties.yaml").getAbsolutePath();
		  resourceFile = new File(filePath.concat("/duckduckgo.yaml"));
		  
		resourceFile = new File(filePath);
	
		reader = new FileReader(resourceFile);
		propertiesMap = (Map<String, Object>) yaml.load(reader);

		//Load properties 
		filePath = new File("src/main/resources/projectproperties.yaml").getAbsolutePath();
	
		resourceFile = new File(filePath);
	
		reader = new FileReader(resourceFile);
		propertiesMap = (Map<String, Object>) yaml.load(reader);

		WebDriverFactory.getDriverFactoryIntance().setDriversMapVersion(propertiesMap);
	}
	
}
