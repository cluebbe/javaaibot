package bytegrammer.javaaibot.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
	
	
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Choice {
		@JsonIgnoreProperties(ignoreUnknown = true)
		public static class AssistantMessage {
			String content;

			public String getContent() {
				return content;
			}

			public void setContent(String content) {
				this.content = content;
			}	

		}
		AssistantMessage message;
		public AssistantMessage getMessage() {
			return message;
		}
		public void setMessage(AssistantMessage message) {
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
