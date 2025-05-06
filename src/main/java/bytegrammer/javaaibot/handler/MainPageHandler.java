package bytegrammer.javaaibot.handler;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

public class MainPageHandler extends Restlet {
	public void handle(Request request, Response response) {

		Method m = request.getMethod();
		if (m.equals(Method.GET)) {
			response.setEntity("The Javaaibot REST-API is running... Please send POST-Requests", MediaType.TEXT_PLAIN);
		} else {
			response.setStatus(Status.CLIENT_ERROR_METHOD_NOT_ALLOWED, "Method not allowed");
		}

	}
}
