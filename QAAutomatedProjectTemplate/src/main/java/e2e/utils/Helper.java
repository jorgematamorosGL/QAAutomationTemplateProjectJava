package e2e.utils;

import org.testng.asserts.SoftAssert;

/**
 * @author Admin
 * Contains properties for other components 
 */
public  class Helper {

  public static String ERROR_ID_LABEL ="ErrorId";
  
  /**
 * Intance to perfom verifys 
 */
public static SoftAssert softAssertInstance() {
	return new  SoftAssert();
}
  
}
