package testMock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ex2_dj.Consumer;
import ex2_dj.MessageService;
import ex2_dj.MessageServiceInjector;
import ex2_dj.MyDIApplication;


public class test_ex2 {

	private MessageServiceInjector injector;
	@Before
	public void setUp(){
		//mock the injector with anonymous class
		injector = new MessageServiceInjector() {
			
			@Override
			public Consumer getConsumer() {
				//mock the message service
				return new MyDIApplication(new MessageService() {
					
					@Override
					public void sendMessage(String msg, String rec) {
						System.out.println("Send Mock message service implementation: " + msg + ", tp: "+rec);
					
					}
				});
			}
		};
	}
	
	@Test
	public void test() {
		Consumer consumer = injector.getConsumer();
		consumer.processMessages("Hi Tuan Anh", "anhpham@abc.com");
	}
	
	@After
	public void tear(){
		injector = null;
	}

}