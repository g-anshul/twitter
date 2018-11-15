package com.restapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import twitter4j.ResponseList;
import twitter4j.Status;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by anshul.gupta on 11/14/18.
 */
public class TimeLineResponse {

    private List<String> timeLineResponse;
    private Response.Status status;

    @JsonProperty
    public Response.Status getStatus(){
        return status;
    }

    public void setStatus(Response.Status status){
        this.status = status;
    }

    @JsonProperty
    public List<String> getTimeLineResponse(){
        return timeLineResponse;
    }

    public void setTimeLineResponse(ResponseList<Status> timeLineList){
        this.timeLineResponse = timeLineResponse;
    }

    public void setStatus(Status ok) {
    }
}
