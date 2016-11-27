package slackAPI;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class DND extends APICalls{
	
	//dnd.endDnd
	public void endDnd() throws IOException 
	{
		System.out.println("");

		String hostAddress = getApiHost() + "/dnd.endDnd";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}
	
	//dnd.endSnooze
	public void endSnooze() throws IOException 
	{
		System.out.println("");

		String hostAddress = getApiHost() + "/dnd.endSnooze";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}
	
	//dnd.info
	public void info() throws IOException 
	{
		System.out.println("");

		String hostAddress = getApiHost() + "/dnd.info";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}
	
	//dnd.setSnooze
	public void setSnooze() throws IOException 
	{
		System.out.println("");

		String hostAddress = getApiHost() + "/dnd.setSnooze";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}
	
	//dnd.teamInfo
	public void teamInfo() throws IOException 
	{
		System.out.println("");

		String hostAddress = getApiHost() + "/dnd.teamInfo";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}

}
