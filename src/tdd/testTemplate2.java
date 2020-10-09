package tdd;
import org.junit.Test;

import ex4_firsttdd.Template3;
import ex4_firsttdd.Template3.MissingValueException;

import org.junit.Before;
import static org.junit.Assert.*;

public class testTemplate2 {

	private Template3 template;
	@Before
	public void setUp() throws Exception {
		template = new Template3("${one}, ${two}, ${three}");
		template.set("one", "1");
		template.set("two", "2");
		template.set("three", "3");
	}
	@Test
	public void multipleVariables() throws Exception {
		assertTemplateEvaluatesTo("1, 2, 3");
	}

	@Test
	public void unknownVariablesAreIgnored() throws Exception {
		template.set("doesnotexist", "whatever");
		assertTemplateEvaluatesTo("1, 2, 3");
	}
	private void assertTemplateEvaluatesTo(String expected) {
		assertEquals(expected, template.evaluate());
	}
	
	@Test(expected=MissingValueException.class)
	public void testMissingValueRaisesException() throws Exception {
		new Template3("${foo}").evaluate();
	}
}