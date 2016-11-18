package ca.ualberta.cs.lonelytwitter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import ca.ualberta.cs.lonelytweet.LonelyTweet;

public class TweetsFileManager {

	/*Made the FILE_SAV string final as per analyze -> inspect. Completed for Lab 11 exercise
	* Code before change:
	* 	private static final String FILE_SAV = "file.sav";
	* Reason: so that other classes cannot access the file name */

	private static final String FILE_SAV = "file.sav";

	/* Made the private variable context final
	*  Code before change:
	*  	private Context ctx;
	* Reason: so that the Context cannot unexpectedly change and cause unwanted behaviour */

	private final Context ctx;

	public TweetsFileManager(Context ctx) {
		this.ctx = ctx;
	}

	@SuppressWarnings("unchecked")
	public List<LonelyTweet> loadTweets() {
		List<LonelyTweet> tweets = new ArrayList<LonelyTweet>();

		try {
			FileInputStream fis = ctx.openFileInput("file.sav");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Object o = ois.readObject();

			if (o instanceof ArrayList) {
				tweets = (ArrayList<LonelyTweet>) o;
			} else {
				Log.i("LonelyTwitter", "Error casting");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return tweets;
	}

	public void saveTweets(List<LonelyTweet> tweets) {
		try {
			FileOutputStream fos = ctx.openFileOutput(FILE_SAV, 0);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(tweets);

			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}