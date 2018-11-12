package twitter;

import twitter4j.*;
import twitter4j.auth.AccessToken;

import java.io.*;
import java.util.Properties;

/**
 * Created by anshul.gupta on 11/9/18.
 */
public class ReadTimeline {
    public static void main(String[] args) {

        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream("src/twitter.properties");
            properties.load(inputStream);
        } catch (IOException io) {
            io.printStackTrace();
        }

        try {
            Twitter twitter = new TwitterFactory().getInstance();
            twitter.setOAuthConsumer(properties.getProperty("consumerKeyStr"), properties.getProperty("consumerSecretStr"));
            AccessToken accessToken = new AccessToken(properties.getProperty("accessTokenStr"), properties.getProperty("accessTokenSecretStr"));

            twitter.setOAuthAccessToken(accessToken);
            ResponseList<Status> twitterList = twitter.getHomeTimeline();
            for (Status list : twitterList)
                System.out.println(list);

        } catch (TwitterException te) {
            te.printStackTrace();
        }
    }
}
