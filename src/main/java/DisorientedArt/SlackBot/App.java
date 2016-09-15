package DisorientedArt.SlackBot;

import java.io.IOException;
import java.time.LocalTime;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import Slack.Lyrics;
import Ulitity.APICalls;
import Ulitity.JSON;


public class App 
{
	
    public static void main( String[] args ) throws IOException, InterruptedException
    {
    	//Sets the token from external file of userToken.txt
    	TaylorSwiftSlackInfo.setToken(TaylorSwiftSlackInfo.externalToken());
    	//Runs the code throughout a typical work day
    	APICalls.apiTest();
    	APICalls.authTest();
    	setActiveUser();
    	APICalls.postMessage("Repo Location : https://github.com/Disorientedart/SlackBot");
//    	APICalls.postMessage("Taylor Swift Bot is active" 
//    		+ "\nGenerating 8 random song lyrics off the keyword \"Taylor\""
//    		+ "\nIf you want to add to the project go to ");
    	do{
    		channelHistory();
    		Thread.sleep(1500);
    	}while(LocalTime.now().isBefore(LocalTime.of(18, 00)));

    	//Can be Used to remove any messages that are posted during the editing process of the code
    	//Add the Time Stamp of the message you want to delete,
    	//Time Stamp can be found in the console log of the previous run
//    	TaylorSwiftSlackInfo.setDeleteMessage("1473930184.000009");
//    	APICalls.removeMessage();
    }
    
    public static void channelHistory()throws IOException{
		OkHttpClient client = new OkHttpClient();
		
		System.out.println("Looking at the Channel History of #t_swift");
		//Address of where the api is being sent
		String hostAddress = TaylorSwiftSlackInfo.getApiHost() + "/channels.history";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
    	RequestBody body = RequestBody.create(mediaType, 
    			//Can be found in the TaylorSwiftSlackInfo.java
    			//Methods ending in URL contains the parameter info and the parameter
    			//anything that is not located in TaylorSwiftSlackInfo is a APICall specific parameter
    			TaylorSwiftSlackInfo.getTokenURL()
    			+ TaylorSwiftSlackInfo.getChannelURL()
    			+ "&inclusive=1"
    			+ "&count=2"
    			);
	
		Request request = new Request.Builder()
		  .url(hostAddress)
		  .post(body)
		  .addHeader("cache-control", "no-cache")
		  .build();
		Response response = client.newCall(request).execute();
		//Response.Body().string() is a destructive method for Response
		//Turning it into a string makes it available the for JSON parsing
		String messageLogs = response.body().string();
		boolean activateBot = JSON.parseJSONMessages(messageLogs);
		//Closing the Response is recommended by OKHttp3
		response.close();
		if (activateBot){
			APICalls.postMessage(Lyrics.randomMessage());
		}
	}
    
    public static void setActiveUser() throws IOException{
    	//users.setActive
    	
    	System.out.println("Setting User to Active");
    	OkHttpClient client = new OkHttpClient();
    	
    	String hostAddress = TaylorSwiftSlackInfo.getApiHost() +"/users.setActive";

    	MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
    	RequestBody body = RequestBody.create(mediaType, 
    			TaylorSwiftSlackInfo.getTokenURL()
    			);
    	Request request = new Request.Builder()
    	  .url(hostAddress)
    	  .post(body)
    	  .addHeader("content-type", "application/x-www-form-urlencoded")
    	  .addHeader("cache-control", "no-cache")
    	  .build();
    	Response response = client.newCall(request).execute();
    	response.close();
    }
    
}