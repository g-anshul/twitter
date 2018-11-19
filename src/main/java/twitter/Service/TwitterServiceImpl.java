package twitter.Service;

import lombok.extern.slf4j.Slf4j;
import twitter.POJO.ResponsePojo.TimeLine.TimeLineResponse;
import twitter.POJO.ResponsePojo.TweetMessage.TweetResponse;
import twitter.POJO.ResponsePojo.TweetMessage.User;
import twitter4j.*;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by anshul.gupta on 11/17/18.
 */
@Slf4j
public class TwitterServiceImpl implements TwitterService {

    Twitter twitter;

    private static TwitterServiceImpl twitterServiceImpl;

    private TwitterServiceImpl(){
        TwitterServiceAuthImpl twitterServiceAuth = new TwitterServiceAuthImpl();
        log.info("Calling OAuth Service for getting token");
        twitter = twitterServiceAuth.OAuthImpl();
    }

    public static TwitterServiceImpl getInstance() {
        if (twitterServiceImpl != null) {
            return twitterServiceImpl;
        }
        else {
           return new TwitterServiceImpl();
        }
    }
    @Override
    public TimeLineResponse getTimeLine() throws TwitterException {
        List<String> timeLineList;
        TimeLineResponse timeLineResponse = new TimeLineResponse();
        try {
            timeLineList = twitter.getHomeTimeline().stream().map(Status::getText).collect(Collectors.toList());
            timeLineResponse.setTimeLineResponse(timeLineList);
            timeLineResponse.setStatus(Response.Status.OK);
        } catch (TwitterException e) {
            log.error("Unable to get time data :: " + e.getErrorMessage());
            throw new TwitterException(e);
        }
        return timeLineResponse;
    }

    @Override
    public TweetResponse postTweetMessage(String tweet) throws TwitterException {
        TweetResponse tweetResponse = new TweetResponse();
        User user = new User();
        try {
            Status status = twitter.updateStatus(tweet);
            tweetResponse.setStatus(Response.Status.CREATED);
            tweetResponse.setMessage("New tweet has been posted to twitter handler : " + status.getText());
            tweetResponse.setCreatedAt(status.getCreatedAt());
            user.setName(status.getUser().getName());
            user.setProfileImageUrl(status.getUser().getProfileImageURL());
            tweetResponse.setUser(user);
        } catch (TwitterException e) {
            log.error("Unable to tweet :: " + e.getErrorMessage());
            throw new TwitterException(e);
        }

        return tweetResponse;
    }
}
