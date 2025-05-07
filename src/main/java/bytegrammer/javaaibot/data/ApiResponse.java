package bytegrammer.javaaibot.data;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {

	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@SuppressWarnings("unchecked")
	@JsonProperty("choices")
	private void unpackNested(List<Object> choices) {
		if (choices.isEmpty() && choices.get(0) == null) {
			return;
		}
		Map<String, Object> choice = (Map<String, Object>) choices.get(0);
		if (choice.get("message") == null) {
			return;
		}
		Map<String, Object> assistentMessage = (Map<String, Object>) choice.get("message");

		this.message = (String)assistentMessage.get("content");
	}


	public ApiResponse() {
	}



}
