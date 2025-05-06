package bytegrammer.javaaibot.handler;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

public class ChatbotHandler extends Restlet{
	public void handle(Request request, Response response) {

		Method m = request.getMethod();
		if (m.equals(Method.POST)) {
			response.setEntity("Testing Post request", MediaType.TEXT_PLAIN);
		} else {
			response.setStatus(Status.CLIENT_ERROR_METHOD_NOT_ALLOWED, "Method not allowed");
		}

	}
}
