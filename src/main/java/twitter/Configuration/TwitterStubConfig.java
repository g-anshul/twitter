package twitter.Configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by anshul.gupta on 11/15/18.
 */
public class TwitterStubConfig extends Configuration {

    @NotEmpty
    private String tweet;

    @JsonProperty
    public String getTweet() {
        return tweet;
    }

    @JsonProperty
    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
}