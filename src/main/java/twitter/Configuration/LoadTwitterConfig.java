package twitter.Configuration;

import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import twitter.POJO.Configuration;

import java.io.InputStream;

/**
 * Created by anshul.gupta on 11/15/18.
 */
@Slf4j
public class LoadTwitterConfig {
    /***
     *
     * TODO : // read more about the below comments:
     *              1. Why type casting is needed
     *              2. LoadTwitterConfig.class.load is used?
     *
     */

    public Configuration loadConfig() {
        Yaml yaml = new Yaml(new Constructor(Configuration.class));
        InputStream inputStream = LoadTwitterConfig.class.getClassLoader().getResourceAsStream("yml/tweet.yml");
        return (Configuration) yaml.load(inputStream);
    }
}
