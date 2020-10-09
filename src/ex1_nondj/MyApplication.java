package ex1_nondj;

public class MyApplication {

	private EmailService email = new EmailService();
	
	public String processMessages(String msg, String rec){
		//do some msg validation, manipulation logic etc
		return this.email.sendEmail(msg, rec);
	}
}