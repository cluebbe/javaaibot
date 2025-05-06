package bytegrammer.javaaibot;

import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;
import bytegrammer.javaaibot.handler.MainPageHandler;

public class Application {

	public static void main(String[] args) {
		System.out.println("Hello Restlet!");
		final Component component = new Component();
		component.getServers().add(Protocol.HTTP, 8081);
		
		final Router router = new Router(component.getContext().
				createChildContext());
				router.attach("/", new MainPageHandler());

				component.getDefaultHost().attach(router);


			


		try {
			component.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
