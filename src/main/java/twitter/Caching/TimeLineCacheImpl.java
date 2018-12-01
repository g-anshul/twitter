package twitter.Caching;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter.POJO.ResponsePojo.TimeLine.TimeLineResponse;

import java.io.IOException;
import java.io.StringWriter;
import java.util.concurrent.TimeUnit;

/**
 * Created by anshul.gupta on 11/26/18.
 */

@Slf4j
@Component
public class TimeLineCacheImpl implements TimeLineCacheInterface {
    int defaultTimeout = 1;

    @Autowired
    private RedisUtil redisUtilTimeLine;

    @Override
    public void cacheTimeLineResponse(TimeLineResponse timeLineResponse) {
        Gson gson = new Gson();
        log.info(" !!! Calling cache interface in order to put data in redis !!! ");
        String date = String.valueOf(System.currentTimeMillis());
        RedisTableEnum.TableEnum redisTableEnum = RedisTableEnum.TableEnum.TABLE_TIMELINE;
        redisUtilTimeLine.putValue(String.valueOf(redisTableEnum), gson.toJson(timeLineResponse));
        redisUtilTimeLine.setExpire(String.valueOf(redisTableEnum), defaultTimeout, TimeUnit.MINUTES);
    }
}
