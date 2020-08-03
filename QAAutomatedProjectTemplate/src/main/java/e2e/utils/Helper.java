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


/**
 * Checks if an string does not contains any character
 * @param stringToEvaluate
 * @return
 */
public static boolean isEmptyString(String stringToEvaluate) {
	if(null == stringToEvaluate || stringToEvaluate.isBlank() || stringToEvaluate.isEmpty()) {
		return true;
	}else {
		return false;
	}
}
  
}
