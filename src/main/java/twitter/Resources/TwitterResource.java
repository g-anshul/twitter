package twitter.Resources;

/**
 * Created by anshul.gupta on 11/15/18.
 */

import com.codahale.metrics.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter.POJO.ResponsePojo.TimeLine.TimeLineResponse;
import twitter.POJO.ResponsePojo.TweetMessage.TweetResponse;
import twitter.Service.TwitterService;
import twitter4j.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
@Path("/api/1.0/twitter")
@Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
@Component
public class TwitterResource {

    @Autowired
    private TwitterService twitterService;

    @GET
    @Timed
    @Path("/timeline")
    public TimeLineResponse getTimeLine(@DefaultValue("") @QueryParam("messageFilter") String messageFilter ) {
        TimeLineResponse timeLineResponse = new TimeLineResponse();
        try {
            timeLineResponse = twitterService.getTimeLine(messageFilter);
            if (timeLineResponse.getStatus().equals(Response.Status.OK)) {
                log.info("Got timeLine Response: " + timeLineResponse.getStatus());
                return timeLineResponse;
            }
        } catch (TwitterException e) {
            log.error("Error getting timeline data : " + e.getErrorMessage());
        }
        return timeLineResponse;
    }

    @POST
    @Timed
    @Path("/tweet")
    public TweetResponse tweet(@DefaultValue("") @QueryParam("tweet") String tweet) {
        TweetResponse tweetResponse = new TweetResponse();
        try {
            tweetResponse = twitterService.postTweetMessage(tweet);
            if (tweetResponse.getStatus().equals(Response.Status.CREATED)) {
                log.info("Tweeted on twitter handler " + tweetResponse.getStatus().getStatusCode());
            }
        } catch (TwitterException e) {
            log.error(e.getMessage());
            tweetResponse.setMessage(e.getMessage());
        }
        return tweetResponse;
    }
}