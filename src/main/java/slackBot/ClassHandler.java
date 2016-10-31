package slackBot;

import personalities.ISlackBot;
import utility.APICalls;
import utility.Utilities;

public class ClassHandler {
	
	
//	public final class Singleton {
//	    private static Singleton instance = null;
//	    private Singleton() {}
//	    
//	    public static synchronized Singleton getInstance() {
//	        if (instance == null) instance = new Singleton();
//	        return instance;
//	    }
//	}
	
	
	private static Utilities utility 		= null;
	private static ISlackBot slackBot 	= null;
	private static APICalls apiCalls 	= null;
	private static SlackInfo slackInfo 	= null;
	
	public static SlackInfo getSlackInfo() {
		if(slackInfo == null) slackInfo = new SlackInfo();
		return slackInfo;
	}
	public static void setSlackInfo(SlackInfo slackInfo) {
		ClassHandler.slackInfo = slackInfo;
	}
	public static Utilities getUtility() {
		if (utility == null) utility = new Utilities();
		return utility;
	}
	public static void setUtility(Utilities utility) {
		ClassHandler.utility = utility;
	}
	
	public static ISlackBot getSlackBot() {
		return slackBot;
	}
	public static void setSlackBot(ISlackBot slackBot) {
		ClassHandler.slackBot = slackBot;
	}
	
	public static APICalls getApiCalls() {
		if (apiCalls == null) apiCalls = new APICalls();
		return apiCalls;
	}
	public static void setApiCalls(APICalls apiCalls) {
		ClassHandler.apiCalls = apiCalls;
	}

}
