package mail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Test;

import support.MockitoTestBase;

public class SendMailTest extends MockitoTestBase {

	@Mock private MailServer server;
	@InjectMocks private Sender sender = new Sender();
	
	@Test
	public void shouldSendMessageToAddressWhenAddressAndBodyProvided() {
		String to = "testuser@mydomain.net";
		String body = "this is a test message";
		sender.deliver(to,body);
		
		verify(server).accept(any(Message.class));
	}
}
