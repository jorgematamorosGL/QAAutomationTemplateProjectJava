package e2e.dataobjects;

/**
 * @author Jorge Ivan Matamoros Duran
 *Pojo file with the purpose to store all data related to page object manipulation (selectors, selectors types etc)
 */
public class DuckDuckGoData {

	private String inputSelector;
	private String inputSelectorType;
	private String searchButtonSelector;
	private String searchButtonSelectorType;
	private String url;
	private String resultBoxSelector;
	private String resultBoxSelectorType;
	
	public String getInputSelector() {
		return inputSelector;
	}
	public void setInputSelector(String inputSelector) {
		this.inputSelector = inputSelector;
	}
	public String getInputSelectorType() {
		return inputSelectorType;
	}
	public void setInputSelectorType(String inputSelectorType) {
		this.inputSelectorType = inputSelectorType;
	}
	public String getSearchButtonSelector() {
		return searchButtonSelector;
	}
	public void setSearchButtonSelector(String searchButtonSelector) {
		this.searchButtonSelector = searchButtonSelector;
	}
	public String getSearchButtonSelectorType() {
		return searchButtonSelectorType;
	}
	public void setSearchButtonSelectorType(String searchButtonSelectorType) {
		this.searchButtonSelectorType = searchButtonSelectorType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getResultBoxSelector() {
		return resultBoxSelector;
	}
	public void setResultBoxSelector(String resultBoxSelector) {
		this.resultBoxSelector = resultBoxSelector;
	}

	public String getResultBoxSelectorType() {
		return resultBoxSelectorType;
	}
	public void setResultBoxSelectorType(String resultBoxSelectorType) {
		this.resultBoxSelectorType = resultBoxSelectorType;
	}
	@Override
	public String toString() {
		return "DuckDuckGoData [inputSelector=" + inputSelector + ", inputSelectorType=" + inputSelectorType
				+ ", searchButtonSelector=" + searchButtonSelector + ", searchButtonSelectorType="
				+ searchButtonSelectorType + ", url=" + url + ", resultBoxSelector=" + resultBoxSelector
				+ ", resultBoxSelectorType=" + resultBoxSelectorType + "]";
	}
	
	
	

	
	
	
	
}
