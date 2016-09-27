package Slack;

import java.util.Random;

public class Messages {
    
	/**
	 * Returns a random group of song lyrics
	 * @return
	 */
    public static String randomMessage(){
    	
    	String[] availableMessages = {
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
    	
    	Random randNum = new Random();
    	int i = randNum.nextInt(availableMessages.length);
    	String message = availableMessages[i];
    	return message;
    }
    
    /**
     * Returns an adjective for a giphy post
     * @return
     */
    public static String randomAdjective(){
    	
    	String[] adjective = {
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
    	
    	Random randNum = new Random();
    	int i = randNum.nextInt(adjective.length);
    	String message = adjective[i];
    	return message;
    }

}