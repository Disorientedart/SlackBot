package personalities;

import java.io.IOException;

public interface ISlackBot {
	public void botResponses(String[] messages) throws IOException;

	public void historyResponse(String historyLogs) throws IOException;

	public String randomAdjective();

	public String randomImage();

	public String randomMessage();

	// Interface for interacting with the Personality of a SlackBot
	public void setPersonality();
}
