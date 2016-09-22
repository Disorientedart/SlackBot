package Slack;

import java.util.Random;

public class Messages {
    
    public static String randomMessage(){
    	String message;
    	
    	String[] availMessages = {
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
    	
    	Random rn = new Random();
    	int i = rn.nextInt(availMessages.length);
    	message = availMessages[i];
    	return message;
    }

}