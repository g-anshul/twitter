package twitter.POJO.ResponsePojo.TweetMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * Created by anshul.gupta on 11/15/18.
 */
public class TweetResponse {
    private String message;
    private Response.Status status;
    private User user;
    private Date createdAt;

    @JsonProperty
    public Response.Status getStatus() {
        return status;
    }

    @JsonProperty
    public void setStatus(Response.Status status) {
        this.status = status;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }

    @JsonProperty
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
