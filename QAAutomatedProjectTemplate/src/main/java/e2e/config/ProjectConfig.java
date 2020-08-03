package e2e.config;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import e2e.utils.*;

public class ProjectConfig implements ISuiteListener  {

	
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		try {
			 ExceptionHandler.getInstanceHandler().logInfo("suite name "+suite.getName() );
			// ITestContext testContext = suite.get;
	
		}catch(Exception e) {
			StringBuilder parametersArg = new StringBuilder("");
			parametersArg.append("dataOption"+suite.getParameter("dataOption")).append("selectedBrowser"+suite.getParameter("selectedBrowser"));
			
			String errorId = ExceptionHandler.getInstanceHandler().logExecption(ProjectConfig.class.getName(), "onStart", e, parametersArg.toString());
			ExceptionHandler.getInstanceHandler().logUnexpectedAction("Error during config starup: Check id:"+errorId);
			
		}
	    
	
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub

	}

}
