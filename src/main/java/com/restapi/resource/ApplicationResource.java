package com.restapi.resource;

/**
 * Created by anshul.gupta on 11/13/18.
 */

import com.restapi.pojo.TwitterTweetResponse;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/api/1.0/twitter")
@Produces(MediaType.APPLICATION_JSON)
public class ApplicationResource {

}


@POST
@Path("/tweet")
public TwitterTweetResponse postTweet() {
    Twitter twitter = new TwitterFactory().getInstance();

}

