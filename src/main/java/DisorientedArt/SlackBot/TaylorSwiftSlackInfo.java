package DisorientedArt.SlackBot;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class TaylorSwiftSlackInfo {
	
	private static String apiHost 	= "https://slack.com/api";
	private static String token		= "";
	private static String username 	= "t_swift";
	private static String botID 	= "B2AR86QCB";
	private static String channel	= "C1HGYEM6G";
	private static String as_user   = "false";
	private static String latest;
	private static String oldest;
	private static String inclusive;
	private static String count;
	private static String unread;
	private static String icon_url 	= 
			"https://avatars.slack-edge.com/2016-09-12/78914507077_c4f8d9a84d20239df28c_48.png";
	private static String deleteMessage;
	private static String lastMessage;
	
	public static String externalToken() throws IOException{
		String everything;
		BufferedReader br = new BufferedReader(new FileReader("userToken.txt"));
		try {
		    String line = br.readLine();
		    everything = line.toString();
		} finally {
		    br.close();
		}
		return everything;
	}
	public static String getApiHost() {
		return apiHost;
	}
	public static String getAS_User() {
		return as_user;
	}
	public static String getAS_UserURL() {
		return "&as_user=" + as_user;
	}
	public static String getBotID() {
		return botID;
	}
	public static String getBotIDURL() {
		return "&bot_id=" + botID;
	}
	public static String getChannel() {
		return channel;
	}
	public static String getChannelURL() {
		return "&channel=" + channel;
	}
	public static String getCount() {
		return count;
	}
	public static String getCountURL() {
		return "&count=" + count;
	}
	public static String getDeleteMessage() {
		return deleteMessage;
	}
	public static String getDeleteMessageURL() {
		return "&ts=" + deleteMessage;
	}
	public static String getIcon_url() {
		return icon_url;
	}
	public static String getIcon_urlURL() {
		return "&icon_url=" + icon_url;
	}
	public static String getInclusive() {
		return inclusive;
	}
	public static String getInclusiveURL() {
		return "&inclusive=" + inclusive;
	}
	public static String getLastMessage() {
		return lastMessage;
	}
	public static String getLatest() {
		return latest;
	}
	public static String getLatestURL() {
		return "&latest=" + latest;
	}
	public static String getOldest() {
		return oldest;
	}
	public static String getOldestURL() {
		return "&oldest=" + oldest;
	}
	public static String getToken() {
		return token;
	}
	public static String getTokenURL() {
		return "token=" + token;
	}
	public static String getUnread() {
		return unread;
	}
	public static String getUnreadURL() {
		return "&unread=" + unread;
	}
	public static String getUsername() {
		return username;
	}
	public static String getUsernameURL() {
		return "&username=" + username;
	}
	public static void setApiHost(String apiHost) {
		TaylorSwiftSlackInfo.apiHost = apiHost;
	}
	public static void setAS_User(String as_user) {
		TaylorSwiftSlackInfo.as_user = as_user;
	}
	public static void setBotID(String botID) {
		TaylorSwiftSlackInfo.botID = botID;
	}
	public static void setChannel(String channel) {
		TaylorSwiftSlackInfo.channel = channel;
	}
	public static void setCount(String count) {
		TaylorSwiftSlackInfo.count = count;
	}
	public static void setDeleteMessage(String deleteMessage) {
		TaylorSwiftSlackInfo.deleteMessage = deleteMessage;
	}
	public static void setIcon_url(String icon_url) {
		TaylorSwiftSlackInfo.icon_url = icon_url;
	}
	public static void setInclusive(String inclusive) {
		TaylorSwiftSlackInfo.inclusive = inclusive;
	}
	public static void setLastMessage(String lastMessage) {
		TaylorSwiftSlackInfo.lastMessage = lastMessage;
	}
	public static void setLatest(String latest) {
		TaylorSwiftSlackInfo.latest = latest;
	}
	public static void setOldest(String oldest) {
		TaylorSwiftSlackInfo.oldest = oldest;
	}
	public static void setToken(String token) {
		TaylorSwiftSlackInfo.token = token;
	}
	public static void setUnread(String unread) {
		TaylorSwiftSlackInfo.unread = unread;
	}
	public static void setUsername(String username) {
		TaylorSwiftSlackInfo.username = username;
	}
}