package personalities;

import java.io.IOException;

public interface ISlackBot 
{
	//Interface for interacting with the Personality of a SlackBot
	public void setPersonality();
	public String randomMessage();
	public String randomAdjective();
	public String randomImage();
	public void historyResponse(String historyLogs) throws IOException;
	public void botResponses(String[] messages) throws IOException;
}
