import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import twitter.POJO.ResponsePojo.TimeLine.TimeLineResponse;
import twitter.POJO.ResponsePojo.TimeLine.TimeLineSet;
import twitter.Resources.TwitterResource;
import twitter.Service.TwitterService;
import twitter4j.TwitterException;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by anshul.gupta on 11/16/18.
 */
@Slf4j
public class TwitterGetTimeLineTest {

    @Mock
    private TwitterService twitterService;

    @InjectMocks
    TwitterResource twitterResource = new TwitterResource(twitterService);

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSuccessTimeLine() throws TwitterException {
        List<TimeLineSet> timeLineSets = new ArrayList<>();
        timeLineSets.add(new TimeLineSet(new Date(1234567), (long) 1234567, "timeLineProfileImageUrl", "url", "timeLineResponse"));

        TimeLineResponse timeLineResponseMock = mock(TimeLineResponse.class);

        when(timeLineResponseMock.getStatus()).thenReturn(Response.Status.OK);
        when(timeLineResponseMock.getTimeLineSet()).thenReturn((List<TimeLineSet>) timeLineSets);
        when(twitterService.getTimeLine(" ")).thenReturn(timeLineResponseMock);

        TimeLineResponse timeLineResponse = twitterResource.getTimeLine(" ");
        List<TimeLineSet> expected = timeLineResponse.getTimeLineSet();

        assertThat(timeLineResponse.getStatus()).isEqualByComparingTo(Response.Status.OK);
        assertThat((expected.get(0).getUrl()).equalsIgnoreCase("url"));
        assertThat((expected.get(0).getTimeLineResponseId()).equals((long) 1234567));
        assertThat((expected.get(0).getTimeLineProfileImageUrl()).equalsIgnoreCase("timeLineProfileImageUrl"));
    }

    @Test
    public void testFailureTimeLine() throws TwitterException {
        TimeLineResponse timeLineResponseMock = mock(TimeLineResponse.class);
        when(timeLineResponseMock.getStatus()).thenReturn(Response.Status.BAD_REQUEST);
        when(timeLineResponseMock.getTimeLineSet()).thenReturn(Collections.EMPTY_LIST);
        when(twitterService.getTimeLine(" ")).thenThrow(new TwitterException(" "));

        TimeLineResponse timeLineResponse = twitterResource.getTimeLine(" ");

        assertThat(timeLineResponse.getStatus()).isEqualByComparingTo(Response.Status.BAD_REQUEST);
        assertThat((timeLineResponse.getTimeLineSet()).isEmpty());
    }
}
