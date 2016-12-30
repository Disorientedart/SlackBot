package utility;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import personalities.ISlackBot;
import slackBot.ClassHandler;
import slackBot.SlackInfo;

public class JSON {

	ISlackBot slackBot = ClassHandler.getSlackBot();
	SlackInfo slackInfo = ClassHandler.getSlackInfo();

	/**
	 * Creates a JSONObject to be used for an API call and returns the object
	 */
	public JSONObject createJSON() {
		JSONObject parse = new JSONObject();
		parse.put("ok", "true");

		return parse;
	}

	/**
	 * Builds a JSONObject for posting a message and then returns it
	 * 
	 * @Param String text would be added to the object
	 */
	public JSONObject messageJSON(String text) {
		JSONObject parse = new JSONObject();
		parse.put("token", slackInfo.getToken());
		parse.put("channel", slackInfo.getChannel());
		parse.put("text", text);
		parse.put("as_user", slackInfo.getAS_User());
		parse.put("username", slackInfo.getUsername());
		parse.put("icon_url", slackInfo.getIcon_url());

		return parse;
	}

	/**
	 * Parses a JSON object and returns the mapValue for the key
	 * 
	 * @param Response
	 *            response should be the body of the API call
	 * @param mapKey
	 *            represents the desired value
	 */
	public void parseJSON(String response, String mapKey) throws IOException {
		try {
			JSONObject jsonObject = new JSONObject(response);
			System.out.println(jsonObject);
			String mapValue = jsonObject.get(mapKey).toString();
			System.out.println(mapValue);
			slackInfo.setDeleteMessage(mapValue);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Parses response for information about the content of previous messages
	 * 
	 * @param response
	 * @param key
	 * @return boolean
	 * @throws IOException
	 */
	public void parseJSONMessages(String response) throws IOException {
		JSONObject historyJSON = new JSONObject(response);
		JSONArray messagesJSONs = historyJSON.getJSONArray("messages");

		System.out.println("Reviewing Messages:");

		int count = 0;
		while (count < messagesJSONs.length()) {
			JSONObject indexObj = messagesJSONs.optJSONObject(count);
			String tsValue = indexObj.get("ts").toString();
			String textValue = indexObj.get("text").toString();
			String[] information = { tsValue, textValue };
			slackBot.botResponses(information);
			count++;
		}
	}

}