package twitter.Service;

import twitter.POJO.ResponsePojo.TimeLine.TimeLineResponse;
import twitter.POJO.ResponsePojo.TweetMessage.TweetResponse;
import twitter4j.TwitterException;

/**
 * Created by anshul.gupta on 11/17/18.
 */
public interface TwitterService {
    TimeLineResponse getTimeLine() throws TwitterException;

    TweetResponse postTweetMessage(String tweet) throws TwitterException;
}
