package Ulitity;

import java.io.IOException;

import DisorientedArt.SlackBot.TaylorSwiftSlackInfo;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class APICalls {
	
    public static void postMessage(String text)throws IOException{
    	System.out.println("Preparing to post a message");
		String addOn = "&text="+text;
		APICalls.postMessageBuilder(addOn);
	}
    
    public static void postMessageBuilder(String addOns)throws IOException{
    	System.out.println("Building the message");
    	//API address
    	String hostAddress = TaylorSwiftSlackInfo.getApiHost() + "/chat.postMessage";
    	String urlEncoding = 
    			TaylorSwiftSlackInfo.getTokenURL()
    			+ TaylorSwiftSlackInfo.getChannelURL()
    			+ TaylorSwiftSlackInfo.getUsernameURL()
    			+ TaylorSwiftSlackInfo.getIcon_urlURL()
    			+ addOns;
    	APICalls.postAPI(hostAddress, urlEncoding);
    }
    
    public static void removeMessage()throws IOException{
    	System.out.println("Preparing to remove a message");
		String hostAddress = TaylorSwiftSlackInfo.getApiHost() + "/chat.delete";
		String urlEncoding = 
				TaylorSwiftSlackInfo.getTokenURL()
    			+ TaylorSwiftSlackInfo.getChannelURL()
    			+ TaylorSwiftSlackInfo.getDeleteMessageURL();
		APICalls.postAPI(hostAddress, urlEncoding);
	}

    public static void apiTest()throws IOException{
    	System.out.println("Performing an API Test");
		OkHttpClient client = new OkHttpClient();
		
		String hostAddress = TaylorSwiftSlackInfo.getApiHost() + "/api.test";
	
		Request request = new Request.Builder()
		  .url(hostAddress)
		  .get()
		  .addHeader("cache-control", "no-cache")
		  .build();
		Response response = client.newCall(request).execute();
		response.equals(JSON.createJSON());
		response.close();
	}
    
    public static void authTest() throws IOException{
    	System.out.println("Performing an Auth Test");
    	OkHttpClient client = new OkHttpClient();
    	
    	String hostAddress = TaylorSwiftSlackInfo.getApiHost() +"/auth.test";

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
    	System.out.println(response.body().string());
    	response.close();
    }
    
    public static void rtmStart()throws IOException{
    	System.out.println("Starting Real Time Messaging");
		OkHttpClient client = new OkHttpClient();
		
		String hostAddress = TaylorSwiftSlackInfo.getApiHost() + "/rtm.start";
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
    	RequestBody body = RequestBody.create(mediaType, 
    			TaylorSwiftSlackInfo.getTokenURL() 
    			+ "&no_unreads=0"
    			+ "&simple_latest=0"
    			+ "&mpim_aware=1"
    			);
	
		Request request = new Request.Builder()
		  .url(hostAddress)
		  .post(body)
		  .addHeader("cache-control", "no-cache")
		  .build();
		Response response = client.newCall(request).execute();
		System.out.println(response.body().string());
		response.close();
	}
	
	public static Response postAPI(String hostAddress, String post) throws IOException {
		System.out.println("Performing the POST method");
		OkHttpClient client = new OkHttpClient();
		
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		
		RequestBody body = RequestBody.create(mediaType, post);
		Request request = new Request.Builder()
		  .url(hostAddress)
		  .post(body)
		  .addHeader("content-type", "application/x-www-form-urlencoded")
		  .addHeader("cache-control", "no-cache")
		  .build();
		Response response = client.newCall(request).execute();
		String shitytext = response.body().string().toString();
    	JSON.parseJSON(shitytext);
		return response;
	}
    
	    
//    public static void jsonSoup()throws IOException{
//        System.out.println( "Hello World!" );
//        
//        Document doc = Jsoup.connect("").get();
//        Elements newsHeadlines = doc.select("");
//
//        for(Element news : newsHeadlines){
//        	String url = news.attr("");
//        	System.out.println(url);
//        }     
//    }

}