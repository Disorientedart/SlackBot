package slackBot;


public class SlackInfo {
	
	private boolean as_user;
	private String botID;	
	private String channel;	
	private int count 			= 2;	
	private String deleteMessage;
	private String icon_url;
	private int inclusive 		= 1;
	private String latest;
	private String lastMessage;
	private int mpimAware 		= 1;
	private String oldest;
	private int simpleLatest 	= 0;
	private int unread 			= 0;
	private String username;
	private String token;

	
	public boolean getAS_User() {
		return as_user;
	}
	public String getAS_UserURL() {
		return "&as_user=" + as_user;
	}
	public void setAS_User(boolean value) {
		as_user = value;
	}

	public String getBotID() {
		return botID;
	}
	public String getBotIDURL() {
		return "&bot_id=" + botID;
	}
	public void setBotID(String value) {
		botID = value;
	}

	public String getChannel() {
		return channel;
	}
	public String getChannelURL() {
		return "&channel=" + channel;
	}
	public void setChannel(String value) {
		channel = value;
	}

	public int getCount() {
		return count;
	}
	public String getCountURL() {
		return "&count=" + count;
	}
	public void setCount(int value) {
		count = value;
	}

	public String getDeleteMessage() {
		return deleteMessage;
	}
	public String getDeleteMessageURL() {
		return "&ts=" + deleteMessage;
	}
	public void setDeleteMessage(String value) {
		deleteMessage = value;
	}

	public String getIcon_url() {
		return icon_url;
	}
	public String getIcon_urlURL() {
		return "&icon_url=" + icon_url;
	}
	public void setIcon_url(String value) {
		icon_url = value;
	}

	public int getInclusive() {
		return inclusive;
	}
	public String getInclusiveURL() {
		return "&inclusive=" + inclusive;
	}
	public void setInclusive(int value) {
		inclusive = value;
	}
	
	public String getLatest() {
		return latest;
	}
	public String getLatestURL() {
		return "&latest=" + latest;
	}
	public void setLatest(String value) {
		latest = value;
	}

	public String getLastMessage() {
		return lastMessage;
	}
	public void setLastMessage(String value) {
		lastMessage = value;
	}

	public int getMPIMAware() {
		return mpimAware;
	}
	public String getMPIMAwareURL() {
		return "&mpim_aware=" + mpimAware;
	}
	public void setMPIMAware(int value) {
		mpimAware = value;
	}

	public String getOldest() {
		return oldest;
	}
	public String getOldestURL() {
		return "&oldest=" + oldest;
	}
	public void setOldest(String value) {
		oldest = value;
	}

	public int getSimpleLatest() {
		return simpleLatest;
	}
	public String getSimpleLatestURL() {
		return "&simple_latest=" + simpleLatest;
	}
	public void setSimpleLatest(int value) {
		simpleLatest = value;
	}
	
	public int getUnread() {
		return unread;
	}
	public String getUnreadURL() {
		return "&unread=" + unread;
	}
	public void setUnread(int value) {
		unread = value;
	}

	public String getUsername() {
		return username;
	}
	public String getUsernameURL() {
		return "&username=" + username;
	}
	public void setUsername(String value) {
		username = value;
	}

	public String getToken() {
		return token;
	}
	public String getTokenURL() {
		return "token=" + token;
	}
	public void setToken(String value) {
		token = value;
	}

}
