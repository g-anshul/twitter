package twitter.POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.core.Response;

/**
 * Created by anshul.gupta on 11/15/18.
 */
public class TweetResponse {
    private String message;
    private Response.Status status;

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
}
