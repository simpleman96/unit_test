package ex4_firsttdd;

import java.util.Map;
import java.util.HashMap;
import static java.util.Map.Entry;

public class Template3 {
	private Map<String, String> variables;
	private String templateText;

	public Template3(String templateText) {
		this.variables = new HashMap<String, String>();
		this.templateText = templateText;
	}
	
	public void set(String name, String value) {
		this.variables.put(name, value);
	}

	public String evaluate() {
		String result = templateText;
		for (Entry<String, String> entry : variables.entrySet()) {
			String regex = "\\$\\{" + entry.getKey() + "\\}";
			result = result.replaceAll(regex, entry.getValue());
		}
		return result;
	}
	
	public class MissingValueException extends RuntimeException {
	}
}