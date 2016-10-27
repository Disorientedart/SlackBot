package personalities;

import java.io.IOException;

import slackBot.SlackInfo;
import utility.APICalls;
import utility.JSON;
import utility.Util;

public class TaylorBot implements ISlackBot{

	SlackInfo slackInfo = new SlackInfo();
	APICalls apiCalls = new APICalls();
	Util utility;
	
	private static boolean as_user 		= false;
	private static String botID 		= "B2AR86QCB";	
	private static String channel 		= "C1HGYEM6G";	
	private static String username 		= "T_S";
	
	public void setPersonality()
	{
		slackInfo.setAS_User(as_user);
		slackInfo.setBotID(botID);
		slackInfo.setChannel(channel);
		slackInfo.setUsername(username);
	}

	/**
	 * Returns a random group of song lyrics
	 * @return
	 */
    public String randomMessage()
    {
    	String[] availableMessages = 
    		{
    			"Nice to meet you, where you been?\nI could show you incredible things\nMagic, madness, heaven, sin",
    			"You made a really deep cut\nAnd, baby, now we got bad blood",
    			"/'Cause, baby, now we got bad blood\nYou know it used to be mad love",
    			"I go on too many dates\nBut I can't make them stay\nAt least that's what people say, mmm-mmm",
    			"'Cause the players gonna play, play, play, play, play\nAnd the haters gonna hate, hate, hate, hate, hate",
    			"Do you remember the day\nI leaned up against your car\nAnd it started rolling down the street",
    			"Blond hair to the floor\nYou shorties never thought I dreamed about rapping hardcore",
    			"It feels like a perfect night to dress up like hipsters\nAnd make fun of our exes, uh uh, uh uh",
    			"It feels like one of those nights,\nWe ditch the whole scene"
    		};
    	
    	return availableMessages[utility.randomNumber(availableMessages)];
    }
    
    /**
     * Returns an adjective for a giphy post
     * @return
     */
    public String randomAdjective()
    {
    	String[] adjectives = 
    		{
    			"other", "new", "good",	"high",
    			"old", "great", "big", "American",
    			"small", "large", "national", "young",
    			"different", "black", "long", "little",
    			"important", "political", "bad", "white",
    			"real", "best", "right", "social",
    			"only", "public", "sure", "low",
    			"early", "able", "late", "hard",
    			"major", "better", "strong", "international",
    			"full", "special", "easy", "recent",
    			"personal", "open", "red", "difficult",
    			"available", "short", "single", "medical",
    			"current", "wrong", "private", "past",
    			"fine", "common", "poor", "natural",
    			"significant", "hot", "happy", "serious",
    			"ready", "simple", "general", "environmental",
    			"financial", "blue", "dark", "various",
    			"entire", "close", "cold", "final",
    			"green", "nice", "huge", "popular",
    			"traditional", "cultural"
    		};
    	
    	return adjectives[utility.randomNumber(adjectives)];
    }
    
    public String randomImage()
    {
    	String[] availableImage = 
    		{
    			"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQv8cWiKHOSJqT8zB5qT0JHC_nhEJ1d7EBBZ4BLVhTb6nA2cNVgag",
    			"https://celebdial.s3.amazonaws.com/celeb_thumb/6e72c92dade7697c6c48a4e07831af5a.png",
    			"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqbQ0XskYqw-CLlSs0fpq7ivq4b9rpm5GvP0rtBxbU8WzQU8wf",
    			"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcT5GDIuM8suR-lI0wrsW3ljcbvPHdFDsmP-d8kSXkaLkmHXXeM3TA",
    			"https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSWkPhG_GW1M0nX1HWalRSE7BrkYS_cNzXZxd3J1EHdZ19u9iOO",
    			"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTIByKCjei5RYuTxGIwsSIWn1ODLrBFaVFIbljuPCUdyp9Yuw0x"			
    		};
    	
    	return availableImage[utility.randomNumber(availableImage)];
    }

	public void historyResponse(String historyLogs) throws IOException 
	{
		JSON json = new JSON();
		json.parseJSONMessages(historyLogs);
	}
	
	public void botResponses(String[] messages) throws IOException
	{
		System.out.println(messages[0] + " Message: " + messages[1]);
		if(messages[1].toLowerCase().contains("taylor") && !messages[0].equals(slackInfo.getLastMessage())){
			slackInfo.setLastMessage(messages[0]);
			apiCalls.postMessage(randomMessage());
		}
		else if(messages[1].toLowerCase().contains("swift") && !messages[0].equals(slackInfo.getLastMessage())){
			slackInfo.setLastMessage(messages[0]);
			apiCalls.postMessage(randomMessage());
		}
		else if(messages[1].toLowerCase().contains("kanye") && !messages[0].equals(slackInfo.getLastMessage())){
			slackInfo.setLastMessage(messages[0]);
			apiCalls.postMessage(":(");
		}
	}

}
