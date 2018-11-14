package com.restapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import twitter4j.Status;

/**
 * Created by anshul.gupta on 11/13/18.
 */
public class TwitterTweetResponse {
    private String message;
    private Status status;

    @JsonProperty
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
