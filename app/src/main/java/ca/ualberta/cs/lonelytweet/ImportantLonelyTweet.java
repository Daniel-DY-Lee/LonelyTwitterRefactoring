package ca.ualberta.cs.lonelytweet;

import android.util.Log;

import java.util.Date;

public class ImportantLonelyTweet extends LonelyTweet {

    public ImportantLonelyTweet() {
	}

	public ImportantLonelyTweet(String text, Date date) {
	  	this.tweetBody = text;
	}

	@Override
	public String toString() {
		String logTweet = getTweetDate() + " | " + getTweetBody();
		Log.i("Is an important tweet:", logTweet);
		return logTweet;
	}

	public String getTweetBody() {
		return tweetBody.toUpperCase();
	}
}