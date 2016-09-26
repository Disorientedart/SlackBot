package DisorientedArt.SlackBot;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class SlackInfo {
	
	private static String apiHost 		= "https://slack.com/api";
	private static boolean as_user 		= false;
	private static String botID 		= "B2AR86QCB";	
	private static String channel 		= "C1HGYEM6G";	
	private static int count 			= 2;	
	private static String deleteMessage;
	private static String icon_url 		= "data:image/jpeg;base64,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";
	private static int inclusive 		= 1;
	private static String latest;
	private static String lastMessage;
	private static int mpimAware 		= 1;
	private static String oldest;
	private static int simpleLatest 	= 0;
	private static int unread 			= 0;
	private static String username 		= "t_swift";
	private static String token 		= "";

	
	public static String externalToken() throws IOException{
		String botToken;
		BufferedReader br = new BufferedReader(new FileReader("userToken.txt"));
		try {
		    String line = br.readLine();
		    botToken = line.toString();
		}
		finally {
		    br.close();
		}
		return botToken;
	}
	
	public static String getApiHost() {
		return apiHost;
	}
	public static void setApiHost(String apiHost) {
		SlackInfo.apiHost = apiHost;
	}
	
	public static boolean getAS_User() {
		return as_user;
	}
	public static String getAS_UserURL() {
		return "&as_user=" + as_user;
	}
	public static void setAS_User(boolean as_user) {
		SlackInfo.as_user = as_user;
	}

	public static String getBotID() {
		return botID;
	}
	public static String getBotIDURL() {
		return "&bot_id=" + botID;
	}
	public static void setBotID(String botID) {
		SlackInfo.botID = botID;
	}

	public static String getChannel() {
		return channel;
	}
	public static String getChannelURL() {
		return "&channel=" + channel;
	}
	public static void setChannel(String channel) {
		SlackInfo.channel = channel;
	}

	public static int getCount() {
		return count;
	}
	public static String getCountURL() {
		return "&count=" + count;
	}
	public static void setCount(int count) {
		SlackInfo.count = count;
	}

	public static String getDeleteMessage() {
		return deleteMessage;
	}
	public static String getDeleteMessageURL() {
		return "&ts=" + deleteMessage;
	}
	public static void setDeleteMessage(String deleteMessage) {
		SlackInfo.deleteMessage = deleteMessage;
	}

	public static String getIcon_url() {
		return icon_url;
	}
	public static String getIcon_urlURL() {
		return "&icon_url=" + icon_url;
	}
	public static void setIcon_url(String icon_url) {
		SlackInfo.icon_url = icon_url;
	}

	public static int getInclusive() {
		return inclusive;
	}
	public static String getInclusiveURL() {
		return "&inclusive=" + inclusive;
	}
	public static void setInclusive(int inclusive) {
		SlackInfo.inclusive = inclusive;
	}
	
	public static String getLatest() {
		return latest;
	}
	public static String getLatestURL() {
		return "&latest=" + latest;
	}
	public static void setLatest(String latest) {
		SlackInfo.latest = latest;
	}

	public static String getLastMessage() {
		return lastMessage;
	}
	public static void setLastMessage(String lastMessage) {
		SlackInfo.lastMessage = lastMessage;
	}

	public static int getMPIMAware() {
		return mpimAware;
	}
	public static String getMPIMAwareURL() {
		return "&mpim_aware=" + mpimAware;
	}
	public static void setMPIMAware(int mpimAware) {
		SlackInfo.mpimAware = mpimAware;
	}

	public static String getOldest() {
		return oldest;
	}
	public static String getOldestURL() {
		return "&oldest=" + oldest;
	}
	public static void setOldest(String oldest) {
		SlackInfo.oldest = oldest;
	}

	public static int getSimpleLatest() {
		return simpleLatest;
	}
	public static String getSimpleLatestURL() {
		return "&simple_latest=" + simpleLatest;
	}
	public static void setSimpleLatest(int simpleLatest) {
		SlackInfo.simpleLatest = simpleLatest;
	}
	
	public static int getUnread() {
		return unread;
	}
	public static String getUnreadURL() {
		return "&unread=" + unread;
	}
	public static void setUnread(int unread) {
		SlackInfo.unread = unread;
	}

	public static String getUsername() {
		return username;
	}
	public static String getUsernameURL() {
		return "&username=" + username;
	}
	public static void setUsername(String username) {
		SlackInfo.username = username;
	}

	public static String getToken() {
		return token;
	}
	public static String getTokenURL() {
		return "token=" + token;
	}
	public static void setToken(String token) {
		SlackInfo.token = token;
	}

}
