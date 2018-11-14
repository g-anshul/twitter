package com.restapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import twitter4j.Status;

import java.util.List;

/**
 * Created by anshul.gupta on 11/14/18.
 */
public class TimeLineResponse {

    private List<String> timeLineResponse;
    private Status status;

    @JsonProperty
    public Status getStatus(){
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    @JsonProperty
    public List<String> getTimeLineResponse(){
        return timeLineResponse;
    }

    public void setTimeLineResponse(List<String> timeLineResponse){
        this.timeLineResponse = timeLineResponse;
    }
}
