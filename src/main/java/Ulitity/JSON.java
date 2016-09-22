package Ulitity;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import DisorientedArt.SlackBot.SlackInfo;


public class JSON {
	
    public static JSONObject createJSON(){
    	JSONObject parse = new JSONObject();
    	
    	parse.put("ok", "true");
    	
    	return parse;
    }
    
    public static JSONObject messageJSON(){
    	JSONObject parse = new JSONObject();

    	parse.put("token", SlackInfo.getToken());
    	parse.put("channel", SlackInfo.getChannel());
    	parse.put("text", "This bot is currently under construction");
    	parse.put("as_user", SlackInfo.getAS_User());
    	parse.put("username", SlackInfo.getUsername());
    	parse.put("icon_url", SlackInfo.getIcon_url());
    	
    	return parse;
    }
    
    public static void parseJSON(String response) throws IOException{
    	System.out.println(response);
    	
    	try {
			JSONObject parseME = new JSONObject(response);
			System.out.println(parseME);
			String useMe = parseME.get("ts").toString();
			System.out.println(useMe);
			SlackInfo.setDeleteMessage(useMe);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static boolean parseJSONMessages(String response) throws IOException{
    	boolean presence = false;
    	System.out.println("Reviewing Messages:");
		JSONObject parseME = new JSONObject(response);
		JSONArray useMe = parseME.getJSONArray("messages");
		int count = 0;
		while(count< useMe.length()){
			JSONObject indexObj = useMe.optJSONObject(count);
			String txt = indexObj.get("text").toString();
			String ts = indexObj.get("ts").toString();
			if(txt.contains("Taylor") || txt.contains("taylor") && !ts.equals(SlackInfo.getLastMessage())){
				presence = true;
				SlackInfo.setLastMessage(indexObj.get("ts").toString());
				return presence;
			}
			count++;
		}
    	return presence;
    }
    
}