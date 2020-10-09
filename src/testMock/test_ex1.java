package testMock;

import org.junit.Assert;
import org.junit.Test;

import ex1_nondj.MyApplication;

 
public class test_ex1 {
	
	@Test
	public void testSendMessage() {
		MyApplication app = new MyApplication();
		String actual = app.processMessages("Hi TuanAnhPham", "anhpham@abc.com");
		Assert.assertEquals("Email sent to anhpham@abc.com with Message: Hi TuanAnhPham", actual);
	}
}
