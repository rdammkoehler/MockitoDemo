package mail;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Test;

import support.MockitoTestBase;

public class SendMailTest extends MockitoTestBase {

	@Mock private MailServer server;
	@Mock private Verifier verifier;
	@InjectMocks private Sender sender = new Sender();
	
	@Test
	public void shouldSendMessageToAddressWhenAddressAndBodyProvided() {
		String to = "testuser@mydomain.net";
		String body = "this is a test message";
		sender.deliver(to,body);
		
		verify(server).accept(any(Message.class));
	}
	
	@Test
	public void shouldReceiveRuntimeExceptionIfMessageIsInvalid() {
		when(verifier.verify(any(Message.class))).thenReturn(false);
		String to = null;
		String body = "this is a test message";
		sender.deliver(to,body);		
	}
}
