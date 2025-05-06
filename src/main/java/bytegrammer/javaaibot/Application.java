package bytegrammer.javaaibot;

import org.restlet.Component;
import org.restlet.data.Protocol;

public class Application {

	public static void main(String[] args) {
		System.out.println("Hello Restlet!");
		final Component component = new Component();
		component.getServers().add(Protocol.HTTP, 8081);

		try {
			component.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
