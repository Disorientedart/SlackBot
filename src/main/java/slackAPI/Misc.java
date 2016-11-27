package slackAPI;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class Misc extends APICalls{

	public void getChannelList() throws IOException 
	{
		System.out.println("Performing an Auth Test");

		String hostAddress = getApiHost() + "/channels.list";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL());
		
		postAPI(hostAddress, body);
	}
	
	//api.test
	
	//auth.revoke
	
	//auth.test
	
	//bots.info
	
	//emoji.list
	
	//oauth.access
	
	//rtm.start
	
}
