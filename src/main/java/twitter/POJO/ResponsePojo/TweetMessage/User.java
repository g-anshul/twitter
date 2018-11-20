package twitter.POJO.ResponsePojo.TweetMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by anshul.gupta on 11/19/18.
 */
public class User {
    private String name;
    private String profileImageUrl;

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
