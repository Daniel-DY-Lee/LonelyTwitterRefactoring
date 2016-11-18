package ca.ualberta.cs.lonelytweet;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Jay on 2016-11-17.
 */
public class LonelyTweet implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String tweetBody;

	/* Made the Date field private
	*  Code before change:
	*  	protected Date tweetDate;
	* Reason: because only the current date is used Date does not have to be a protected variable.
	* 	It is better if it is set to private*/
	private Date tweetDate;

	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.writeObject(tweetDate);
		out.writeObject(tweetBody);
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		tweetDate = (Date) in.readObject();
		tweetBody = (String) in.readObject();
	}

	public boolean isValid() {

		/* Simplified if statement as per analyze -> inspect. Completed for lab 11 exercise
		*  Original code:
		*  if (tweetBody.trim().length() == 0
		*  		|| tweetBody.trim().length() > 10) {
		*  	return false;}
		*  return true;
		*  Reason: Code is a lot cleaner and more elegant */
		return !(tweetBody.trim().length() == 0
				|| tweetBody.trim().length() > 10);

	}

	public Date getTweetDate() {
		return tweetDate;
	}
}
