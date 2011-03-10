package mail;

public class Sender {

	private MailServer server;
	private Verifier verifier;
	
	public void deliver(String to, String body) {
		Message msg = new Message(to,body);
		verifier.verify(msg);
		server.accept(msg);
	}

}
