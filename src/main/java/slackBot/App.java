package slackBot;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import personalities.ISlackBot;
import personalities.TaylorBot;
import utility.APICalls;
import utility.Utilities;


public class App extends ClassHandler 
{

    public static void main( String[] args ) throws IOException, InterruptedException
    {
    	String userInput = args[0];
    	
    	Utilities utility = getUtility();
    	APICalls apiCall = getApiCalls();
    	setSlackBot(new TaylorBot());
    	ISlackBot slackBot = getSlackBot();
    	SlackInfo slackInfo = getSlackInfo();
    	
    	slackInfo.setToken(utility.externalToken());
    	
    	utility.printTime();
    	
    	slackBot.setPersonality();

		switch (userInput)
    	{    			
			case "delete":
				slackInfo.setDeleteMessage("1477887041.000003");
				apiCall.removeMessage();
				slackInfo.setDeleteMessage("1477887040.000002");
				apiCall.removeMessage();
				break;
    		case "test":
    			apiCall.testAPI();
    			break;
    		
    		default:
    	    	do{
    	    		try {
    	    			apiCall.channelHistory(slackBot);
    				}
    	    		catch (UnknownHostException LostConection){
    	    			System.out.println("Connection was lost from the Pi");
    	    		}
    	    		catch (SocketTimeoutException LostConection){
    	    			Thread.sleep(10000);
    	    			System.out.println("Connection was lost from the Pi, forcing 10 second wait before trying again.");
    	    		}
    	    		catch (Exception e) {
    					 //TODO Auto-generated catch block
    					e.printStackTrace();
    					break;
    				}
    	    		Thread.sleep(2000);
    	    	}while(utility.continueRun());
    			break;	
    	}
    	
    	utility.printTime();
    }

}