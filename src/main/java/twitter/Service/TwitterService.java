package twitter.Service;

import twitter.POJO.TimeLineResponse;
import twitter.POJO.TweetResponse;
import twitter4j.TwitterException;

/**
 * Created by anshul.gupta on 11/17/18.
 */
public interface TwitterService {
    TimeLineResponse getTimeLine() throws TwitterException;

    TweetResponse postTweetMessage(String tweet) throws TwitterException;
}
