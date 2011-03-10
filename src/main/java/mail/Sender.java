package mail;

public class Sender {

	private MailServer server;
	
	public void deliver(String to, String body) {
		Message msg = new Message(to,body);
		server.accept(msg);
	}

}
