package utility;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import personalities.ISlackBot;
import slackBot.SlackInfo;

public class APICalls 
{
	SlackInfo slackInfo;
	
	private String apiHost 		= "https://slack.com/api";
	
	public String getApiHost() {
		return apiHost;
	}
	public  void setApiHost(String value) {
		apiHost = value;
	}

	public void postMessage(String text) throws IOException 
	{
		System.out.println("Preparing to post a message");
		
		String addOn = "&text=" + text;
		
		postMessageBuilder(addOn);
	}
	
	public void giphyMessage(String text) throws IOException 
	{
		System.out.println("Preparing to post a message");
		
		String addOn = "&text=" + text + " Taylor Swift"
				+ "&command=/giphy";
		
		postMessageBuilder(addOn);
	}

	private void postMessageBuilder(String addOns) throws IOException 
	{
		System.out.println("Building the message");
		// API address
		String hostAddress = getApiHost() + "/chat.postMessage";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType,
				slackInfo.getTokenURL()
				+ slackInfo.getChannelURL()
				+ slackInfo.getUsernameURL()
				+ slackInfo.getIcon_urlURL()
				+ addOns);

		postAPI(hostAddress, body);
	}

	public void removeMessage() throws IOException 
	{
		System.out.println("Preparing to remove a message");
		
		String hostAddress = getApiHost() + "/chat.delete";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				+ slackInfo.getChannelURL()
				+ slackInfo.getDeleteMessageURL());
		
		postAPI(hostAddress, body);
	}

	public void apiTest() throws IOException 
	{
		System.out.println("Performing an API Test");

		String hostAddress = getApiHost() + "/api.test";

		getAPI(hostAddress);
	}

	public void authTest() throws IOException 
	{
		System.out.println("Performing an Auth Test");

		String hostAddress = getApiHost() + "/auth.test";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL());
		
		postAPI(hostAddress, body);
	}

	public void rtmStart() throws IOException 
	{
		System.out.println("Starting Real Time Messaging");

		String hostAddress = getApiHost() + "/rtm.start";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType,
				slackInfo.getTokenURL()
				+ slackInfo.getUnreadURL()
				+ slackInfo.getSimpleLatestURL()
				+ slackInfo.getMPIMAwareURL());
		
		postAPI(hostAddress, body);
	}
	
    public void channelHistory(ISlackBot slackBot)throws IOException
    {
		System.out.println("Looking at the Channel History");
		
		String hostAddress = getApiHost() + "/channels.history";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
    	RequestBody body = RequestBody.create(mediaType, 
    			slackInfo.getTokenURL()
    			+ slackInfo.getChannelURL()
    			+ slackInfo.getInclusiveURL()
    			+ slackInfo.getCountURL());
    	
    	slackBot.historyResponse(readablePost(hostAddress, body));
	}
    
	/**
	 * Sets the User Token to active on the Slack messenger
	 * @throws IOException
	 */
    public void setActiveUser() throws IOException
    {
    	//users.setActive
    	
    	System.out.println("Setting User to Active");

    	String hostAddress = getApiHost() +"/users.setActive";

    	MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
    	RequestBody body = RequestBody.create(mediaType, 
    			slackInfo.getTokenURL()
    			);
    	postAPI(hostAddress, body);
    }
    
	/**
	 * Used to create the a posting API call.
	 * @param hostAddress
	 * @throws IOException
	 */
	private void getAPI(String hostAddress) throws IOException 
	{
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
    	System.out.println(strResponse);
	}

	/**
	 * Used to create the a posting API call.
	 * @param hostAddress
	 * @param body
	 * @throws IOException
	 */
	private void postAPI(String hostAddress, RequestBody body) throws IOException 
	{
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
    	System.out.println(strResponse);
	}
	
	/**
	 * Used to create a String of the response
	 * @param hostAddress
	 * @param body
	 * @throws IOException
	 */
	private String readablePost(String hostAddress, RequestBody body) throws IOException 
	{
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
    	System.out.println(strResponse);
    	return strResponse;
	}
	
	/**
	 * Used to create a String of the response
	 * @param hostAddress
	 * @param body
	 * @throws IOException
	 */
	private String readableGet(String hostAddress, RequestBody body) throws IOException 
	{
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
    	System.out.println(strResponse);
    	return strResponse;
	}

}