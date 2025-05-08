package bytegrammer.javaaibot;

import org.restlet.Component;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;
import org.restlet.security.ChallengeAuthenticator;
import org.restlet.security.MapVerifier;

import bytegrammer.javaaibot.handler.MainPageHandler;
import bytegrammer.javaaibot.handler.ChatbotHandler;

public class Application {

	public static void main(String[] args) {
		System.out.println("Hello Restlet!");
		final Component component = new Component();
		component.getServers().add(Protocol.HTTP, 8081);
		
		final Router router = new Router(component.getContext().
		
	    createChildContext());

		router.attach("/", new MainPageHandler());
		
		ChatbotHandler chatbotHandler = new ChatbotHandler();
		
		// Guard the restlet with BASIC authentication.
		ChallengeAuthenticator guard = new ChallengeAuthenticator(null, ChallengeScheme.HTTP_BASIC, "testRealm");
		// Instantiates a Verifier of identifier/secret couples based on a simple Map.
		MapVerifier mapVerifier = new MapVerifier();
		// Load a single static login/secret pair.
		mapVerifier.getLocalSecrets().put("carlos", "secret".toCharArray());
		guard.setVerifier(mapVerifier);

		guard.setNext(chatbotHandler);
		
		
		router.attach("/chatbot", guard);
		
	
		

		component.getDefaultHost().attach(router);			


		try {
			component.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
