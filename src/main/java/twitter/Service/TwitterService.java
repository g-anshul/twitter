package twitter.Service;

/**
 * Created by anshul.gupta on 11/15/18.
 */

import com.codahale.metrics.annotation.Timed;
import twitter.POJO.AuthConfig;
import twitter.POJO.TimeLineResponse;
import twitter4j.*;
import twitter4j.auth.AccessToken;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;

@Path("/api/1.0/twitter")
public class TwitterService {

    public TwitterService() {
    }

    @GET
    @Timed
    @Path("/timeline")
    @Produces(MediaType.APPLICATION_JSON)
    public TimeLineResponse getTimeLine() {
        List<String> timeLineList = Collections.EMPTY_LIST;
        Twitter twitter = new TwitterFactory().getInstance();
        AuthConfig authConfig = new AuthConfig();

        twitter.setOAuthConsumer(authConfig.getOAuthConsumerKey(),authConfig.getOAuthConsumerKey());
        AccessToken accessToken = new AccessToken(authConfig.getOAuthAcessToken(),authConfig.getOAuthAccessTokenSecret());

        twitter.setOAuthAccessToken(accessToken);

        try {
           timeLineList = twitter.getHomeTimeline();
        } catch (TwitterException e) {
            e.printStackTrace();
        }


    }
}