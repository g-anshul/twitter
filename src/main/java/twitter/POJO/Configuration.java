package twitter.POJO;

import lombok.Getter;
import lombok.Setter;
import twitter.POJO.RequestPojo.AuthConfig;

/**
 * Created by anshul.gupta on 11/15/18.
 */

@Getter
@Setter
public class Configuration {
    private AuthConfig OAuth;
    private ServerConfig server;
}
