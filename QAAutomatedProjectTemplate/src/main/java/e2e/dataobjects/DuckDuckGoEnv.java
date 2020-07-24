package e2e.dataobjects;

/**
 * @author Jorge Ivan Matamoros Duran
 *Pojo container of test date for page object DuckDuckGo according with the environment
 */
public class DuckDuckGoEnv {

	private DuckDuckGoData QA;
	private DuckDuckGoData DEV;
	
	public DuckDuckGoData getQA() {
		return QA;
	}
	public void setQA(DuckDuckGoData qA) {
		QA = qA;
	}
	public DuckDuckGoData getDEV() {
		return DEV;
	}
	public void setDEV(DuckDuckGoData dEV) {
		DEV = dEV;
	}
	
	@Override
	public String toString() {
		return "DuckDuckGoEnv [QA=" + QA + ", DEV=" + DEV + "]";
	}
	
	
}
