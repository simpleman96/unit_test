package tdd;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ex4_firsttdd.Template3;


public class testTemplate {

	@Test
	public void testoneVariable() throws Exception {
		Template3 template = new Template3("Hello, ${name}");
		template.set("name", "Reader");
		assertEquals("Hello, Reader", template.evaluate());
	}

	@Test
	public void testdifferentValue() throws Exception {
		Template3 template = new Template3("Hello, ${name}");
		template.set("name", "someone else");
		assertEquals("Hello, someone else", template.evaluate());
	}
	
	@Test
	public void testmultipleVariables() throws Exception {
		Template3 template = new Template3("${one}, ${two}, ${three}");
		template.set("one", "1");
		template.set("two", "2");
		template.set("three", "3");
		assertEquals("1, 2, 3", template.evaluate());
	}
	
	@Test
	public void testunknownVariablesAreIgnored() throws Exception {
		Template3 template = new Template3("Hello, ${name}");
		template.set("name", "Reader");
		template.set("doesnotexist", "Hi");
		assertEquals("Hello, Reader", template.evaluate());
	}
}