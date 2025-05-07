package bytegrammer.javaaibot.data;

import java.util.ArrayList;
import java.util.List;

public class ApiRequest {
	private String model;
	private List<ChatMessage> messages;

	private class ChatMessage {
		String role;
		String content;

		public ChatMessage() {}
		
		public ChatMessage(String content) {
			this.role = "user";
			this.content = content;
		}

		public String getRole() {
			return role;
		}

		public String getContent() {
			return content;
		}

	}

	private Double temperature;
	private Integer max_tokens;
	private Boolean stream;

	public ApiRequest() {}
	
	public ApiRequest(String messageContent) {
		this.model = "grok-2-1212";
		this.messages = new ArrayList<ChatMessage>();
		this.messages.add(new ChatMessage(messageContent));
		this.temperature = 0.7;
		this.stream = false;
		this.max_tokens = 100;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<ChatMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<ChatMessage> messages) {
		this.messages = messages;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Integer getMax_tokens() {
		return max_tokens;
	}

	public void setMax_tokens(Integer max_tokens) {
		this.max_tokens = max_tokens;
	}

	public Boolean getStream() {
		return stream;
	}

	public void setStream(Boolean stream) {
		this.stream = stream;
	}

}
