package slackAPI;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class Channels extends APICalls{

	//channels.archive
	public void archive() throws IOException 
	{
		System.out.println("Preparing to Archive a Channel");

		String hostAddress = getApiHost() + "/channels.archive";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}
	
	//channels.create
	public void create() throws IOException 
	{
		System.out.println("Preparing to Create a Channel");

		String hostAddress = getApiHost() + "/channels.create";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}
	
	//channels.history
	public void history() throws IOException 
	{
		System.out.println("Preparing to get the History of a Channel");

		String hostAddress = getApiHost() + "/channels.history";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}
	
	//channels.info
	public void info() throws IOException 
	{
		System.out.println("Preparing to get some information about a Channel");

		String hostAddress = getApiHost() + "/channels.info";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}
	
	//channels.invite
	public void invite() throws IOException 
	{
		System.out.println("Preparing an invite to a Channel");

		String hostAddress = getApiHost() + "/channels.invite";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}
	
	//channels.join
	public void join() throws IOException 
	{
		System.out.println("Preparing to Join a Channel");

		String hostAddress = getApiHost() + "/channels.create";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}
	
	//channels.kick
	public void kick() throws IOException 
	{
		System.out.println("Preparing to kick a User from a Channel");

		String hostAddress = getApiHost() + "/channels.kick";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}
	
	//channels.leave
	public void leave() throws IOException 
	{
		System.out.println("Preparing to leave a Channel");

		String hostAddress = getApiHost() + "/channels.leave";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}
	
	//channels.list
	public void list() throws IOException 
	{
		System.out.println("Preparing to list of a Channel");

		String hostAddress = getApiHost() + "/channels.list";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}
	
	//channels.mark
	public void mark() throws IOException 
	{
		System.out.println("Preparing to mark a Channel");

		String hostAddress = getApiHost() + "/channels.mark";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}
	
	//channels.rename
	public void rename() throws IOException 
	{
		System.out.println("Preparing to rename a Channel");

		String hostAddress = getApiHost() + "/channels.rename";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}
	
	//channels.setPurpose
	public void setPurpose() throws IOException 
	{
		System.out.println("Preparing to set the Purpose of a Channel");

		String hostAddress = getApiHost() + "/channels.setPurpose";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}
	
	//channels.setTopic
	public void setTopic() throws IOException 
	{
		System.out.println("Preparing to setTopic of a Channel");

		String hostAddress = getApiHost() + "/channels.setTopic";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}
	
	//channels.unarchive
	public void unarchive() throws IOException 
	{
		System.out.println("Preparing to unarchive a Channel");

		String hostAddress = getApiHost() + "/channels.unarchive";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, 
				slackInfo.getTokenURL()
				);
		postAPI(hostAddress, body);
	}
	
}
