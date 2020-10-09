package ex4_firsttdd;

public class Template1 {
	private String varInput;
	public Template1(String templateText) {
	}
	
	public void set(String variable, String value) {
		this.varInput = value;
	}
	
	public String evaluate() {
		return "Hello, " + varInput;
	}
}