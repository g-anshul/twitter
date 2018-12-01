package twitter.POJO.ResponsePojo.TimeLine;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by anshul.gupta on 11/29/18.
 */
public class TimeLineSet {
    private Date timelineResponseDate;
    private Long timeLineResponseId;
    private String timeLineProfileImageUrl;
    private String timelineResponse;
    private String Url;


    public TimeLineSet(Date timelineResponseDate, Long timeLineResponseId, String timeLineProfileImageUrl, String Url, String timelineResponse) {
        this.timelineResponseDate = timelineResponseDate;
        this.timeLineResponseId = timeLineResponseId;
        this.timeLineProfileImageUrl = timeLineProfileImageUrl;
        this.Url = Url;
        this.timelineResponse = timelineResponse;
    }

    @JsonProperty
    public Long getTimeLineResponseId() {
        return timeLineResponseId;
    }

    public void setTimeLineResponseId(Long timeLineId) {
        this.timeLineResponseId = timeLineId;
    }

    @JsonProperty
    public String getTimeLineProfileImageUrl() {
        return timeLineProfileImageUrl;
    }

    public void setTimeLineProfileImageUrl(String timeLineProfileImageUrl) {
        this.timeLineProfileImageUrl = timeLineProfileImageUrl;
    }

    @JsonProperty
    public Date getTimelineResponseDate() {
        return timelineResponseDate;
    }

    public void setTimelineResponseDate(Date timelineResponseDate) {
        this.timelineResponseDate = timelineResponseDate;
    }

    @JsonProperty
    public String getTimelineResponse() {
        return timelineResponse;
    }

    public void setTimelineResponse(String timelineResponse) {
        this.timelineResponse = timelineResponse;
    }

    @JsonProperty
    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }


}
