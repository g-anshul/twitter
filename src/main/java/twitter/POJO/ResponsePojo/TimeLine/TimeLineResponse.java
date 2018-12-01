package twitter.POJO.ResponsePojo.TimeLine;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by anshul.gupta on 11/15/18.
 */
public class TimeLineResponse {
    private Response.Status status;
    private List<TimeLineSet> timeLineSet;

    @JsonProperty
    public Response.Status getStatus() {
        return status;
    }

    @JsonProperty
    public void setStatus(Response.Status status) {
        this.status = status;
    }

    @JsonProperty
    public void setTimeLineSet(List<TimeLineSet> timeLineSet) {
        this.timeLineSet = timeLineSet;
    }

    public List<TimeLineSet> getTimeLineSet() {
        return timeLineSet;
    }
}



