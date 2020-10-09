package ex1_nondj;

public class EmailService {

	public String sendEmail(String message, String receiver){
		//logic to send email
		String out = "Email sent to "+receiver+ " with Message: "+message;
		return out;
	}
}