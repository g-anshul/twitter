package twitter.POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by anshul.gupta on 11/15/18.
 */
public class TimeLineResponse {
    private Response.Status status;
    private List<String> timeLineResponse;

    @JsonProperty
    public Response.Status getStatus() {
        return status;
    }

    @JsonProperty
    public void setStatus(Response.Status status) {
        this.status = status;
    }

    @JsonProperty
    public List<String> getTimeLineResponse() {
        return timeLineResponse;
    }

    @JsonProperty
    public void setTimeLineResponse(List<String> timeLineResponse) {
        this.timeLineResponse = timeLineResponse;
    }

}
