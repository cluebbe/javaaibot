package bytegrammer.javaaibot.data;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
	
	
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Choice {
		

	    @JsonProperty("message")
	    private void unpackNested(Map<String,Object> message) {
	        this.message = (String)message.get("content");
	    }
		
		String message;
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}	
		
	}
	

	private List<Choice> choices;

	public ApiResponse() {
	}

	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

}
