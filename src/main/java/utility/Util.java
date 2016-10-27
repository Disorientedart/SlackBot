package utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Random;

public class Util 
{
	
    public void printTime()
    {
    	System.out.println("SlackBot Timeframe: " + LocalTime.now());
    }
    
    public int getDate()
    {
    	Calendar calendar = Calendar.getInstance();
    	int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR); 
    	return dayOfYear;
    }
    
    public void setMood()
    {
    	int dayOfYear = getDate();
    	if(dayOfYear %5 == 0){
    		System.out.println("Mood is set to happy");
    	}
    	else if (dayOfYear %4 == 0){
    		System.out.println("Mood is set to nuetral");
    	}
    	else if(dayOfYear %3 == 0){
    		System.out.println("Mood is set to sad");
    	}
    }

    
    public int randomNumber(String[] array)
    {
    	Random randNum = new Random();
    	int i = randNum.nextInt(array.length);
    	
    	return i;
    }
	
	public String externalToken() throws IOException
	{
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
	
	public Boolean continueRun()
	{
		Boolean run = true;
		
		if(LocalTime.now().isAfter(LocalTime.of(18, 00))){
			run = false;
		}
		return run;
	}


}
