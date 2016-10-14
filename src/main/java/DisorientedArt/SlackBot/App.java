package DisorientedArt.SlackBot;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.time.LocalTime;

import Slack.Messages;
import Ulitity.APICalls;


public class App 
{
	
    public static void main( String[] args ) throws IOException, InterruptedException
    {
    	
    	printTime();

    	String userInput = args[0];
    	//Sets the token from external file of userToken.txt
    	SlackInfo.setToken(SlackInfo.externalToken());

		switch (userInput)
    	{
    		case "active":
    	    	do{
    	    		try {
    					APICalls.channelHistory();
    				} 
    	    		catch (UnknownHostException LostConection){
    	    			System.out.println("Connection was lost from the Pi");
    	    		}
    	    		catch (SocketTimeoutException LostConection){
    	    			Thread.sleep(10000);
    	    			System.out.println("Connection was lost from the Pi");
    	    		}
    	    		catch (Exception e) {
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
    				}
    	    		catch (UnknownHostException LostConection){
    	    			System.out.println("Connection was lost from the Pi");
    	    		}
    	    		catch (SocketTimeoutException LostConection){
    	    			Thread.sleep(10000);
    	    			System.out.println("Connection was lost from the Pi, forcing 10 second wait before trying again");
    	    		}
    	    		catch (Exception e) {
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
    	System.out.println("SlackBot Timeframe: " + LocalTime.now());
    }
    
}