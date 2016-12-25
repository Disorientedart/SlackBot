package slackAPI;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import personalities.ISlackBot;
import slackBot.ClassHandler;
import slackBot.SlackInfo;

public class APICalls 
{
	private String apiHost = "https://slack.com/api";
	ISlackBot slackBot = ClassHandler.getSlackBot();
	
	protected SlackInfo slackInfo = ClassHandler.getSlackInfo();
	
	/**
	 * GET: message to the "/api.test" url
	 * @throws IOException
	 */
	public void apiTest() throws IOException 
	{
		System.out.println("Performing an API Test");

		String hostAddress = getApiHost() + "/api.test";

		getAPI(hostAddress);
	}
	
	/**
	 * POST: message to "/groups.list"
	 * @throws IOException
	 */
	public void getGroupList() throws IOException 
	{
		System.out.println("Retrieving a Group List");

		String hostAddress = getApiHost() + "/groups.list";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL());
		
		postAPI(hostAddress, body);
	}
	
	/**
	 * POST: message to "/channels.list"
	 * @throws IOException
	 */
	public void getChannelList() throws IOException 
	{
		System.out.println("Retrieving a Channels List");

		String hostAddress = getApiHost() + "/channels.list";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL());
		
		postAPI(hostAddress, body);
	}
	
	/**
	 * POST: message to "/auth.test"
	 * @throws IOException
	 */
	public void authTest() throws IOException 
	{
		System.out.println("Performing an Auth Test");

		String hostAddress = getApiHost() + "/auth.test";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL());
		
		postAPI(hostAddress, body);
	}
	
	/**
	 * Looks at the history of a group listing
	 * @param slackBot
	 * @return 
	 * @throws IOException
	 */
	public void groupHistory(ISlackBot slackBot)throws IOException
    {
		System.out.println("Retrieving Group History");
		
		String hostAddress = getApiHost() + "/groups.history";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
    	RequestBody body = RequestBody.create(mediaType, 
    			slackInfo.getTokenURL()
    			+ slackInfo.getChannelURL()
    			+ slackInfo.getInclusiveURL()
    			+ slackInfo.getCountURL());
    	
    	slackBot.historyResponse(readablePost(hostAddress, body));
    	
	}
	
	public void channelHistory(ISlackBot slackBot)throws IOException
    {
		System.out.println("Retrieving Channel History");
		
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
	
	public String getApiHost() {
		return apiHost;
	}

	/**
	 * Attempts to create a Giphy response in Slack Channel
	 * @param text
	 * @throws IOException
	 */
	public void giphyMessage(String text) throws IOException 
	{
		System.out.println("Preparing to post a message");
		
		String addOn = "&text=" + text + ""
				+ "&command=/giphy";
		
		postMessageBuilder(addOn);
	}

	/**
	 * Used to create the a posting API call.
	 * @param hostAddress
	 * @param body
	 * @throws IOException
	 */
	protected void postAPI(String hostAddress, RequestBody body) throws IOException 
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
	 * POST: Sends a string of text to the Channel or Group
	 * @param text
	 * @throws IOException
	 */
	public void postMessage(String text) throws IOException 
	{
		System.out.println("Preparing to post a message");
		
		String addOn = "&text=" + text;
		
		postMessageBuilder(addOn);
	}

	/**
	 * Composes all requirements for sending a string of text
	 * @param addOns
	 * @throws IOException
	 */
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

	/**
	 * Used to create a String of the response
	 * @param hostAddress
	 * @param body
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
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
	 * Removes a message or a group of messages from the Channel or Group
	 * @throws IOException
	 */
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
    
	/**
	 * Starts Real Time Messaging
	 * @throws IOException
	 */
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
	
	public  void setApiHost(String value) {
		apiHost = value;
	}
	
	/**
	 * Grouping of methods to test the API calls
	 * @throws IOException
	 */
	public void testAPI() throws IOException
	{
		apiTest();
		authTest();
		setActiveUser();
	}

}