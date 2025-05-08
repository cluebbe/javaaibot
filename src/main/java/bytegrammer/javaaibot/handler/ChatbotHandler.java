package bytegrammer.javaaibot.handler;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;
import org.restlet.representation.Representation;

import com.fasterxml.jackson.databind.ObjectMapper;

import bytegrammer.javaaibot.Constants;
import bytegrammer.javaaibot.data.ApiRequest;
import bytegrammer.javaaibot.data.ApiResponse;
import bytegrammer.javaaibot.data.ClientRequest;
import bytegrammer.javaaibot.data.ClientResponse;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.HttpHeaders;

public class ChatbotHandler extends Restlet {
	public void handle(Request request, Response response) {

		Method m = request.getMethod();
		if (m.equals(Method.POST)) {

			ObjectMapper objectMapper = new ObjectMapper();
			
		
			
			try {
				String clientRequestBody = request.getEntity().getText();
				ClientRequest clientRequest = objectMapper.readValue(clientRequestBody, ClientRequest.class);
				
				if(clientRequest == null | clientRequest.getRequest() == null | clientRequest.getImpersonate()== null){
					response.setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
					return;
				}
				
				String userMessagePretext = "Please answer the following question as if you were an actor impersonating " + clientRequest.getImpersonate() + " (100 Tokens max): ";
				
				
				ApiRequest apiRequest = new ApiRequest(userMessagePretext + clientRequest.getRequest());
				
				
				Client client = ClientBuilder.newClient();
				WebTarget webTarget = client.target("https://api.x.ai").path("/v1/chat/completions"); 

				ApiResponse apiResponse = webTarget.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
						.header(HttpHeaders.AUTHORIZATION, "Bearer " + Constants.API_KEY)
						.accept(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
						.post(Entity.entity(apiRequest, jakarta.ws.rs.core.MediaType.APPLICATION_JSON),
								ApiResponse.class);

				
				if (apiResponse != null && apiResponse.getMessage() != null) {
					response.setEntity(
							objectMapper.writeValueAsString(
									new ClientResponse(apiResponse.getMessage())),
							MediaType.APPLICATION_ALL_JSON);

				} else {
					throw new IllegalStateException("AI-API responded with empty message");
				}

			} catch (Exception e) {
				response.setStatus(Status.SERVER_ERROR_INTERNAL, e);
				e.printStackTrace();
			}
		} else {
			response.setStatus(Status.CLIENT_ERROR_METHOD_NOT_ALLOWED, "Method not allowed");
		}

	}
}
