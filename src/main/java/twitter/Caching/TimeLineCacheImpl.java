package twitter.Caching;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter.POJO.ResponsePojo.TimeLine.TimeLineResponse;

import java.util.concurrent.TimeUnit;

/**
 * Created by anshul.gupta on 11/26/18.
 */

@Slf4j
@Component
public class TimeLineCacheImpl implements TimeLineCacheInterface {
    @Autowired
    private RedisUtil redisUtilTimeLine;

    @Override
    public void cacheTimeLineResponse(TimeLineResponse timeLineResponse) {
        log.info(" !!! Calling cache interface in order to put data in redis !!! ");
        String date = String.valueOf(System.currentTimeMillis());
        RedisTableEnum.TableEnum redisTableEnum = RedisTableEnum.TableEnum.TABLE_TIMELINE;
        redisUtilTimeLine.putValue(String.valueOf(redisTableEnum), timeLineResponse.getTimeLineResponse());
        redisUtilTimeLine.setExpire(String.valueOf(redisTableEnum), 10, TimeUnit.SECONDS);
    }
}
