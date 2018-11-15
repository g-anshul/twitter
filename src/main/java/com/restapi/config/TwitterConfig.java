package com.restapi.config;

import com.restapi.pojo.UserKeys;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

/**
 * Created by anshul.gupta on 11/15/18.
 */
public class TwitterConfig {

    public CommonConfig loadconfig() {
        Yaml yaml = new Yaml(new Constructor(CommonConfig.class));
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("tweet.yml");

        return (CommonConfig) yaml.load(inputStream);
    }
}
