package twitter.POJO.RequestPojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by anshul.gupta on 11/15/18.
 */

@Getter
@Setter
public class AuthConfig {
    private String OAuthConsumerKey;
    private String OAuthConsumerSecret;
    private String OAuthAcessToken;
    private String OAuthAccessTokenSecret;
}
