package com.restapi.config;

import com.restapi.pojo.TweetMessage;
import com.restapi.pojo.UserKeys;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by anshul.gupta on 11/15/18.
 */
@Setter
@Getter
public class CommonConfig {
    UserKeys userKeys;
    TweetMessage tweetMessage;
}
