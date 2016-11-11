package slackBot;

import personalities.ISlackBot;
import utility.APICalls;
import utility.Utilities;

public class ClassHandler {

	private static APICalls apiCalls = null;
	private static ISlackBot slackBot = null;
	private static SlackInfo slackInfo = null;
	private static Utilities utility = null;

	public static APICalls getApiCalls() {
		if (apiCalls == null)
			apiCalls = new APICalls();
		return apiCalls;
	}

	public static ISlackBot getSlackBot() {
		return slackBot;
	}

	public static SlackInfo getSlackInfo() {
		if (slackInfo == null)
			slackInfo = new SlackInfo();
		return slackInfo;
	}

	public static Utilities getUtility() {
		if (utility == null)
			utility = new Utilities();
		return utility;
	}

	public static void setApiCalls(APICalls apiCalls) {
		ClassHandler.apiCalls = apiCalls;
	}

	public static void setSlackBot(ISlackBot slackBot) {
		ClassHandler.slackBot = slackBot;
	}

	public static void setSlackInfo(SlackInfo slackInfo) {
		ClassHandler.slackInfo = slackInfo;
	}

	public static void setUtility(Utilities utility) {
		ClassHandler.utility = utility;
	}

}
