package com.restapi.resource;

/**
 * Created by anshul.gupta on 11/13/18.
 */

import com.codahale.metrics.annotation.Timed;
import com.restapi.config.TwitterUserAccountConfiguration;
import com.restapi.pojo.TimeLineResponse;
import com.restapi.pojo.TwitterTweetResponse;
import twitter4j.*;
import twitter4j.auth.AccessToken;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;


@Path("/api/1.0/twitter")
@Produces(MediaType.APPLICATION_JSON)
public class ApplicationResource {
    private String message;

    public ApplicationResource() {
//        this.message = message;
    }

//@POST
//@Path("/tweet")
//public TwitterTweetResponse postTweet() {
//    Twitter twitter = new TwitterFactory().getInstance();
//
//}

    @GET
    @Timed
    @Path("/timeline")
    public TimeLineResponse getTimeLine() {
        TimeLineResponse timeLineResponse = new TimeLineResponse();
        ResponseList<Status> timeLineList = (ResponseList<Status>) Collections.EMPTY_LIST;

        timeLineResponse.setTimeLineResponse(timeLineList);

        TwitterUserAccountConfiguration config = new TwitterUserAccountConfiguration();

        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(config.getUserKeys().getOAuthConsumerKey(), config.getUserKeys().getOAuthConsumerSecret());

        AccessToken accessToken = new AccessToken(config.getUserKeys().getOAuthAcessToken(), config.getUserKeys().getOAuthAccessTokenSecret());

        twitter.setOAuthAccessToken(accessToken);
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

}