package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Random;

import utility.ConsoleMessages;

public class Utilities {
	
	private String inputFile = "userToken.txt";
	private String outputFile = "filename.txt";

	/**
	 * Returns boolean based off current time and end time
	 * @return
	 */
	public Boolean continueRun() {
		Boolean run = true;
		if (LocalTime.now().isAfter(LocalTime.of(18, 00))) {
			run = false;
		}
		return run;
	}

	/**
	 * Gathers the token information for execution
	 * @return
	 * @throws IOException
	 */
	public String externalToken() throws IOException {
		String botToken;
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		try {
			botToken = br.readLine().toString();
		} 
		finally {
			br.close();
		}
		return botToken;
	}

	/**
	 * Gets the numerical value of the current day of the year 0-364
	 * @return
	 */
	public int getDate() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * Returns the current time of day
	 */
	public void printTime() {
		System.out.println(ConsoleMessages.consolemessage1 + LocalTime.now());
	}

	/**
	 * Returns a random number based on the length of the array
	 * @param array
	 * @return
	 */
	public int randomNumber(String[] array) {
		Random randNum = new Random();
		return randNum.nextInt(array.length);
	}

	/**
	 * Sets the mood of the bot based of the day of the year modulus value
	 */
	public void setMood() {
		int dayOfYear = getDate();
		if (dayOfYear % 5 == 0) {
			System.out.println(ConsoleMessages.consoleMessage2);
		} else if (dayOfYear % 4 == 0) {
			System.out.println(ConsoleMessages.consoleMessage3);
		} else if (dayOfYear % 3 == 0) {
			System.out.println(ConsoleMessages.consoleMessage4);
		}
	}
	
	/**
	 * Writes information to a file
	 * @param feed
	 * @throws Exception
	 */
	public void writeToFile(String feed) throws Exception{
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream(outputFile), "utf-8"))) {
			writer.write(feed);
			writer.close();
		}
		catch(Exception e){
			throw e;
		}
	}

}
