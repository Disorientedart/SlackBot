package DisorientedArt.SlackBot;

import java.io.IOException;
import java.time.LocalTime;

import Slack.Messages;
import Ulitity.APICalls;


public class App 
{
	
    public static void main( String[] args ) throws IOException, InterruptedException
    {
    	//Sets the token from external file of userToken.txt
    	SlackInfo.setToken(SlackInfo.externalToken());
    	printTime();
    	
    	switch (args[0])
    	{
    		case "active":
    	    	do{
    	    		try {
    					APICalls.channelHistory();
    				} catch (Exception e) {
    					 //TODO Auto-generated catch block
    					e.printStackTrace();
    					break;
    				}
    	    		Thread.sleep(2000);
    	    	}while(LocalTime.now().isBefore(LocalTime.of(23, 50)));
    	    	break;
    		
    		case "delete":
    	    	SlackInfo.setDeleteMessage("");
    	    	APICalls.removeMessage();
    			break;
    			
    		case "test":
    	    	//Runs the code throughout a typical work day
    	    	APICalls.apiTest();
    	    	APICalls.authTest();
    	    	APICalls.setActiveUser();
    	    	APICalls.giphyMessage(Messages.randomAdjective());
    			break;
    		
    		default:
    	    	do{
    	    		try {
    					APICalls.channelHistory();
    				} catch (Exception e) {
    					 //TODO Auto-generated catch block
    					e.printStackTrace();
    					break;
    				}
    	    		Thread.sleep(2000);
    	    	}while(LocalTime.now().isBefore(LocalTime.of(18, 00)));
    			break;	
    	}
    	
    	printTime();
    	
    }

    public static void printTime(){
    	System.out.println(LocalTime.now());
    }
    
}