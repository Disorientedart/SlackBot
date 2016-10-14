package Ulitity;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import DisorientedArt.SlackBot.SlackInfo;


public class JSON {
	
	/**
	 * Creates a JSONObject to be used for an API call and returns the object
	 */
    public static JSONObject createJSON(){
    	JSONObject parse = new JSONObject();
    	
    	parse.put("ok", "true");
    	
    	return parse;
    }
    
    /**
     * Builds a JSONObject for posting a message and then returns it
     * @Param String text would be added to the object
     */
    public static JSONObject messageJSON(String text){
    	JSONObject parse = new JSONObject();

    	parse.put("token", SlackInfo.getToken());
    	parse.put("channel", SlackInfo.getChannel());
    	parse.put("text", text);
    	parse.put("as_user", SlackInfo.getAS_User());
    	parse.put("username", SlackInfo.getUsername());
    	parse.put("icon_url", SlackInfo.getIcon_url());
    	
    	return parse;
    }
    
    /**
     * Parses a JSON object and returns the mapValue for the key
     * @param Response response should be the body of the API call
     * @param mapKey represents the desired value
     */
    public static void parseJSON(String response, String mapKey) throws IOException{
    	
    	try {
			JSONObject jsonObject = new JSONObject(response);
			System.out.println(jsonObject);
			String mapValue = jsonObject.get(mapKey).toString();
			System.out.println(mapValue);
			SlackInfo.setDeleteMessage(mapValue);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * Parses response for information about the content of previous messages
     * @param response
     * @param key
     * @return boolean
     * @throws IOException
     */
    public static boolean parseJSONMessages(String response, String key) throws IOException{
    	boolean presence = false;
		JSONObject parseME = new JSONObject(response);
		JSONArray useMe = parseME.getJSONArray("messages");
		
    	System.out.println("Reviewing Messages:");
    	
		int count = 0;
		while(count< useMe.length()){
			JSONObject indexObj = useMe.optJSONObject(count);
			String mapKey = indexObj.get(key).toString();
			String mapValue = indexObj.get("text").toString();
			System.out.println("Message " + count + " " + mapValue);
			
			System.out.println("Reviewing Message " + count);
			
			System.out.println(mapKey);
			System.out.println(SlackInfo.getLastMessage());
			if(mapValue.contains("Taylor") && !mapKey.equals(SlackInfo.getLastMessage())){
				System.out.println("MATCH FOUND");
				presence = true;
				SlackInfo.setLastMessage(indexObj.get(key).toString());
				break;
			}
			count++;
		}
    	return presence;
    }
    
}