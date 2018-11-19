package twitter.Service;

import lombok.extern.slf4j.Slf4j;
import twitter.Configuration.LoadTwitterConfig;
import twitter.POJO.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/**
 * Created by anshul.gupta on 11/16/18.
 */
@Slf4j
public class TwitterServiceAuthImpl {
    Configuration loadTwitterConfig;
    Twitter twitter;

    public Twitter OAuthImpl() {
        loadTwitterConfig = new LoadTwitterConfig().loadConfig();
        twitter = new TwitterFactory().getInstance();

        log.info("Inside OAuth Service 1. ConsumerKey " + loadTwitterConfig.getOAuth().getOAuthConsumerKey() + "consumer secret key " + loadTwitterConfig.getOAuth().getOAuthConsumerSecret());
        twitter.setOAuthConsumer(loadTwitterConfig.getOAuth().getOAuthConsumerKey(), loadTwitterConfig.getOAuth().getOAuthConsumerSecret());
        AccessToken accessToken = new AccessToken(loadTwitterConfig.getOAuth().getOAuthAcessToken(), loadTwitterConfig.getOAuth().getOAuthAccessTokenSecret());
        log.info(loadTwitterConfig.getOAuth().getOAuthAcessToken(), loadTwitterConfig.getOAuth().getOAuthAccessTokenSecret());

        twitter.setOAuthAccessToken(accessToken);
        return twitter;
    }
}
