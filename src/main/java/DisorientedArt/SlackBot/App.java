package DisorientedArt.SlackBot;

import java.io.IOException;
import java.time.LocalTime;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import Slack.Messages;
import Ulitity.APICalls;
import Ulitity.JSON;


public class App 
{
	
    public static void main( String[] args ) throws IOException, InterruptedException
    {
    	//Sets the token from external file of userToken.txt
    	SlackInfo.setToken(SlackInfo.externalToken());
    	//Runs the code throughout a typical work day
    	APICalls.apiTest();
    	APICalls.authTest();
    	APICalls.setActiveUser();
    	//APICalls.postMessage("Repo Location : https://github.com/Disorientedart/SlackBot");
    	do{
    		try {
				APICalls.channelHistory();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		Thread.sleep(1500);
    	}while(LocalTime.now().isBefore(LocalTime.of(18, 00)));

    	//Can be Used to remove any messages that are posted during the editing process of the code
    	//Add the Time Stamp of the message you want to delete,
    	//Time Stamp can be found in the console log of the previous run
//    	TaylorSwiftSlackInfo.setDeleteMessage("1473930184.000009");
//    	APICalls.removeMessage();
    	
    }
        
}