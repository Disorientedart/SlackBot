package slackBot;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import personalities.ISlackBot;
import personalities.TaylorBot;
import utility.APICalls;
import utility.Util;


public class App
{

    public static void main( String[] args ) throws IOException, InterruptedException
    {
    	String userInput = args[0];
    
    	Util utility;
    	ISlackBot slackBot = new TaylorBot();
    	APICalls apiCalls;
    	
    	utility.printTime();

    	//SlackInfo.setToken(utility.externalToken());
    	
    	slackBot.setPersonality();

		switch (userInput)
    	{    			
    		case "test":
    			apiCalls.apiTest();
    			apiCalls.authTest();
    			apiCalls.setActiveUser();
    			apiCalls.giphyMessage(slackBot.randomMessage());
    			break;
    		
    		default:
    	    	do{
    	    		try {
    	    			apiCalls.channelHistory(slackBot);
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