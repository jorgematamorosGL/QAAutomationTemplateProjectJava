package e2e.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * It will handles all exceptions
 * @author Admin
 *
 */
public class ExceptionHandler {

	
	private String layer = "Layer:";
	private String action = "Action";
	private String functionsArgs="Action Arguments";
	
	
	
	private static ExceptionHandler handler;
	  private  final Logger logger 
      = LoggerFactory.getLogger("qa.file.appender");
	
	  private final Logger consoleLogger = LoggerFactory.getLogger("qa.console.appender");
	  
	  private final Logger infoAppender = LoggerFactory.getLogger("qa.info.appender");
	
	  private ExceptionHandler() {
		  
	  }
	  
	  public static ExceptionHandler getInstanceHandler() {
		  if (null == handler) {
			  handler = new ExceptionHandler();
		  } return handler;
	  }
	
	/**
	 * irts records any exception during an action
	 * @param pageObjectName
	 * @param pageAction
	 * @param e
	 * @param pageObjectArgs
	 * @return
	 */
	public String logExecption(String pageObjectName, String pageAction,Exception e,String pageObjectArgs ) {
		String exceptionId = UUID.randomUUID().toString();
		
		String errorMsg = "Exception id: ".concat(exceptionId).concat("\n ErrorData{ ")
				.concat(layer.concat(": "+pageObjectName+"\n"))
		        .concat(action.concat(": "+pageAction+"\n"))
		.concat(functionsArgs.concat(": "+pageObjectArgs+"\n"));
		
		logger.error(" An unexpected error occured during test: {}", errorMsg,e);
		
		return exceptionId;
	}
	
	
	/**
	 * Records a warning  when an unexpected behavior happens
	 * @param actionDescription
	 */
	public void logUnexpectedAction(String actionDescription) {
		consoleLogger.warn(actionDescription);
		infoAppender.warn(actionDescription);
	}
	
	public void logInfo(String info) {
		infoAppender.info(info);
	}
	
}
