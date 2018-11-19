//import lombok.extern.slf4j.Slf4j;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import twitter.POJO.TimeLineResponse;
//import twitter.Service.TwitterService;
//import twitter.Service.TwitterServiceImpl;
//import twitter.Service.TwitterServiceInterface;
//import twitter4j.Status;
//import twitter4j.TwitterException;
//
//import javax.inject.Inject;
//import javax.ws.rs.core.Response;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
///**
// * Created by anshul.gupta on 11/16/18.
// */
//@Slf4j
//public class TwitterGetTimeLineTest {
//
//    @Mock
//    TwitterServiceInterface twitterServiceInterface;
//
//    @InjectMocks
//    TwitterServiceImpl twitterService = new TwitterServiceImpl();
//
//    @Before
//    public void before() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//
//    @Test
//    public void getTimeLineResponse() throws TwitterException {
//        log.info("Inside getTimeResponseTest");
//        TimeLineResponse timeLineResponseMock = mock(TimeLineResponse.class);
//        when(timeLineResponseMock.getStatus()).thenReturn(Response.Status.OK);
////        when(timeLineResponseMock.getTimeLineResponse()).thenReturn(new ArrayList<>(Arrays.asList("hello twitter", "how are you!!")));
//
//        when(twitterServiceInterface.getTimeLine()).thenReturn(timeLineResponseMock);
//
//        TimeLineResponse timeLineResponse = new TimeLineResponse();
//        timeLineResponse = twitterService.getTimeLine();
//
//        log.info("GettimeLine status : " + timeLineResponse.getStatus());
//        assertThat(timeLineResponse.getStatus()).isEqualByComparingTo(timeLineResponseMock.getStatus());
//
//    }
//
//}
