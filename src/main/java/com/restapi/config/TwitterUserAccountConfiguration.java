package com.restapi.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restapi.pojo.UserKeys;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by anshul.gupta on 11/14/18.
 */
public class TwitterUserAccountConfiguration extends Configuration{

    @Valid
    @NotNull
    @JsonProperty("UserKeys")
    private UserKeys UserKeys = new UserKeys();

    public UserKeys getUserKeys(){
        return UserKeys;
    }
}
