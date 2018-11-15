package twitter.POJO;

import com.fasterxml.jackson.annotation.JsonProperty;
import twitter4j.ResponseList;
import twitter4j.Status;

import javax.ws.rs.core.Response;

/**
 * Created by anshul.gupta on 11/15/18.
 */
public class TimeLineResponse {
    private Response.Status status;
    private ResponseList<Status> timeLineResponse;

    @JsonProperty
    public Response.Status getStatus() {
        return status;
    }

    @JsonProperty
    public void setStatus(Response.Status status) {
        this.status = status;
    }

    @JsonProperty
    public ResponseList<Status> getTimeLineResponse() {
        return timeLineResponse;
    }

    @JsonProperty
    public void setTimeLineResponse(ResponseList<Status> timeLineResponse) {
        this.timeLineResponse = timeLineResponse;
    }

}
