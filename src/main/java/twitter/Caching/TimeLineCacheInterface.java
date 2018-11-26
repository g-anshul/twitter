package twitter.Caching;

import twitter.POJO.ResponsePojo.TimeLine.TimeLineResponse;

/**
 * Created by anshul.gupta on 11/26/18.
 */
public interface TimeLineCacheInterface {
    void cacheTimeLineResponse(TimeLineResponse timeLineResponse);
}
