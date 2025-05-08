package bytegrammer.javaaibot.data;

public class ClientRequest {
	String request;
	String impersonate;
	public ClientRequest() {
		
	}
	
	public ClientRequest(String request) {
		this.request = request;
	}
	
	public String getRequest() {
		return request;
	}
	
	public void setRequest(String request) {
		this.request = request;
	}
	
	public String getImpersonate() {
		return impersonate;
	}

	public void setImpersonate(String impersonate) {
		this.impersonate = impersonate;
	}

	
	
	
}
