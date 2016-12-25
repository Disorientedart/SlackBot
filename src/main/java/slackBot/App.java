package slackBot;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import personalities.BotNumberTwo;
import personalities.ISlackBot;
import personalities.TaylorBot;
import slackAPI.APICalls;
import utility.ConsoleMessages;
import utility.Utilities;
import utility.MessageManagement;

public class App extends ClassHandler {

	public static int delayTime = 2000;
	public static int errorTime = 10000;
	public static int messageCount = 100;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		//User input from command-line execution
		String userInput = args[0];

		//Initializes the required classes for the slackBot
		Utilities utility = getUtility();
		APICalls apiCall = getApiCalls();
		ISlackBot slackBot;
		SlackInfo slackInfo = getSlackInfo();

		//Retrieves the token for the bot
		slackInfo.setToken(utility.externalToken());
		
		//Determines which bot to initialize
		if(slackInfo.getToken().endsWith("Qs")){
			setSlackBot(new TaylorBot());
		}
		else{
			setSlackBot(new BotNumberTwo());
		}

		//gets the personality of ISlackBot class
		slackBot = getSlackBot();
		slackBot.setPersonality();
		
		//Prints the start time to the console
		utility.printTime();

		//Determines the actions that the SlackBot will take during it's execution
		switch (userInput) {
		//Removes undesired messages from the Slack Channel
		case "delete":
			slackInfo.setDeleteMessage("1477887041.000003");
			apiCall.removeMessage();
			slackInfo.setDeleteMessage("1477887040.000002");
			apiCall.removeMessage();
			break;
			
		//Tests the API calls to verify that a connection can be made
		case "test":
			apiCall.testAPI();
			break;
			
		//Looks at the history of the channel and pulls to an external file
		case "history":
			slackInfo.setCount(messageCount);
			apiCall.groupHistory(slackBot);
			break;
			
		//Sets the SlackBot to active and will response to user inputs
		case "activate":
			do{
				try {
					apiCall.channelHistory(slackBot);
				} catch (UnknownHostException LostConection) {
					System.out.println(ConsoleMessages.consoleMessage5);
				} catch (SocketTimeoutException LostConection) {
					System.out.println(ConsoleMessages.consoleMessage6);
					Thread.sleep(errorTime);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}
				Thread.sleep(delayTime);
			} while (utility.continueRun());
			break;
			
		//Gets information about the current Slack Host
		case "getInfo":
			apiCall.getChannelList();
			apiCall.getGroupList();
			break;

		//Outputs information about what is available to the User
		default:
			System.out.println(
					"SlackBot created by Dean Morrison/nUsed to interact with a Slack Host/n"
					+ "Available options are:/n"
					+ "delete: removes messages as detailed by TimeStamps/n"
					+ "test: Attempts to establish a connection using the token/n"
					+ "history: Pulls information about the channel used by the token/n"
					+ "activate: Turns on the SlackBot/n"
					+ "Please use one of the available options");
		}

		//Prints the end time to the console
		utility.printTime();
	}

}