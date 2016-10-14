package DisorientedArt.SlackBot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SlackInfo {
	
	private static String apiHost 		= "https://slack.com/api";
	private static boolean as_user 		= false;
	private static String botID 		= "B2AR86QCB";	
	private static String channel 		= "C1HGYEM6G";	
	private static int count 			= 2;	
	private static String deleteMessage;
	private static String icon_url 		= "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSWkPhG_GW1M0nX1HWalRSE7BrkYS_cNzXZxd3J1EHdZ19u9iOO";
	private static int inclusive 		= 1;
	private static String latest;
	private static String lastMessage;
	private static int mpimAware 		= 1;
	private static String oldest;
	private static int simpleLatest 	= 0;
	private static int unread 			= 0;
	private static String username 		= "T_Swift";
	private static String token;

	
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
