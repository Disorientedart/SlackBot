package slackBot;

import java.util.ArrayList;

public class SlackInfo {

	private boolean as_user;
	private ArrayList<String> botHistory;
	private String botID;
	private String channel;
	private int count = 1;
	private String deleteMessage;
	private String icon_url;
	private int inclusive = 1;
	private String lastMessage;
	private String latest;
	private int mpimAware = 1;
	private String oldest;
	private int simpleLatest = 0;
	private String token;
	private int unread = 0;
	private String username;

	public boolean getAS_User() {
		return as_user;
	}

	public String getAS_UserURL() {
		return "&as_user=" + as_user;
	}

	public ArrayList<String> getBotHistory() {
		return botHistory;
	}

	public String getBotID() {
		return botID;
	}

	public String getBotIDURL() {
		return "&bot_id=" + botID;
	}

	public String getChannel() {
		return channel;
	}

	public String getChannelURL() {
		return "&channel=" + channel;
	}

	public int getCount() {
		return count;
	}

	public String getCountURL() {
		return "&count=" + count;
	}

	public String getDeleteMessage() {
		return deleteMessage;
	}

	public String getDeleteMessageURL() {
		return "&ts=" + deleteMessage;
	}

	public String getIcon_url() {
		return icon_url;
	}

	public String getIcon_urlURL() {
		return "&icon_url=" + icon_url;
	}

	public int getInclusive() {
		return inclusive;
	}

	public String getInclusiveURL() {
		return "&inclusive=" + inclusive;
	}

	public String getLastMessage() {
		return lastMessage;
	}

	public String getLatest() {
		return latest;
	}

	public String getLatestURL() {
		return "&latest=" + latest;
	}

	public int getMPIMAware() {
		return mpimAware;
	}

	public String getMPIMAwareURL() {
		return "&mpim_aware=" + mpimAware;
	}

	public String getOldest() {
		return oldest;
	}

	public String getOldestURL() {
		return "&oldest=" + oldest;
	}

	public int getSimpleLatest() {
		return simpleLatest;
	}

	public String getSimpleLatestURL() {
		return "&simple_latest=" + simpleLatest;
	}

	public String getToken() {
		return token;
	}

	public String getTokenURL() {
		return "token=" + token;
	}

	public int getUnread() {
		return unread;
	}

	public String getUnreadURL() {
		return "&unread=" + unread;
	}

	public String getUsername() {
		return username;
	}

	public String getUsernameURL() {
		return "&username=" + username;
	}

	public void setAS_User(boolean value) {
		as_user = value;
	}

	public void setBotHistory(String timeStamp) {
		botHistory.add(timeStamp);
	}

	public void setBotID(String value) {
		botID = value;
	}

	public void setChannel(String value) {
		channel = value;
	}

	public void setCount(int value) {
		count = value;
	}

	public void setDeleteMessage(String value) {
		deleteMessage = value;
	}

	public void setIcon_url(String value) {
		icon_url = value;
	}

	public void setInclusive(int value) {
		inclusive = value;
	}

	public void setLastMessage(String value) {
		lastMessage = value;
	}

	public void setLatest(String value) {
		latest = value;
	}

	public void setMPIMAware(int value) {
		mpimAware = value;
	}

	public void setOldest(String value) {
		oldest = value;
	}

	public void setSimpleLatest(int value) {
		simpleLatest = value;
	}

	public void setToken(String value) {
		token = value;
	}

	public void setUnread(int value) {
		unread = value;
	}

	public void setUsername(String value) {
		username = value;
	}

}
