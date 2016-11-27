package personalities;

import java.io.IOException;

import slackAPI.APICalls;
import slackBot.ClassHandler;
import slackBot.SlackInfo;
import utility.JSON;
import utility.Utilities;

public class BotNumberTwo implements ISlackBot {
	
	private static boolean as_user = false;
	private static String botID = "U0C2l21FS";
	private static String channel = "G2G4EBBBM";
	private static String username;

	APICalls apiCalls = ClassHandler.getApiCalls();
	SlackInfo slackInfo = ClassHandler.getSlackInfo();
	Utilities utility = ClassHandler.getUtility();

	public void botResponses(String[] messages) throws IOException {
	}

	public void historyResponse(String historyLogs) throws IOException {
		try {
			utility.writeToFile(historyLogs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSON json = new JSON();
		json.parseJSONMessages(historyLogs);
	}

	public String randomAdjective() {
		String[] adjectives = { };

		return adjectives[utility.randomNumber(adjectives)];
	}

	public String randomImage() {
		String[] availableImage = {};
		return availableImage[utility.randomNumber(availableImage)];
	}

	public String randomMessage() {
		String[] availableMessages = {};
		return availableMessages[utility.randomNumber(availableMessages)];
	}

	public String randomNegative() {
		String[] availableMessages = {};
		return availableMessages[utility.randomNumber(availableMessages)];
	}

	public String randomPositve() {
		String[] availableMessages = {};
		return availableMessages[utility.randomNumber(availableMessages)];
	}

	public void setPersonality() {
		slackInfo.setAS_User(as_user);
		slackInfo.setBotID(botID);
		slackInfo.setChannel(channel);
//		slackInfo.setUsername(username);
//		slackInfo.setIcon_url(randomImage());
	}

}
