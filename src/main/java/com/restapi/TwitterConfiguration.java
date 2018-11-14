package com.restapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by anshul.gupta on 11/13/18.
 */
public class TwitterConfiguration extends Configuration {
    @NotEmpty
    private String message;

    @JsonProperty
    public String getMessage() {
        return message;
    }
}
