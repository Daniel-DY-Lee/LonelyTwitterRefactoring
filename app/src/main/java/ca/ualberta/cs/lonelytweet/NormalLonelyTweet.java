package ca.ualberta.cs.lonelytweet;

import java.util.Date;

public class NormalLonelyTweet extends LonelyTweet {

    public NormalLonelyTweet() {
	}

	/* Deleted a redundant declaration as per analyze -> inspect. Done for Lab 11 exercise
	*  Deleted parameter "Date date" from NormalLonelyTweet class
	*  Reason: After Lab 11 it is no longer necessary to have a "date" parameter. The date for all
	*  	Tweets are the current date and are incorporated into the tweetBody*/
	public NormalLonelyTweet(String text) {
		this.tweetBody = text;
	}

    @Override
	public String toString() {
		return getTweetDate() + " | " + getTweetBody();
	}

	public String getTweetBody() {
		return tweetBody;
	}
}