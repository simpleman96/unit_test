package ex4_firsttdd;

public class Template2 {
	private String variableValue;
	private String templateText;
	
	public Template2(String templateText) {
		this.templateText = templateText;
	}
	public void set(String variable, String value) {
		this.variableValue = value;
	}
	public String evaluate() {
		return templateText.replaceAll("\\$\\{name\\}", variableValue);
	}
}