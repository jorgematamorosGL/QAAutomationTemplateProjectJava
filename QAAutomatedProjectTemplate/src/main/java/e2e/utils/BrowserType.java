package e2e.utils;

/**
 * enum for handling brosers versions in an efficient and nice way
 * @author Jorge Ivan Matamoros Duran
 *
 */
public enum BrowserType {

	CHROME("chrome"),
	FIREFOX("fireFox"),
	EDGE("edge");
	
	private String browserName;
	
	BrowserType(String browserName){
		this.browserName = browserName;
	}
	
	public String getBrowserName() {
		return this.browserName;
	}
}
