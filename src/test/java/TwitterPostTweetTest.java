import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import twitter.POJO.ResponsePojo.TweetMessage.TweetResponse;
import twitter.Resources.TwitterResource;
import twitter.Service.TwitterService;
import twitter4j.TwitterException;

import javax.ws.rs.core.Response;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by anshul.gupta on 12/3/18.
 */
@Slf4j
public class TwitterPostTweetTest {
    final String tweet_message = "Tweeted";
    final String failed_tweet_message = "Failed Tweet";

    @Mock
    private TwitterService twitterService;

    @InjectMocks
    TwitterResource twitterResource = new TwitterResource(twitterService);

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSuccessTweet() throws TwitterException {
        TweetResponse tweetResponseMock = mock(TweetResponse.class);
        when(tweetResponseMock.getStatus()).thenReturn(Response.Status.CREATED);
        when(tweetResponseMock.getMessage()).thenReturn(tweet_message);

        when(twitterService.postTweetMessage(tweet_message)).thenReturn(tweetResponseMock);

        TweetResponse tweetResponse = twitterResource.tweet(tweet_message);
        assertThat(tweetResponse.getStatus()).isEqualByComparingTo(Response.Status.CREATED);
        assertThat(tweetResponse.getMessage()).isEqualTo(tweet_message);
    }

    @Test
    public void testFailedTweet() throws TwitterException {
        TweetResponse tweetResponseMock = mock(TweetResponse.class);
        when(tweetResponseMock.getStatus()).thenReturn(Response.Status.FORBIDDEN);
        when(tweetResponseMock.getMessage()).thenReturn(failed_tweet_message);
        when(twitterService.postTweetMessage(tweet_message)).thenThrow(new TwitterException(failed_tweet_message));

        TweetResponse tweetResponse = twitterResource.tweet(tweet_message);
        assertThat(tweetResponse.getMessage()).isEqualTo(failed_tweet_message);
        assertThat(tweetResponse.getStatus()).isEqualByComparingTo(Response.Status.FORBIDDEN);
    }
}
