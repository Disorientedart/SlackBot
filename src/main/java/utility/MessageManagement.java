package utility;

import java.awt.List;

public class MessageManagement {

	public String[] channelHistory;
	List channelHistory1 = new List();

	/**
	 * Delete Messages from the channel history
	 */
	public static void deleteMessages(int value) {
		// Build a list of slackbot information
		// Modify the delete message call to delete a number of messages in a loop

	}
	
	/**
	 * Add the timestamp of a more recent message
	 * @param item
	 */
	public void addHistory(String item){
		channelHistory1.add(item);
	}

}
