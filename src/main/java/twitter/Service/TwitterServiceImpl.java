package twitter.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
@Service
public class TwitterServiceImpl implements TwitterService {

    private Twitter twitter;

    @Autowired
    TwitterServiceAuthImpl twitterServiceAuthImpl;

    @Override
    public TimeLineResponse getTimeLine(String messageFilter) throws TwitterException {
        twitter = twitterServiceAuthImpl.OAuthImpl();
        List<String> timeLineList;
        TimeLineResponse timeLineResponse = new TimeLineResponse();
        try {
            timeLineList = twitter.getHomeTimeline().stream().map(Status::getText).filter(text -> text.contains(messageFilter)).collect(Collectors.toList());
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
        twitter = twitterServiceAuthImpl.OAuthImpl();
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
