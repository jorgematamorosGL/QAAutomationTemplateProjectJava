package e2e.dataobjects;

/**
 * @author Jorge Ivan Matamoros Duran
 *Pojo container of test date for page object DuckDuckgoResultPage according with the environment
 */
public class DuckDuckGoResultPageEnv {

	private DuckDuckGoResultPageData QA;
	private DuckDuckGoResultPageData DEV;
	
	
	
	public DuckDuckGoResultPageData getQA() {
		return QA;
	}
	public void setQA(DuckDuckGoResultPageData qA) {
		QA = qA;
	}
	public DuckDuckGoResultPageData getDEV() {
		return DEV;
	}
	public void setDEV(DuckDuckGoResultPageData dEV) {
		DEV = dEV;
	}
	@Override
	public String toString() {
		return "DuckDuckgoResultPageEnv [QA=" + QA + ", DEV=" + DEV + "]";
	}
	
	
}
