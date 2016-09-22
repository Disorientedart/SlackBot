package Ulitity;

import java.io.IOException;

import DisorientedArt.SlackBot.SlackInfo;
import Slack.Messages;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class APICalls {

	public static void postMessage(String text) throws IOException {
		System.out.println("Preparing to post a message");
		
		String addOn = "&text=" + text;
		
		APICalls.postMessageBuilder(addOn);
	}

	public static void postMessageBuilder(String addOns) throws IOException {
		System.out.println("Building the message");
		// API address
		String hostAddress = SlackInfo.getApiHost() + "/chat.postMessage";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType,
				SlackInfo.getTokenURL()
				+ SlackInfo.getChannelURL()
				+ SlackInfo.getUsernameURL()
				+ SlackInfo.getIcon_urlURL()
				+ addOns);

		postAPI(hostAddress, body);
	}

	public static void removeMessage() throws IOException {
		System.out.println("Preparing to remove a message");
		
		String hostAddress = SlackInfo.getApiHost() + "/chat.delete";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				SlackInfo.getTokenURL()
				+ SlackInfo.getChannelURL()
				+ SlackInfo.getDeleteMessageURL());
		
		postAPI(hostAddress, body);
	}

	public static void apiTest() throws IOException {
		System.out.println("Performing an API Test");

		String hostAddress = SlackInfo.getApiHost() + "/api.test";

		getAPI(hostAddress);
	}

	public static void authTest() throws IOException {
		System.out.println("Performing an Auth Test");

		String hostAddress = SlackInfo.getApiHost() + "/auth.test";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				SlackInfo.getTokenURL());
		
		postAPI(hostAddress, body);
	}

	public static void rtmStart() throws IOException {
		System.out.println("Starting Real Time Messaging");

		String hostAddress = SlackInfo.getApiHost() + "/rtm.start";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType,
				SlackInfo.getTokenURL() + "&no_unreads=0" + "&simple_latest=0" + "&mpim_aware=1");
		
		postAPI(hostAddress, body);
	}
	
    public static void channelHistory()throws IOException{
		System.out.println("Looking at the Channel History of #t_swift");
		
		String hostAddress = SlackInfo.getApiHost() + "/channels.history";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
    	RequestBody body = RequestBody.create(mediaType, 
    			SlackInfo.getTokenURL()
    			+ SlackInfo.getChannelURL()
    			+ "&inclusive=1"
    			+ "&count=2");
    	
    	String messageLogs = postParse(hostAddress, body);
		boolean activateBot = JSON.parseJSONMessages(messageLogs);
		if (activateBot){
			APICalls.postMessage(Messages.randomMessage());
		}
	}
    
	/**
	 * Sets the User Token to active on the Slack messenger
	 * @throws IOException
	 */
    public static void setActiveUser() throws IOException{
    	//users.setActive
    	
    	System.out.println("Setting User to Active");

    	String hostAddress = SlackInfo.getApiHost() +"/users.setActive";

    	MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
    	RequestBody body = RequestBody.create(mediaType, 
    			SlackInfo.getTokenURL()
    			);
    	postAPI(hostAddress, body);
    }
    
	/**
	 * Used to create the a posting API call.
	 * @param hostAddress
	 * @param body
	 * @throws IOException
	 */
	private static void getAPI(String hostAddress) throws IOException {
    	OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
    	  .url(hostAddress)
    	  .get()
    	  .addHeader("content-type", "application/x-www-form-urlencoded")
    	  .addHeader("cache-control", "no-cache")
    	  .build();
    	Response response = client.newCall(request).execute();
    	response.close();
	}

	/**
	 * Used to create the a posting API call.
	 * @param hostAddress
	 * @param body
	 * @throws IOException
	 */
	private static void postAPI(String hostAddress, RequestBody body) throws IOException {
    	OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
    	  .url(hostAddress)
    	  .post(body)
    	  .addHeader("content-type", "application/x-www-form-urlencoded")
    	  .addHeader("cache-control", "no-cache")
    	  .build();
    	Response response = client.newCall(request).execute();
    	response.close();
	}
	
	/**
	 * Used to create a String of the response
	 * @param hostAddress
	 * @param body
	 * @throws IOException
	 */
	private static String postParse(String hostAddress, RequestBody body) throws IOException {
    	OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
    	  .url(hostAddress)
    	  .post(body)
    	  .addHeader("content-type", "application/x-www-form-urlencoded")
    	  .addHeader("cache-control", "no-cache")
    	  .build();
    	Response response = client.newCall(request).execute();
    	String strResponse = response.body().string();
    	response.close();
    	return strResponse;
	}
	
	/**
	 * Used to create a String of the response
	 * @param hostAddress
	 * @param body
	 * @throws IOException
	 */
	private static String getParse(String hostAddress, RequestBody body) throws IOException {
    	OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
    	  .url(hostAddress)
    	  .get()
    	  .addHeader("content-type", "application/x-www-form-urlencoded")
    	  .addHeader("cache-control", "no-cache")
    	  .build();
    	Response response = client.newCall(request).execute();
    	String strResponse = response.body().string();
    	response.close();
    	return strResponse;
	}

	// public static void jsonSoup()throws IOException{
	// System.out.println( "Hello World!" );
	//
	// Document doc = Jsoup.connect("").get();
	// Elements newsHeadlines = doc.select("");
	//
	// for(Element news : newsHeadlines){
	// String url = news.attr("");
	// System.out.println(url);
	// }
	// }

}