package com.restapi.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by anshul.gupta on 11/14/18.
 */
@Setter
@Getter
public class UserKeys {
    private String OAuthConsumerKey;
    private String OAuthConsumerSecret;
    private String OAuthAcessToken;
    private String OAuthAccessTokenSecret;
}
