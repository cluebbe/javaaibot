package bytegrammer.javaaibot.handler;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bytegrammer.javaaibot.data.ApiRequest;

public class ChatbotHandler extends Restlet{
	public void handle(Request request, Response response) {

		Method m = request.getMethod();
		if (m.equals(Method.POST)) {
			
			ObjectMapper objectMapper = new ObjectMapper();
			ApiRequest apiRequest = new ApiRequest("Who are you");
			try {
				response.setEntity(objectMapper.writeValueAsString( apiRequest), MediaType.APPLICATION_ALL_JSON);
		
			} catch (JsonProcessingException e) {
				response.setStatus(Status.SERVER_ERROR_INTERNAL, e);
				e.printStackTrace();
			}
		} else {
			response.setStatus(Status.CLIENT_ERROR_METHOD_NOT_ALLOWED, "Method not allowed");
		}

	}
}
