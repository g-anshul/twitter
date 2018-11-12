package twitter;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by anshul.gupta on 11/9/18.
 */
public class PublishPost {

    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream("twitter.properties");
            properties.load(inputStream);
        } catch (IOException io) {
            io.printStackTrace();
        }

        try {
            Twitter twitter = new TwitterFactory().getInstance();

            twitter.setOAuthConsumer(properties.getProperty("consumerKeyStr"), properties.getProperty("consumerSecretStr"));
            AccessToken accessToken = new AccessToken(properties.getProperty("accessTokenStr"), properties.getProperty("accessTokenSecretStr"));

            twitter.setOAuthAccessToken(accessToken);
            Status status = twitter.updateStatus("I am posting tweet using Twitter4j");
            status.getText().equals("I am posting tweet using Twitter4j");

            System.out.println("Successfully updated the status in Twitter.");
        } catch (TwitterException te) {
            te.printStackTrace();
        }
    }
}
