package slackAPI;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;;

public class Chat extends APICalls{

	public void delete() throws IOException 
	{
		System.out.println("Preparing to Delete Chat information");

		String hostAddress = getApiHost() + "/chat.delete";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				+	slackInfo.getChannelURL()
				+	slackInfo.getAS_UserURL() //Optional
				+	slackInfo.getDeleteMessageURL());
		postAPI(hostAddress, body);
	}
	
	public void meMessage(String text) throws IOException 
	{
		System.out.println("Preparing meMessage Chat information");

		String hostAddress = getApiHost() + "/chat.meMessage";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				+	slackInfo.getChannelURL()
				+	"&text=" + text);
		postAPI(hostAddress, body);
	}
	
	public void postMessage(String text) throws IOException 
	{
		System.out.println("Preparing postMessage information");

		String hostAddress = getApiHost() + "/chat.postMessage";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				+	slackInfo.getChannelURL()
				+	"&text=" + text);
		postAPI(hostAddress, body);
	}
	
	public void updateMessage(String text, String ts) throws IOException 
	{
		System.out.println("Preparing postMessage information");

		String hostAddress = getApiHost() + "/chat.update";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				+	slackInfo.getChannelURL()
				+	"&ts=" + ts
				+	"&text=" + text);
		postAPI(hostAddress, body);
	}
	
}
