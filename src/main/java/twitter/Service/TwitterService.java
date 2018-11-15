package twitter.Service;

/**
 * Created by anshul.gupta on 11/15/18.
 */

import com.codahale.metrics.annotation.Timed;
import twitter.Configuration.LoadTwitterConfig;
import twitter.POJO.Configuration;
import twitter.POJO.TimeLineResponse;
import twitter.POJO.TweetResponse;
import twitter4j.*;
import twitter4j.auth.AccessToken;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/1.0/twitter")
@Produces(MediaType.APPLICATION_JSON)
public class TwitterService {
    private String tweet;
    Configuration loadTwitterConfig;
    ResponseList<Status> timeLineList;
    TimeLineResponse timeLineResponse = new TimeLineResponse();
    Twitter twitter;


    /*
        ** Creating a constructor and will initialize objects and class reference.
     */
    public TwitterService() {
        loadTwitterConfig = new LoadTwitterConfig().loadConfig();
        twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(loadTwitterConfig.getOAuth().getOAuthConsumerKey(), loadTwitterConfig.getOAuth().getOAuthConsumerSecret());
        AccessToken accessToken = new AccessToken(loadTwitterConfig.getOAuth().getOAuthAcessToken(), loadTwitterConfig.getOAuth().getOAuthAccessTokenSecret());
        twitter.setOAuthAccessToken(accessToken);
    }

    @GET
    @Timed
    @Path("/timeline")
    public TimeLineResponse getTimeLine() {
        try {
            timeLineList = twitter.getHomeTimeline();
            if (timeLineList.size() == 0) {
                throw new WebApplicationException("There are no messages in your timeline", Response.Status.NOT_FOUND);
            }
            timeLineResponse.setTimeLineResponse(timeLineList);
            timeLineResponse.setStatus(Response.Status.OK);

        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return timeLineResponse;
    }

    @POST
    @Timed
    @Path("/tweet")
    public TweetResponse tweet(@QueryParam("tweet") String tweet) {
        TweetResponse tweetResponse = new TweetResponse();
        try {
            Status status = twitter.updateStatus(tweet);
            tweetResponse.setStatus(Response.Status.CREATED);
            tweetResponse.setMessage("New tweet has been posted to twitter handler : " + status.getText());
        } catch (TwitterException e) {
            throw new WebApplicationException(e.getMessage(), e.getStatusCode());
        }
        return tweetResponse;
    }
}