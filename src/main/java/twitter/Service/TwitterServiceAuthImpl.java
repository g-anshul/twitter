package twitter.Service;

import twitter.Configuration.LoadTwitterConfig;
import twitter.POJO.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/**
 * Created by anshul.gupta on 11/16/18.
 */
public class TwitterServiceAuthImpl {
    Configuration loadTwitterConfig;
    Twitter twitter;

    public Twitter OAuthImpl(){
        loadTwitterConfig = new LoadTwitterConfig().loadConfig();
        twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(loadTwitterConfig.getOAuth().getOAuthConsumerKey(), loadTwitterConfig.getOAuth().getOAuthConsumerSecret());
        AccessToken accessToken = new AccessToken(loadTwitterConfig.getOAuth().getOAuthAcessToken(), loadTwitterConfig.getOAuth().getOAuthAccessTokenSecret());
        twitter.setOAuthAccessToken(accessToken);
        return twitter;
    }
}
